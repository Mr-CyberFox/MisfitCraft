package net.mcreator.misfitcraft.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.misfitcraft.world.inventory.RaceGUIMenu;
import net.mcreator.misfitcraft.init.MisfitcraftModAttributes;

public class RaceGUIselectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _plr0 && _plr0.containerMenu instanceof RaceGUIMenu) {
			if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER))
				_livingEntity2.getAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER).setBaseValue(Math.ceil(Mth.nextDouble(RandomSource.create(), 1000, 2000)));
			if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE))
				_livingEntity3.getAttribute(MisfitcraftModAttributes.RACE).setBaseValue(1);
			if (entity instanceof Player _player)
				_player.closeContainer();
		} else {
			if (entity instanceof Player _plr5 && _plr5.containerMenu instanceof RaceGUIMenu) {
				if (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER))
					_livingEntity7.getAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER).setBaseValue(Math.ceil(Mth.nextDouble(RandomSource.create(), 400, 500)));
				if (entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE))
					_livingEntity8.getAttribute(MisfitcraftModAttributes.RACE).setBaseValue(2);
				if (entity instanceof Player _player)
					_player.closeContainer();
			} else {
				if (entity instanceof Player _plr10 && _plr10.containerMenu instanceof RaceGUIMenu) {
					if (entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER))
						_livingEntity12.getAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER).setBaseValue(Math.ceil(Mth.nextDouble(RandomSource.create(), 700, 1000)));
					if (entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE))
						_livingEntity13.getAttribute(MisfitcraftModAttributes.RACE).setBaseValue(3);
					if (entity instanceof Player _player)
						_player.closeContainer();
				} else {
					if (entity instanceof Player _plr15 && _plr15.containerMenu instanceof RaceGUIMenu) {
						if (entity instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER))
							_livingEntity17.getAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER).setBaseValue(Math.ceil(Mth.nextDouble(RandomSource.create(), 600, 800)));
						if (entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE))
							_livingEntity18.getAttribute(MisfitcraftModAttributes.RACE).setBaseValue(4);
						if (entity instanceof Player _player)
							_player.closeContainer();
					}
				}
			}
		}
	}
}