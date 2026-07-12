package net.mcreator.misfitcraft.network;

@EventBusSubscriber
public record RaceGUISpiritButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<RaceGUISpiritButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MisfitcraftMod.MODID, "race_gui_spirit_buttons"));

	public static final StreamCodec<RegistryFriendlyByteBuf, RaceGUISpiritButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, RaceGUISpiritButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new RaceGUISpiritButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<RaceGUISpiritButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final RaceGUISpiritButtonMessage message, final IPayloadContext context) {
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

		if (buttonID == 1) {

			RaceGUISpiritpreviousProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			RaceGUISpiritnextProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MisfitcraftMod.addNetworkMessage(RaceGUISpiritButtonMessage.TYPE, RaceGUISpiritButtonMessage.STREAM_CODEC, RaceGUISpiritButtonMessage::handleData);
	}

}