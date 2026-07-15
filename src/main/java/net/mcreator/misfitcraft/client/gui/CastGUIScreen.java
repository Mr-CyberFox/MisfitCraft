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
	private Button button_syrica;
	private Button button_grega;
	private Button button_kursla;
	private Button button_kurst;

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
		button_syrica = Button.builder(Component.translatable("gui.misfitcraft.cast_gui.button_syrica"), e -> {
			int x = CastGUIScreen.this.x;
			int y = CastGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new CastGUIButtonMessage(4, x, y, z));
				CastGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 115, 55, 20).build();
		this.addRenderableWidget(button_syrica);
		button_grega = Button.builder(Component.translatable("gui.misfitcraft.cast_gui.button_grega"), e -> {
			int x = CastGUIScreen.this.x;
			int y = CastGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new CastGUIButtonMessage(5, x, y, z));
				CastGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 142, 50, 20).build();
		this.addRenderableWidget(button_grega);
		button_kursla = Button.builder(Component.translatable("gui.misfitcraft.cast_gui.button_kursla"), e -> {
			int x = CastGUIScreen.this.x;
			int y = CastGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new CastGUIButtonMessage(6, x, y, z));
				CastGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 78, this.topPos + 7, 55, 20).build();
		this.addRenderableWidget(button_kursla);
		button_kurst = Button.builder(Component.translatable("gui.misfitcraft.cast_gui.button_kurst"), e -> {
			int x = CastGUIScreen.this.x;
			int y = CastGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new CastGUIButtonMessage(7, x, y, z));
				CastGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 78, this.topPos + 34, 50, 20).build();
		this.addRenderableWidget(button_kurst);
	}
}