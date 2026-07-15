package net.mcreator.misfitcraft.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.misfitcraft.init.MisfitcraftModAttributes;

public class RaceGUIMPDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Magic Power: " + ("1.000 - 2.000 100 - 200     500 - 700     600 - 800     ".substring(
				(int) ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE_NAVIGATION) ? _livingEntity0.getAttribute(MisfitcraftModAttributes.RACE_NAVIGATION).getBaseValue() : 0)
						* 14),
				(int) ((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE_NAVIGATION) ? _livingEntity1.getAttribute(MisfitcraftModAttributes.RACE_NAVIGATION).getBaseValue() : 0)
						* 14 + 14)));
	}
}