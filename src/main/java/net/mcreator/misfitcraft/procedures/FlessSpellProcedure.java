package net.mcreator.misfitcraft.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.misfitcraft.init.MisfitcraftModAttributes;

public class FlessSpellProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			_player.getAbilities().flying = true;
			_player.onUpdateAbilities();
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
		if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER))
			_livingEntity3.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).setBaseValue(
					((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER) ? _livingEntity2.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).getBaseValue() : 0) - 100));
	}
}