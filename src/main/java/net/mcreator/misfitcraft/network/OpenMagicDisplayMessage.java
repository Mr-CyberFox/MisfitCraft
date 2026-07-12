package net.mcreator.misfitcraft.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.mcreator.misfitcraft.MisfitcraftMod;

@EventBusSubscriber
public record OpenMagicDisplayMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<OpenMagicDisplayMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MisfitcraftMod.MODID, "key_open_magic_display"));
	public static final StreamCodec<RegistryFriendlyByteBuf, OpenMagicDisplayMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, OpenMagicDisplayMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new OpenMagicDisplayMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<OpenMagicDisplayMessage> type() {
		return TYPE;
	}

	public static void handleData(final OpenMagicDisplayMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MisfitcraftMod.addNetworkMessage(OpenMagicDisplayMessage.TYPE, OpenMagicDisplayMessage.STREAM_CODEC, OpenMagicDisplayMessage::handleData);
	}
}