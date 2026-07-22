package net.mcreator.misfitcraft.client.renderer;

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