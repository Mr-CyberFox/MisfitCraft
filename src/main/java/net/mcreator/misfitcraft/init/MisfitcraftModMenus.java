/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.misfitcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.mcreator.misfitcraft.world.inventory.StatusMenuMenu;
import net.mcreator.misfitcraft.world.inventory.RaceGUIMenu;
import net.mcreator.misfitcraft.world.inventory.CastGUIMenu;
import net.mcreator.misfitcraft.network.MenuStateUpdateMessage;
import net.mcreator.misfitcraft.MisfitcraftMod;

import java.util.Map;

public class MisfitcraftModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, MisfitcraftMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<RaceGUIMenu>> RACE_GUI = REGISTRY.register("race_gui", () -> IMenuTypeExtension.create(RaceGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<StatusMenuMenu>> STATUS_MENU = REGISTRY.register("status_menu", () -> IMenuTypeExtension.create(StatusMenuMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CastGUIMenu>> CAST_GUI = REGISTRY.register("cast_gui", () -> IMenuTypeExtension.create(CastGUIMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof MisfitcraftModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				PacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}