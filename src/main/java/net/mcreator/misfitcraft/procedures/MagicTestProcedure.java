package net.mcreator.misfitcraft.procedures;

import net.neoforged.bus.api.Event;

public class MagicTestProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER))
			_livingEntity1.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).setBaseValue(
					((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER) ? _livingEntity0.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).getBaseValue() : 0) - 20));
	}
}