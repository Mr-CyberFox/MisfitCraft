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
import net.mcreator.misfitcraft.procedures.PlayermodelProcedure;
import net.mcreator.misfitcraft.procedures.MagicPowerStatOverlayProcedure;
import net.mcreator.misfitcraft.init.MisfitcraftModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class StatusMenuScreen extends AbstractContainerScreen<StatusMenuMenu> implements MisfitcraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("misfitcraft:textures/screens/status_menu.png");
	private static final ResourceLocation SPRITE_0 = ResourceLocation.parse("misfitcraft:textures/screens/c793bd3e-ff10-4cc7-a739-4efe362cf637.png");
	private static final ResourceLocation SPRITE_1 = ResourceLocation.parse("misfitcraft:textures/screens/c793bd3e-ff10-4cc7-a739-4efe362cf637.png");

	public StatusMenuScreen(StatusMenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 206;
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
			MisfitcraftModScreens.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 40, this.topPos + 92, 40, 0f + (float) Math.atan((this.leftPos + 40 - mouseX) / 40.0), (float) Math.atan((this.topPos + 43 - mouseY) / 40.0),
					livingEntity);
		}
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 12 && mouseX < leftPos + 75 && mouseY > topPos + 99 && mouseY < topPos + 117) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.misfitcraft.status_menu.tooltip_next_stage"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(SPRITE_0, this.leftPos + 12, this.topPos + 99, 0, 0, 32, 16, 32, 32);
		guiGraphics.blit(SPRITE_1, this.leftPos + 39, this.topPos + 99, 0, 0, 32, 16, 32, 32);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.status_menu.label_proc_playername"), 12, 9, -12829636, false);
		guiGraphics.drawString(this.font, MagicPowerStatOverlayProcedure.execute(entity), 84, 54, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.status_menu.label_magic_power"), 84, 45, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.status_menu.label_race"), 84, 9, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.status_menu.label_proc_race_overlay"), 111, 9, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}