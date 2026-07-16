/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.misfitcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.misfitcraft.block.TeardropBlossomBlock;
import net.mcreator.misfitcraft.MisfitcraftMod;

public class MisfitcraftModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(MisfitcraftMod.MODID);
	public static final DeferredBlock<Block> TEARDROP_BLOSSOM;
	static {
		TEARDROP_BLOSSOM = REGISTRY.register("teardrop_blossom", TeardropBlossomBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}