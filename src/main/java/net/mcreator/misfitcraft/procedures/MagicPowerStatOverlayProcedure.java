package net.mcreator.misfitcraft.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class MagicPowerStatOverlayProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity());
	}

	public static String execute(Entity entity) {
		return execute(null, entity);
	}

	private static String execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return "";
		String MP = "";
		double MP1 = 0;
		return (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(MisfitcraftModAttributes.MAGIC_POWER) ? _livingEntity0.getAttribute(MisfitcraftModAttributes.MAGIC_POWER).getBaseValue() : 0) + ""
				+ (" / " + (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(MisfitcraftModAttributes.DELETED_MOD_ELEMENT)
						? _livingEntity1.getAttribute(MisfitcraftModAttributes.DELETED_MOD_ELEMENT).getBaseValue()
						: 0));
	}
}