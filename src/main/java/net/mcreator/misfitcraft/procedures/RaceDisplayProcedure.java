package net.mcreator.misfitcraft.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.misfitcraft.init.MisfitcraftModAttributes;

public class RaceDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity0.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) == 0) {
			return "//////////";
		} else if ((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity1.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) >= 1
				&& (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity2.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) <= 4) {
			return "Demon               Demon Royal         Mythical Era Demon  Misfit              ".substring(
					(int) ((entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity3.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) * 20),
					(int) ((entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity4.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) * 20 + 20));
		} else if ((entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity5.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) >= 5
				&& (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity6.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) <= 8) {
			return "Human         Hero Student  Hero          Legendary Hero".substring(
					(int) (((entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity7.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) - 4) * 14),
					(int) (((entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity8.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) - 4) * 14
							+ 14));
		} else if ((entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity9.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) >= 9
				&& (entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity10.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) <= 11) {
			return "Half Spirit Spirit      Great Spirit".substring(
					(int) (((entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity11.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) - 8) * 12),
					(int) (((entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity12.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) - 8) * 12
							+ 12));
		} else if ((entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity13.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) >= 12
				&& (entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity14.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) <= 15) {
			return "Draconid      Draconid SaintDraconid Pope Dragonborn    ".substring(
					(int) (((entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity15.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) - 11) * 14),
					(int) (((entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity16.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) - 11) * 14
							+ 14));
		} else if ((entity instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity17.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) >= 16
				&& (entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity18.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) <= 18) {
			return "Keeper   God      Chief God".substring(
					(int) (((entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity19.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) - 15) * 9),
					(int) (((entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE) ? _livingEntity20.getAttribute(MisfitcraftModAttributes.RACE).getBaseValue() : 0) - 15) * 9
							+ 9));
		}
		return "ERROR 404";
	}
}