package net.mcreator.misfitcraft.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class SourcePointDeathProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(MisfitcraftModAttributes.SOURCE_POINTS) ? _livingEntity0.getAttribute(MisfitcraftModAttributes.SOURCE_POINTS).getBaseValue() : 0) <= 0) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), 9999);
		}
	}
}