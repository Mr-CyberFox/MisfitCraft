package net.mcreator.misfitcraft.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class MagicPowerRegenProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(MisfitcraftModAttributes.MANA_TIMER))
			_livingEntity1.getAttribute(MisfitcraftModAttributes.MANA_TIMER).setBaseValue(
					((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(MisfitcraftModAttributes.MANA_TIMER) ? _livingEntity0.getAttribute(MisfitcraftModAttributes.MANA_TIMER).getBaseValue() : 0) + 1));
		if ((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(MisfitcraftModAttributes.MANA_TIMER) ? _livingEntity2.getAttribute(MisfitcraftModAttributes.MANA_TIMER).getBaseValue() : 0) >= 20) {
			if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(MisfitcraftModAttributes.MANA_TIMER))
				_livingEntity3.getAttribute(MisfitcraftModAttributes.MANA_TIMER).setBaseValue(0);
			if ((entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER)
					? _livingEntity4.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).getBaseValue()
					: 0) < (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER)
							? _livingEntity5.getAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER).getBaseValue()
							: 0)) {
				if (entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER))
					_livingEntity8.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).setBaseValue(
							((entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER) ? _livingEntity6.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).getBaseValue() : 0)
									+ (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER)
											? _livingEntity7.getAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER).getBaseValue()
											: 0) * 0.01));
				if ((entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER)
						? _livingEntity9.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).getBaseValue()
						: 0) > (entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER)
								? _livingEntity10.getAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER).getBaseValue()
								: 0)) {
					if (entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER))
						_livingEntity12.getAttribute(MisfitcraftModAttributes.MAGIC_POWER)
								.setBaseValue((entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER)
										? _livingEntity11.getAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER).getBaseValue()
										: 0));
				}
			}
		}
	}
}