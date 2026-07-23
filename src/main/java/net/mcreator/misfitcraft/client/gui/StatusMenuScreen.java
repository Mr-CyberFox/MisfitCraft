package net.mcreator.misfitcraft.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.misfitcraft.world.inventory.StatusMenuMenu;
import net.mcreator.misfitcraft.procedures.StatusMenuMPMaxDisplayProcedure;
import net.mcreator.misfitcraft.procedures.RaceDisplayProcedure;
import net.mcreator.misfitcraft.procedures.PlayernameProcedure;
import net.mcreator.misfitcraft.procedures.PlayermodelProcedure;
import net.mcreator.misfitcraft.init.MisfitcraftModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class StatusMenuScreen extends AbstractContainerScreen<StatusMenuMenu> implements MisfitcraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("misfitcraft:textures/screens/statusmenudisplay.png");

	public StatusMenuScreen(StatusMenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 209;
		this.imageHeight = 135;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (PlayermodelProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			MisfitcraftModScreens.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 34, this.topPos + 103, 35, 0f, 0, livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(IMAGE_0, this.leftPos + -6, this.topPos + -9, 0, 0, 221, 153, 221, 153);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, PlayernameProcedure.execute(entity), 8, 11, -1, false);
		guiGraphics.drawString(this.font, StatusMenuMPMaxDisplayProcedure.execute(entity), 144, 107, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.status_menu.label_magic_power"), 136, 99, -1, false);
		guiGraphics.drawString(this.font, RaceDisplayProcedure.execute(entity), 104, 11, -1, false);
	}

	@Override
	public void init() {
		super.init();
	}
}