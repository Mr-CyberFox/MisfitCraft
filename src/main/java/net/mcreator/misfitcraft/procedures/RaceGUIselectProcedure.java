package net.mcreator.misfitcraft.procedures;

import net.neoforged.bus.api.Event;

public class RaceGUIselectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}