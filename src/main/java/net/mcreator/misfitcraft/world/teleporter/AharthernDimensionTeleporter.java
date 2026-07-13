package net.mcreator.misfitcraft.world.teleporter;

@EventBusSubscriber
public class AharthernDimensionTeleporter {

	public static Holder<PoiType> poi = null;

	@SubscribeEvent
	public static void registerPointOfInterest(RegisterEvent event) {
		event.register(Registries.POINT_OF_INTEREST_TYPE, registerHelper -> {
			PoiType poiType = new PoiType(ImmutableSet.copyOf(MisfitcraftModBlocks.AHARTHERN_DIMENSION_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1);
			registerHelper.register(ResourceLocation.parse("misfitcraft:aharthern_dimension_portal"), poiType);
			poi = BuiltInRegistries.POINT_OF_INTEREST_TYPE.wrapAsHolder(poiType);
		});
	}

	private final ServerLevel level;

	public AharthernDimensionTeleporter(ServerLevel level) {
		this.level = level;
	}

	/* failed to load code for net.minecraft.world.level.portal.PortalForcer */

	/* failed to load code for net.minecraft.world.level.portal.PortalForcer */

	/* failed to load code for net.minecraft.world.level.portal.PortalForcer */

	private boolean canPortalReplaceBlock(BlockPos.MutableBlockPos pos) {
		BlockState blockstate = this.level.getBlockState(pos);
		return blockstate.canBeReplaced() && blockstate.getFluidState().isEmpty();
	}

}