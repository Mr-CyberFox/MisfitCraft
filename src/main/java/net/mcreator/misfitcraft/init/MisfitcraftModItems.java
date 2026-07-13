/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.misfitcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.misfitcraft.item.AharthernDimensionItem;
import net.mcreator.misfitcraft.MisfitcraftMod;

public class MisfitcraftModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(MisfitcraftMod.MODID);
	public static final DeferredItem<Item> AHARTHERN_DIMENSION;
	static {
		AHARTHERN_DIMENSION = REGISTRY.register("aharthern_dimension", AharthernDimensionItem::new);
	}
	// Start of user code block custom items
	// End of user code block custom items
}