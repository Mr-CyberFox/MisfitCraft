package net.mcreator.misfitcraft.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 5.1.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelTiti<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("misfitcraft", "model_titi"), "main");
	public final ModelPart bb_main;

	public ModelTiti(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(1, 0).addBox(-1.0F, -23.0F, -3.0F, 6.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 15).addBox(-1.0F, -29.0F, -4.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(60, 36).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, -29.0F, -4.0F, -0.2579F, 0.0318F, 0.0292F));
		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(41, 49).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, -28.0F, -3.0F, -0.6906F, 0.1119F, 0.1343F));
		PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(35, 57).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -28.0F, -3.0F, -0.6906F, -0.1119F, -0.1343F));
		PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(41, 57).addBox(-6.0F, -3.0F, -1.0F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -24.0F, -1.0F, 0.4378F, 0.6689F, 0.689F));
		PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(46, 54).addBox(-1.0F, -3.0F, -1.0F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, -24.0F, -1.0F, 0.4378F, -0.6689F, -0.689F));
		PartDefinition cube_r6 = bb_main.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 50).addBox(-15.0F, -3.0F, -1.0F, 16.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -19.0F, 2.0F, 0.037F, 0.0791F, 0.4378F));
		PartDefinition cube_r7 = bb_main.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 54).addBox(-15.0F, -3.0F, -1.0F, 16.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -17.0F, 2.0F, -0.037F, 0.0791F, -0.4378F));
		PartDefinition cube_r8 = bb_main.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(24, 26).addBox(2.0F, -12.0F, -1.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(24, 12).addBox(5.0F, -12.0F, -1.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));
		PartDefinition cube_r9 = bb_main.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(32, 40).addBox(-1.0F, -2.0F, -1.0F, 16.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, -20.0F, 2.0F, 0.037F, -0.0791F, -0.4378F));
		PartDefinition cube_r10 = bb_main.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(32, 44).addBox(-1.0F, -2.0F, -1.0F, 16.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, -18.0F, 2.0F, -0.037F, -0.0791F, 0.4378F));
		PartDefinition cube_r11 = bb_main.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(38, 12).addBox(0.0F, -2.0F, -3.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, -21.0F, 0.0F, 0.0F, 0.0F, 0.0436F));
		PartDefinition cube_r12 = bb_main.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, -2.0F, -3.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0F, -21.0F, 0.0F, 0.0F, 0.0F, -0.0436F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}
}