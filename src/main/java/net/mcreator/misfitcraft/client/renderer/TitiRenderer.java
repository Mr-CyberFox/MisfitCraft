package net.mcreator.misfitcraft.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.misfitcraft.entity.TitiEntity;
import net.mcreator.misfitcraft.client.model.ModelTiti;

public class TitiRenderer extends MobRenderer<TitiEntity, ModelTiti<TitiEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("misfitcraft:textures/entities/titi_texture.png");

	public TitiRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelTiti<TitiEntity>(context.bakeLayer(ModelTiti.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TitiEntity entity) {
		return entityTexture;
	}
}