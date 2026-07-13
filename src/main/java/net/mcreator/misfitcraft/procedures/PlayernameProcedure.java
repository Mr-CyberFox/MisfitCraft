package net.mcreator.misfitcraft.procedures;

import net.minecraft.world.entity.Entity;

public class PlayernameProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getDisplayName().getString();
	}
}