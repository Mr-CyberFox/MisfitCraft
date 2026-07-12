/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.misfitcraft.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.misfitcraft.client.gui.RaceGUISpiritScreen;
import net.mcreator.misfitcraft.client.gui.RaceGUIScreen;
import net.mcreator.misfitcraft.client.gui.RaceGUIHumanScreen;
import net.mcreator.misfitcraft.client.gui.RaceGUIDraconidScreen;

@EventBusSubscriber(Dist.CLIENT)
public class MisfitcraftModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(MisfitcraftModMenus.RACE_GUI.get(), RaceGUIScreen::new);
		event.register(MisfitcraftModMenus.RACE_GUI_HUMAN.get(), RaceGUIHumanScreen::new);
		event.register(MisfitcraftModMenus.RACE_GUI_SPIRIT.get(), RaceGUISpiritScreen::new);
		event.register(MisfitcraftModMenus.RACE_GUI_DRACONID.get(), RaceGUIDraconidScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}