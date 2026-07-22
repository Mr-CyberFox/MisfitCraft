/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.misfitcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.misfitcraft.MisfitcraftMod;

@EventBusSubscriber
public class MisfitcraftModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MisfitcraftMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ITEMS_CREATIVE_TAB = REGISTRY.register("items_creative_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.misfitcraft.items_creative_tab")).icon(() -> new ItemStack(MisfitcraftModItems.HOLY_LAKE_LOLLY.get())).displayItems((parameters, tabData) -> {
				tabData.accept(MisfitcraftModBlocks.TEARDROP_BLOSSOM.get().asItem());
				tabData.accept(MisfitcraftModItems.HOLY_LAKE_LOLLY.get());
				tabData.accept(MisfitcraftModItems.MUSHROOM_GRATIN.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(MisfitcraftModItems.TITI_SPAWN_EGG.get());
		}
	}
}