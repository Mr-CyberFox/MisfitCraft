package net.mcreator.misfitcraft.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.misfitcraft.init.MisfitcraftModAttributes;

public class RaceGUIHealthDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Health: " + ("50203535".substring(
				(int) ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE_NAVIGATION) ? _livingEntity0.getAttribute(MisfitcraftModAttributes.RACE_NAVIGATION).getBaseValue() : 0)
						* 2),
				(int) ((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE_NAVIGATION) ? _livingEntity1.getAttribute(MisfitcraftModAttributes.RACE_NAVIGATION).getBaseValue() : 0)
						* 2 + 2)));
	}
}