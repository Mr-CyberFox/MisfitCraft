package net.mcreator.misfitcraft.network;

import net.mcreator.misfitcraft.MisfitcraftMod;

@EventBusSubscriber
public record OpenStatusMenuMessage(int eventType, int pressedms) implements CustomPacketPayload {

	public static final Type<OpenStatusMenuMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MisfitcraftMod.MODID, "key_open_status_menu"));

	public static final StreamCodec<RegistryFriendlyByteBuf, OpenStatusMenuMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, OpenStatusMenuMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new OpenStatusMenuMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<OpenStatusMenuMessage> type() {
		return TYPE;
	}

	public static void handleData(final OpenStatusMenuMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				pressAction(context.player(), message.eventType, message.pressedms);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;

		if (type == 0) {

			StatusMenuOpenProcedure.execute(world, x, y, z, entity);
		}

	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MisfitcraftMod.addNetworkMessage(OpenStatusMenuMessage.TYPE, OpenStatusMenuMessage.STREAM_CODEC, OpenStatusMenuMessage::handleData);
	}

}