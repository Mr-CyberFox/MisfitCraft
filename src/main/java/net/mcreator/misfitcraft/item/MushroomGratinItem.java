package net.mcreator.misfitcraft.item;

public class MushroomGratinItem extends Item {
	public MushroomGratinItem() {
		super(new Item.Properties().stacksTo(1).food((new FoodProperties.Builder()).nutrition(20).saturationModifier(20f).build()));
	}
}