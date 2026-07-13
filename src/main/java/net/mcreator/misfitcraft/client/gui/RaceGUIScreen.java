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

import net.mcreator.misfitcraft.world.inventory.RaceGUIMenu;
import net.mcreator.misfitcraft.network.RaceGUIButtonMessage;
import net.mcreator.misfitcraft.init.MisfitcraftModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class RaceGUIScreen extends AbstractContainerScreen<RaceGUIMenu> implements MisfitcraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_select;
	private Button button_empty;
	private Button button_empty1;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("misfitcraft:textures/screens/race_gui.png");
	private static final ResourceLocation SPRITE_0 = ResourceLocation.parse("misfitcraft:textures/screens/c793bd3e-ff10-4cc7-a739-4efe362cf637.png");

	public RaceGUIScreen(RaceGUIMenu container, Inventory inventory, Component text) {
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
		guiGraphics.blit(SPRITE_0, this.leftPos + 122, this.topPos + 9, 0, 0, 32, 32, 32, 32);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.race_gui.label_demon"), 24, 16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.race_gui.label_strength_high_stats"), 24, 97, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.race_gui.label_weakness_holy_magic"), 24, 124, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.race_gui.label_difficulty_easy"), 24, 43, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.race_gui.label_magic_power_10002000"), 24, 70, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_select = Button.builder(Component.translatable("gui.misfitcraft.race_gui.button_select"), e -> {
			int x = RaceGUIScreen.this.x;
			int y = RaceGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RaceGUIButtonMessage(0, x, y, z));
				RaceGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 59, this.topPos + 172, 55, 20).build();
		this.addRenderableWidget(button_select);
		button_empty = Button.builder(Component.translatable("gui.misfitcraft.race_gui.button_empty"), e -> {
			int x = RaceGUIScreen.this.x;
			int y = RaceGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RaceGUIButtonMessage(1, x, y, z));
				RaceGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + -26, this.topPos + 70, 18, 20).build();
		this.addRenderableWidget(button_empty);
		button_empty1 = Button.builder(Component.translatable("gui.misfitcraft.race_gui.button_empty1"), e -> {
			int x = RaceGUIScreen.this.x;
			int y = RaceGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RaceGUIButtonMessage(2, x, y, z));
				RaceGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 186, this.topPos + 70, 18, 20).build();
		this.addRenderableWidget(button_empty1);
	}
}