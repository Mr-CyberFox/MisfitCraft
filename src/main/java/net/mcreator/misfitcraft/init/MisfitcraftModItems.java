/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.misfitcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.misfitcraft.item.HolyLakeLollyItem;
import net.mcreator.misfitcraft.MisfitcraftMod;

public class MisfitcraftModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(MisfitcraftMod.MODID);
	public static final DeferredItem<Item> TEARDROP_BLOSSOM;
	public static final DeferredItem<Item> HOLY_LAKE_LOLLY;
	static {
		TEARDROP_BLOSSOM = block(MisfitcraftModBlocks.TEARDROP_BLOSSOM);
		HOLY_LAKE_LOLLY = REGISTRY.register("holy_lake_lolly", HolyLakeLollyItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}