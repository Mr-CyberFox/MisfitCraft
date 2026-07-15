package net.mcreator.misfitcraft.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.misfitcraft.init.MisfitcraftModAttributes;

public class RaceGUIDifficultyDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Difficulty: " + ("Easy  Hard  MediumMedium".substring(
				(int) ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE_NAVIGATION) ? _livingEntity0.getAttribute(MisfitcraftModAttributes.RACE_NAVIGATION).getBaseValue() : 0)
						* 6),
				(int) ((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE_NAVIGATION) ? _livingEntity1.getAttribute(MisfitcraftModAttributes.RACE_NAVIGATION).getBaseValue() : 0)
						* 6 + 6)));
	}
}