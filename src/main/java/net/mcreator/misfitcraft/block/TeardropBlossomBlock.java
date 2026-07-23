package net.mcreator.misfitcraft.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class TeardropBlossomBlock extends FlowerBlock {
	public TeardropBlossomBlock() {
		super(MobEffects.LUCK, 100, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).instabreak().noCollission().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}
}