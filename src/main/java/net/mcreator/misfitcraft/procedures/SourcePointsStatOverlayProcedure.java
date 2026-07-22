package net.mcreator.misfitcraft.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.misfitcraft.init.MisfitcraftModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SourcePointsStatOverlayProcedure {
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
		return Math.round(entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(MisfitcraftModAttributes.SOURCE_POINTS) ? _livingEntity0.getAttribute(MisfitcraftModAttributes.SOURCE_POINTS).getBaseValue() : 0)
				+ "/"
				+ Math.round(entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(MisfitcraftModAttributes.MAX_SOURCE_POINTS)
						? _livingEntity1.getAttribute(MisfitcraftModAttributes.MAX_SOURCE_POINTS).getBaseValue()
						: 0);
	}
}