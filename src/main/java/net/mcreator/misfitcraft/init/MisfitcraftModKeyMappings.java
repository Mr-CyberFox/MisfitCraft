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

import net.mcreator.misfitcraft.network.OpenStatusMenuMessage;
import net.mcreator.misfitcraft.network.MagicTestButtonMessage;

@EventBusSubscriber(Dist.CLIENT)
public class MisfitcraftModKeyMappings {
	public static final KeyMapping MAGIC_TEST_BUTTON = new KeyMapping("key.misfitcraft.magic_test_button", GLFW.GLFW_KEY_X, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new MagicTestButtonMessage(0, 0));
				MagicTestButtonMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPEN_STATUS_MENU = new KeyMapping("key.misfitcraft.open_status_menu", GLFW.GLFW_KEY_B, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new OpenStatusMenuMessage(0, 0));
				OpenStatusMenuMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(MAGIC_TEST_BUTTON);
		event.register(OPEN_STATUS_MENU);
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				MAGIC_TEST_BUTTON.consumeClick();
				OPEN_STATUS_MENU.consumeClick();
			}
		}
	}
}