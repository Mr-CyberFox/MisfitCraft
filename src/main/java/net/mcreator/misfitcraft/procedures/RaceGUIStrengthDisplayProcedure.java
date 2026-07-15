package net.mcreator.misfitcraft.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.misfitcraft.init.MisfitcraftModAttributes;

public class RaceGUIStrengthDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Strength: " + ("High Stats  Holy Magic  Spirit MagicDragon Art  ".substring(
				(int) ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE_NAVIGATION) ? _livingEntity0.getAttribute(MisfitcraftModAttributes.RACE_NAVIGATION).getBaseValue() : 0)
						* 12),
				(int) ((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE_NAVIGATION) ? _livingEntity1.getAttribute(MisfitcraftModAttributes.RACE_NAVIGATION).getBaseValue() : 0)
						* 12 + 12)));
	}
}