package net.mcreator.misfitcraft.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.misfitcraft.init.MisfitcraftModAttributes;

public class StatusMenuMPMaxDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "" + Math
				.round(entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER) ? _livingEntity0.getAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER).getBaseValue() : 0);
	}
}