package net.mcreator.misfitcraft.procedures;

import net.neoforged.bus.api.Event;

public class SourcePointsStatOverlayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(MisfitcraftModAttributes.SOURCE_POINTS) ? _livingEntity0.getAttribute(MisfitcraftModAttributes.SOURCE_POINTS).getBaseValue() : 0) + " / "
				+ (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(MisfitcraftModAttributes.MAX_SOURCE_POINTS) ? _livingEntity1.getAttribute(MisfitcraftModAttributes.MAX_SOURCE_POINTS).getBaseValue() : 0);
	}
}