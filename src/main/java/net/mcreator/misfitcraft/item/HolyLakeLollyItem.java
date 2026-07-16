package net.mcreator.misfitcraft.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;

import net.mcreator.misfitcraft.procedures.EnterAharthernTriggerProcedure;

public class HolyLakeLollyItem extends Item {
	public HolyLakeLollyItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.3f).build()));
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack itemstack, Player entity) {
		EnterAharthernTriggerProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return true;
	}
}