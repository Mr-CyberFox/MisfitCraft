package net.mcreator.misfitcraft.item;

public class RecordingCrystalItem extends Item {
	public RecordingCrystalItem() {
		super(new Item.Properties());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}