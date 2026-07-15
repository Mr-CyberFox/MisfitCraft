package net.mcreator.misfitcraft.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.misfitcraft.init.MisfitcraftModAttributes;

public class EntSpellProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER) ? _livingEntity0.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).getBaseValue() : 0) >= 200) {
			if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER))
				_livingEntity2.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).setBaseValue(
						((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER) ? _livingEntity1.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).getBaseValue() : 0)
								- 200));
			if (entity instanceof Player _player)
				_player.closeContainer();
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.2));
		}
	}
}