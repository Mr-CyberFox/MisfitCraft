package net.mcreator.misfitcraft.client.renderer;

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