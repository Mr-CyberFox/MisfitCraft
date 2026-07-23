package net.mcreator.misfitcraft.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class MushroomGratinItem extends Item {
	public MushroomGratinItem() {
		super(new Item.Properties().stacksTo(1).food((new FoodProperties.Builder()).nutrition(20).saturationModifier(20f).build()));
	}
}