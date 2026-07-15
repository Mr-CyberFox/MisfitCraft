package net.mcreator.misfitcraft.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.misfitcraft.init.MisfitcraftModAttributes;

public class RaceGUIselectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE_NAVIGATION) ? _livingEntity0.getAttribute(MisfitcraftModAttributes.RACE_NAVIGATION).getBaseValue() : 0) == 0) {
			if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER))
				_livingEntity2.getAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER).setBaseValue(Math.ceil(Mth.nextDouble(RandomSource.create(), 1000, 2000)));
			if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE))
				_livingEntity3.getAttribute(MisfitcraftModAttributes.RACE).setBaseValue(1);
			if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
				_livingEntity4.getAttribute(Attributes.MAX_HEALTH).setBaseValue(50);
			if (entity instanceof Player _player)
				_player.closeContainer();
		} else {
			if ((entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE_NAVIGATION)
					? _livingEntity6.getAttribute(MisfitcraftModAttributes.RACE_NAVIGATION).getBaseValue()
					: 0) == 1) {
				if (entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER))
					_livingEntity8.getAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER).setBaseValue(Math.ceil(Mth.nextDouble(RandomSource.create(), 100, 200)));
				if (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE))
					_livingEntity9.getAttribute(MisfitcraftModAttributes.RACE).setBaseValue(5);
				if (entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
					_livingEntity10.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20);
				if (entity instanceof Player _player)
					_player.closeContainer();
			} else {
				if ((entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE_NAVIGATION)
						? _livingEntity12.getAttribute(MisfitcraftModAttributes.RACE_NAVIGATION).getBaseValue()
						: 0) == 2) {
					if (entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER))
						_livingEntity14.getAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER).setBaseValue(Math.ceil(Mth.nextDouble(RandomSource.create(), 500, 700)));
					if (entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE))
						_livingEntity15.getAttribute(MisfitcraftModAttributes.RACE).setBaseValue(9);
					if (entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity16.getAttribute(Attributes.MAX_HEALTH).setBaseValue(35);
					if (entity instanceof Player _player)
						_player.closeContainer();
				} else {
					if ((entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE_NAVIGATION)
							? _livingEntity18.getAttribute(MisfitcraftModAttributes.RACE_NAVIGATION).getBaseValue()
							: 0) == 3) {
						if (entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER))
							_livingEntity20.getAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER).setBaseValue(Math.ceil(Mth.nextDouble(RandomSource.create(), 600, 800)));
						if (entity instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE))
							_livingEntity21.getAttribute(MisfitcraftModAttributes.RACE).setBaseValue(12);
						if (entity instanceof LivingEntity _livingEntity22 && _livingEntity22.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
							_livingEntity22.getAttribute(Attributes.MAX_HEALTH).setBaseValue(35);
						if (entity instanceof Player _player)
							_player.closeContainer();
					}
				}
			}
		}
	}
}