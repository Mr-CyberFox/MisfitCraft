package net.mcreator.misfitcraft.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.misfitcraft.init.MisfitcraftModAttributes;

public class EntSpellProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.2));
		if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER))
			_livingEntity4.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).setBaseValue(
					((entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER) ? _livingEntity3.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).getBaseValue() : 0) - 200));
	}
}