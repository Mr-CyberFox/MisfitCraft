package net.mcreator.misfitcraft.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.misfitcraft.world.inventory.RaceGUISpiritMenu;
import net.mcreator.misfitcraft.network.RaceGUISpiritButtonMessage;
import net.mcreator.misfitcraft.init.MisfitcraftModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class RaceGUISpiritScreen extends AbstractContainerScreen<RaceGUISpiritMenu> implements MisfitcraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_select;
	private Button button_empty;
	private Button button_empty1;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("misfitcraft:textures/screens/race_gui_spirit.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("misfitcraft:textures/screens/031ba8da-cda5-4cc3-8e97-cb93cc1b9d86.png");

	public RaceGUISpiritScreen(RaceGUISpiritMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(IMAGE_0, this.leftPos + 123, this.topPos + 9, 0, 0, 32, 32, 32, 32);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.race_gui_spirit.label_demon"), 24, 16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.race_gui_spirit.label_strength_high_stats"), 24, 97, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.race_gui_spirit.label_weakness_holy_magic"), 24, 124, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.race_gui_spirit.label_difficulty_easy"), 24, 43, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.race_gui_spirit.label_magic_power_10002000"), 24, 70, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_select = Button.builder(Component.translatable("gui.misfitcraft.race_gui_spirit.button_select"), e -> {
			int x = RaceGUISpiritScreen.this.x;
			int y = RaceGUISpiritScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RaceGUISpiritButtonMessage(0, x, y, z));
				RaceGUISpiritButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 59, this.topPos + 172, 55, 20).build();
		this.addRenderableWidget(button_select);
		button_empty = Button.builder(Component.translatable("gui.misfitcraft.race_gui_spirit.button_empty"), e -> {
			int x = RaceGUISpiritScreen.this.x;
			int y = RaceGUISpiritScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RaceGUISpiritButtonMessage(1, x, y, z));
				RaceGUISpiritButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + -26, this.topPos + 70, 18, 20).build();
		this.addRenderableWidget(button_empty);
		button_empty1 = Button.builder(Component.translatable("gui.misfitcraft.race_gui_spirit.button_empty1"), e -> {
			int x = RaceGUISpiritScreen.this.x;
			int y = RaceGUISpiritScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RaceGUISpiritButtonMessage(2, x, y, z));
				RaceGUISpiritButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 186, this.topPos + 70, 18, 20).build();
		this.addRenderableWidget(button_empty1);
	}
}