package net.mcreator.misfitcraft.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.misfitcraft.procedures.SourcePointsStatOverlayProcedure;
import net.mcreator.misfitcraft.procedures.MagicPowerStatOverlayProcedure;

@EventBusSubscriber(Dist.CLIENT)
public class POVOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (true) {
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.misfitcraft.pov_overlay.label_magic_power"), 6, 8, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					MagicPowerStatOverlayProcedure.execute(entity), 6, 17, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.misfitcraft.pov_overlay.label_source_points"), 6, 35, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					SourcePointsStatOverlayProcedure.execute(entity), 6, 44, -1, false);
		}
	}
}