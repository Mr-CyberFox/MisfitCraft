package net.mcreator.misfitcraft.procedures;

import net.neoforged.bus.api.Event;

public class RaceGUIselectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _plr0 && _plr0.containerMenu instanceof RaceGUIMenu) {
			if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER))
				_livingEntity2.getAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER).setBaseValue(Math.ceil(Mth.nextDouble(RandomSource.create(), 1000, 2000)));
			if (entity instanceof Player _player)
				_player.closeContainer();
		} else {
			if (entity instanceof Player _plr4 && _plr4.containerMenu instanceof RaceGUIHumanMenu) {
				if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER))
					_livingEntity6.getAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER).setBaseValue(Math.ceil(Mth.nextDouble(RandomSource.create(), 400, 500)));
				if (entity instanceof Player _player)
					_player.closeContainer();
			} else {
				if (entity instanceof Player _plr8 && _plr8.containerMenu instanceof RaceGUISpiritMenu) {
					if (entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER))
						_livingEntity10.getAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER).setBaseValue(Math.ceil(Mth.nextDouble(RandomSource.create(), 700, 1000)));
					if (entity instanceof Player _player)
						_player.closeContainer();
				} else {
					if (entity instanceof Player _plr12 && _plr12.containerMenu instanceof RaceGUIDraconidMenu) {
						if (entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER))
							_livingEntity14.getAttribute(MisfitcraftModAttributes.MAX_MAGIC_POWER).setBaseValue(Math.ceil(Mth.nextDouble(RandomSource.create(), 600, 800)));
						if (entity instanceof Player _player)
							_player.closeContainer();
					}
				}
			}
		}
	}
}