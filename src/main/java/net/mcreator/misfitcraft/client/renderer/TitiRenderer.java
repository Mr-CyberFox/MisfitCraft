package net.mcreator.misfitcraft.client.renderer;

public class TitiRenderer extends MobRenderer<TitiEntity, ModelTitiModel1<TitiEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("misfitcraft:textures/entities/tititexture1.png");

	public TitiRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelTitiModel1<TitiEntity>(context.bakeLayer(ModelTitiModel1.LAYER_LOCATION)), 0.2f);
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