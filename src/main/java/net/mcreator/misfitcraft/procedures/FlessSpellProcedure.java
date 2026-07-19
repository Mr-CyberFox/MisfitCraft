package net.mcreator.misfitcraft.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.misfitcraft.init.MisfitcraftModAttributes;

public class FlessSpellProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER) ? _livingEntity0.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).getBaseValue() : 0) >= 100) {
			if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER))
				_livingEntity2.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).setBaseValue(
						((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER) ? _livingEntity1.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).getBaseValue() : 0)
								- 100));
			if (entity instanceof Player _player)
				_player.closeContainer();
			{
				Entity _ent = entity;
				_ent.teleportTo((entity.getX()), (entity.getY() + 0.1), (entity.getZ()));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((entity.getX()), (entity.getY() + 0.1), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
			}
			if (entity instanceof Player _player) {
				_player.getAbilities().flying = true;
				_player.onUpdateAbilities();
			}
		}
	}
}