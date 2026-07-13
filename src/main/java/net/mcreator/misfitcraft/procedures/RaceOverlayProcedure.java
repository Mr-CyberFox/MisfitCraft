package net.mcreator.misfitcraft.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.misfitcraft.init.MisfitcraftModAttributes;

public class RaceOverlayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "/////     Demon     Human     Spirit    Draconid  ".substring(
				(int) ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity0.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) * 10),
				(int) ((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity1.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) * 10 + 10));
	}
}