package net.mcreator.misfitcraft.network;

import net.mcreator.misfitcraft.MisfitcraftMod;

@EventBusSubscriber
public record RaceGUIOpenKeyMessage(int eventType, int pressedms) implements CustomPacketPayload {

	public static final Type<RaceGUIOpenKeyMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MisfitcraftMod.MODID, "key_race_gui_open_key"));

	public static final StreamCodec<RegistryFriendlyByteBuf, RaceGUIOpenKeyMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, RaceGUIOpenKeyMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new RaceGUIOpenKeyMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<RaceGUIOpenKeyMessage> type() {
		return TYPE;
	}

	public static void handleData(final RaceGUIOpenKeyMessage message, final IPayloadContext context) {
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
		MisfitcraftMod.addNetworkMessage(RaceGUIOpenKeyMessage.TYPE, RaceGUIOpenKeyMessage.STREAM_CODEC, RaceGUIOpenKeyMessage::handleData);
	}

}