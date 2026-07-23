package net.mcreator.misfitcraft.client.screens;

@EventBusSubscriber(Dist.CLIENT)
public class SourcePointsOverlayOverlay {

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

			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.misfitcraft.source_points_overlay.label_source_points"), w / 2 + 135, h / 2 + -125, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					SourcePointsStatOverlayProcedure.execute(entity), w / 2 + 135, h / 2 + -106, -1, false);

		}

	}

}