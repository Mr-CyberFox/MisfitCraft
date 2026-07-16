package net.mcreator.misfitcraft.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class HolyLakeLollyItem extends Item {
	public HolyLakeLollyItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.3f).build()));
	}
}