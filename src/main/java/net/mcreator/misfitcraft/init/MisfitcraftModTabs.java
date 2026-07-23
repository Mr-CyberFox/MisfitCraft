/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.misfitcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.misfitcraft.MisfitcraftMod;

public class MisfitcraftModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MisfitcraftMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ITEMS_CREATIVE_TAB = REGISTRY.register("items_creative_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.misfitcraft.items_creative_tab")).icon(() -> new ItemStack(MisfitcraftModItems.RECORDING_CRYSTAL.get())).displayItems((parameters, tabData) -> {
				tabData.accept(MisfitcraftModBlocks.TEARDROP_BLOSSOM.get().asItem());
				tabData.accept(MisfitcraftModItems.HOLY_LAKE_LOLLY.get());
				tabData.accept(MisfitcraftModItems.MUSHROOM_GRATIN.get());
				tabData.accept(MisfitcraftModItems.TITI_SPAWN_EGG.get());
				tabData.accept(MisfitcraftModItems.RECORDING_CRYSTAL.get());
			}).build());
}