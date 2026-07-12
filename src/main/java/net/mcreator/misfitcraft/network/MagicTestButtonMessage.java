package net.mcreator.misfitcraft.network;

import net.mcreator.misfitcraft.MisfitcraftMod;

@EventBusSubscriber
public record MagicTestButtonMessage(int eventType, int pressedms) implements CustomPacketPayload {

	public static final Type<MagicTestButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MisfitcraftMod.MODID, "key_magic_test_button"));

	public static final StreamCodec<RegistryFriendlyByteBuf, MagicTestButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, MagicTestButtonMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new MagicTestButtonMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<MagicTestButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final MagicTestButtonMessage message, final IPayloadContext context) {
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
		MisfitcraftMod.addNetworkMessage(MagicTestButtonMessage.TYPE, MagicTestButtonMessage.STREAM_CODEC, MagicTestButtonMessage::handleData);
	}

}