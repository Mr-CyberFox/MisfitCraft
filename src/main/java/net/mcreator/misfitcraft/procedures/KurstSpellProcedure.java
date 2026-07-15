package net.mcreator.misfitcraft.procedures;

import net.neoforged.bus.api.Event;

public class KurstSpellProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER) ? _livingEntity0.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).getBaseValue() : 0) >= 100) {
			if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER))
				_livingEntity2.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).setBaseValue(
						((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER) ? _livingEntity1.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).getBaseValue() : 0)
								- 100));
			if (entity instanceof Player _player)
				_player.closeContainer();
			if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.SCALE))
				_livingEntity4.getAttribute(Attributes.SCALE).setBaseValue(1);
		}
	}
}