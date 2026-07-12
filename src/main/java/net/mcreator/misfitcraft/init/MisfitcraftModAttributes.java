/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.misfitcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.misfitcraft.MisfitcraftMod;

@EventBusSubscriber
public class MisfitcraftModAttributes {
	public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, MisfitcraftMod.MODID);
	public static final DeferredHolder<Attribute, Attribute> MAGIC_POWER = REGISTRY.register("magic_power", () -> new RangedAttribute("attribute.misfitcraft.magic_power", 100, 0, 100).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> SOURCE_POINTS = REGISTRY.register("source_points", () -> new RangedAttribute("attribute.misfitcraft.source_points", 100, 0, 100).setSyncable(true));

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.getTypes().forEach(entity -> event.add(entity, MAGIC_POWER));
		event.getTypes().forEach(entity -> event.add(entity, SOURCE_POINTS));
	}
}