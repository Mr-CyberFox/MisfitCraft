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

import net.mcreator.misfitcraft.world.inventory.RaceGUIHumanMenu;
import net.mcreator.misfitcraft.network.RaceGUIHumanButtonMessage;
import net.mcreator.misfitcraft.init.MisfitcraftModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class RaceGUIHumanScreen extends AbstractContainerScreen<RaceGUIHumanMenu> implements MisfitcraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_select;
	private Button button_empty;
	private Button button_empty1;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("misfitcraft:textures/screens/race_gui_human.png");

	public RaceGUIHumanScreen(RaceGUIHumanMenu container, Inventory inventory, Component text) {
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
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.race_gui_human.label_demon"), 24, 16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.race_gui_human.label_strength_high_stats"), 24, 97, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.race_gui_human.label_weakness_holy_magic"), 24, 124, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.race_gui_human.label_difficulty_easy"), 24, 43, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.race_gui_human.label_magic_power_10002000"), 24, 70, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_select = Button.builder(Component.translatable("gui.misfitcraft.race_gui_human.button_select"), e -> {
			int x = RaceGUIHumanScreen.this.x;
			int y = RaceGUIHumanScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RaceGUIHumanButtonMessage(0, x, y, z));
				RaceGUIHumanButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 59, this.topPos + 172, 55, 20).build();
		this.addRenderableWidget(button_select);
		button_empty = Button.builder(Component.translatable("gui.misfitcraft.race_gui_human.button_empty"), e -> {
			int x = RaceGUIHumanScreen.this.x;
			int y = RaceGUIHumanScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RaceGUIHumanButtonMessage(1, x, y, z));
				RaceGUIHumanButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + -26, this.topPos + 70, 18, 20).build();
		this.addRenderableWidget(button_empty);
		button_empty1 = Button.builder(Component.translatable("gui.misfitcraft.race_gui_human.button_empty1"), e -> {
			int x = RaceGUIHumanScreen.this.x;
			int y = RaceGUIHumanScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RaceGUIHumanButtonMessage(2, x, y, z));
				RaceGUIHumanButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 186, this.topPos + 70, 18, 20).build();
		this.addRenderableWidget(button_empty1);
	}
}