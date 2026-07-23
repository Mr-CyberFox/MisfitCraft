/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.misfitcraft.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.misfitcraft.client.model.ModelTitiModel1;

@EventBusSubscriber(Dist.CLIENT)
public class MisfitcraftModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelTitiModel1.LAYER_LOCATION, ModelTitiModel1::createBodyLayer);
	}
}