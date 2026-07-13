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
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.misfitcraft.MisfitcraftMod;

@EventBusSubscriber
public class MisfitcraftModAttributes {
	public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, MisfitcraftMod.MODID);
	public static final DeferredHolder<Attribute, Attribute> MAGIC_POWER = REGISTRY.register("magic_power", () -> new RangedAttribute("attribute.misfitcraft.magic_power", 100, 0, 1000000000).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> SOURCE_POINTS = REGISTRY.register("source_points", () -> new RangedAttribute("attribute.misfitcraft.source_points", 20, 0, 5000).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> MANA_TIMER = REGISTRY.register("mana_timer", () -> new RangedAttribute("attribute.misfitcraft.mana_timer", 0, 0, 20).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> MAX_MAGIC_POWER = REGISTRY.register("max_magic_power", () -> new RangedAttribute("attribute.misfitcraft.max_magic_power", 100, 0, 1000000000).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> RACE = REGISTRY.register("race", () -> new RangedAttribute("attribute.misfitcraft.race", 0, 0, 4).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> MAX_SOURCE_POINTS = REGISTRY.register("max_source_points", () -> new RangedAttribute("attribute.misfitcraft.max_source_points", 20, 0, 10000).setSyncable(true));

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.getTypes().forEach(entity -> event.add(entity, MAGIC_POWER));
		event.add(EntityType.PLAYER, SOURCE_POINTS);
		event.add(EntityType.PLAYER, MANA_TIMER);
		event.getTypes().forEach(entity -> event.add(entity, MAX_MAGIC_POWER));
		event.add(EntityType.PLAYER, RACE);
		event.add(EntityType.PLAYER, MAX_SOURCE_POINTS);
	}
}