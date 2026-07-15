package net.mcreator.misfitcraft.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;

import net.mcreator.misfitcraft.procedures.FlessSpellProcedure;
import net.mcreator.misfitcraft.procedures.EntSpellProcedure;
import net.mcreator.misfitcraft.procedures.EnchelSpellProcedure;
import net.mcreator.misfitcraft.procedures.EiChaelSpellProcedure;
import net.mcreator.misfitcraft.MisfitcraftMod;

@EventBusSubscriber
public record CastGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<CastGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MisfitcraftMod.MODID, "cast_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, CastGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, CastGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new CastGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<CastGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final CastGUIButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (buttonID == 0) {

			FlessSpellProcedure.execute(entity);
		}
		if (buttonID == 1) {

			EntSpellProcedure.execute(entity);
		}
		if (buttonID == 2) {

			EnchelSpellProcedure.execute(entity);
		}
		if (buttonID == 3) {

			EiChaelSpellProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MisfitcraftMod.addNetworkMessage(CastGUIButtonMessage.TYPE, CastGUIButtonMessage.STREAM_CODEC, CastGUIButtonMessage::handleData);
	}
}