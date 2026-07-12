/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.misfitcraft.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.misfitcraft.network.RaceGUIOpenKeyMessage;

@EventBusSubscriber(Dist.CLIENT)
public class MisfitcraftModKeyMappings {
	public static final KeyMapping OPEN_MAGIC_DISPLAY = new KeyMapping("key.misfitcraft.open_magic_display", GLFW.GLFW_KEY_O, "key.categories.misc");
	public static final KeyMapping RACE_GUI_OPEN_KEY = new KeyMapping("key.misfitcraft.race_gui_open_key", GLFW.GLFW_KEY_B, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new RaceGUIOpenKeyMessage(0, 0));
				RaceGUIOpenKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(OPEN_MAGIC_DISPLAY);
		event.register(RACE_GUI_OPEN_KEY);
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				RACE_GUI_OPEN_KEY.consumeClick();
			}
		}
	}
}