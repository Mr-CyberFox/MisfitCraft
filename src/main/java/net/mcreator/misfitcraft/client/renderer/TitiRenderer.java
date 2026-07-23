package net.mcreator.misfitcraft.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.misfitcraft.entity.TitiEntity;
import net.mcreator.misfitcraft.client.model.ModelTitiModel;

import com.mojang.blaze3d.vertex.PoseStack;

public class TitiRenderer extends MobRenderer<TitiEntity, ModelTitiModel<TitiEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("misfitcraft:textures/entities/tititexture.png");

	public TitiRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelTitiModel<TitiEntity>(context.bakeLayer(ModelTitiModel.LAYER_LOCATION)), 0.2f);
	}

	@Override
	protected void scale(TitiEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.4f, 0.4f, 0.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(TitiEntity entity) {
		return entityTexture;
	}
}