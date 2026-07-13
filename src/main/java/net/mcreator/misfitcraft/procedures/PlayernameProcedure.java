package net.mcreator.misfitcraft.procedures;

import net.neoforged.bus.api.Event;

public class PlayernameProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getDisplayName().getString();
	}
}