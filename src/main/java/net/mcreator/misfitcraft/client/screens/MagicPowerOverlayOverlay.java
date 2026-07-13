package net.mcreator.misfitcraft.client.screens;

@EventBusSubscriber(Dist.CLIENT)
public class MagicPowerOverlayOverlay {

	@SubscribeEvent(priority = EventPriority.HIGHEST)
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

			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.misfitcraft.magic_power_overlay.label_magic_power"), 6, 8, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					MagicPowerStatOverlayProcedure.execute(entity), 6, 26, -1, false);

		}

	}

}