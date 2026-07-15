package net.mcreator.misfitcraft.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.misfitcraft.world.inventory.CastGUIMenu;
import net.mcreator.misfitcraft.network.CastGUIButtonMessage;
import net.mcreator.misfitcraft.init.MisfitcraftModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class CastGUIScreen extends AbstractContainerScreen<CastGUIMenu> implements MisfitcraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_fless;
	private Button button_ent;
	private Button button_enchel;
	private Button button_ei_chael;

	public CastGUIScreen(CastGUIMenu container, Inventory inventory, Component text) {
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
	}

	@Override
	public void init() {
		super.init();
		button_fless = Button.builder(Component.translatable("gui.misfitcraft.cast_gui.button_fless"), e -> {
			int x = CastGUIScreen.this.x;
			int y = CastGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new CastGUIButtonMessage(0, x, y, z));
				CastGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 7, 50, 20).build();
		this.addRenderableWidget(button_fless);
		button_ent = Button.builder(Component.translatable("gui.misfitcraft.cast_gui.button_ent"), e -> {
			int x = CastGUIScreen.this.x;
			int y = CastGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new CastGUIButtonMessage(1, x, y, z));
				CastGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 34, 40, 20).build();
		this.addRenderableWidget(button_ent);
		button_enchel = Button.builder(Component.translatable("gui.misfitcraft.cast_gui.button_enchel"), e -> {
			int x = CastGUIScreen.this.x;
			int y = CastGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new CastGUIButtonMessage(2, x, y, z));
				CastGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 61, 55, 20).build();
		this.addRenderableWidget(button_enchel);
		button_ei_chael = Button.builder(Component.translatable("gui.misfitcraft.cast_gui.button_ei_chael"), e -> {
			int x = CastGUIScreen.this.x;
			int y = CastGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new CastGUIButtonMessage(3, x, y, z));
				CastGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 88, 65, 20).build();
		this.addRenderableWidget(button_ei_chael);
	}
}