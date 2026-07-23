package net.mcreator.misfitcraft.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class LeaveUndergroundWorldTriggerProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getPos().getY(), event.getLevel().getBlockState(event.getPos()), event.getEntity());
	}

	public static void execute(double y, BlockState blockstate, Entity entity) {
		execute(null, y, blockstate, entity);
	}

	private static void execute(@Nullable Event event, double y, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if (ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("misfitcraft:deleted_mod_element")) == (entity.level().dimension())) {
			if (blockstate.getBlock() == Blocks.BEDROCK) {
				if (y >= 123) {
					if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
						ResourceKey<Level> destinationType = Level.OVERWORLD;
						if (_player.level().dimension() == destinationType)
							return;
						ServerLevel nextLevel = _player.server.getLevel(destinationType);
						if (nextLevel != null) {
							_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
							_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
							_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
							for (MobEffectInstance _effectinstance : _player.getActiveEffects())
								_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
							_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
						}
					}
				}
			}
		}
	}
}