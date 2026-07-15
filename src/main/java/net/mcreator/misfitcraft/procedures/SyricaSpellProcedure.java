package net.mcreator.misfitcraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.misfitcraft.init.MisfitcraftModAttributes;

public class SyricaSpellProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER) ? _livingEntity0.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).getBaseValue() : 0) >= 1000) {
			if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER))
				_livingEntity2.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).setBaseValue(
						((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER) ? _livingEntity1.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).getBaseValue() : 0)
								- 1000));
			if (entity instanceof Player _player)
				_player.closeContainer();
			if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(MisfitcraftModAttributes.RACE))
				_livingEntity4.getAttribute(MisfitcraftModAttributes.RACE).setBaseValue(0);
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), 9999);
		}
	}
}