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

import net.mcreator.misfitcraft.procedures.RaceGUIselectProcedure;
import net.mcreator.misfitcraft.procedures.RaceGUIpreviousProcedure;
import net.mcreator.misfitcraft.procedures.RaceGUInextProcedure;
import net.mcreator.misfitcraft.MisfitcraftMod;

@EventBusSubscriber
public record RaceGUIHumanButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<RaceGUIHumanButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MisfitcraftMod.MODID, "race_gui_human_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, RaceGUIHumanButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, RaceGUIHumanButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new RaceGUIHumanButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<RaceGUIHumanButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final RaceGUIHumanButtonMessage message, final IPayloadContext context) {
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

			RaceGUIselectProcedure.execute(entity);
		}
		if (buttonID == 1) {

			RaceGUIpreviousProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			RaceGUInextProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MisfitcraftMod.addNetworkMessage(RaceGUIHumanButtonMessage.TYPE, RaceGUIHumanButtonMessage.STREAM_CODEC, RaceGUIHumanButtonMessage::handleData);
	}
}