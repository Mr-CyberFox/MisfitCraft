package net.mcreator.misfitcraft.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.misfitcraft.world.inventory.RaceGUIMenu;
import net.mcreator.misfitcraft.procedures.*;
import net.mcreator.misfitcraft.network.RaceGUIButtonMessage;
import net.mcreator.misfitcraft.init.MisfitcraftModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class RaceGUIScreen extends AbstractContainerScreen<RaceGUIMenu> implements MisfitcraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_raceselect;
	private ImageButton imagebutton_nextbutton;
	private ImageButton imagebutton_backbutton;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("misfitcraft:textures/screens/displayscreen.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("misfitcraft:textures/screens/guisplit.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("misfitcraft:textures/screens/draconidsymbol.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("misfitcraft:textures/screens/spiritsymbol.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("misfitcraft:textures/screens/humansymbol.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("misfitcraft:textures/screens/demonsymbol.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("misfitcraft:textures/screens/guisplit.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("misfitcraft:textures/screens/guisplit.png");

	public RaceGUIScreen(RaceGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 173;
		this.imageHeight = 121;
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -9, this.topPos + -10, 0, 0, 190, 144, 190, 144);
		guiGraphics.blit(IMAGE_1, this.leftPos + 3, this.topPos + 17, 0, 0, 168, 3, 168, 3);
		if (RaceGUIDraconidProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_2, this.leftPos + 138, this.topPos + 1, 0, 0, 32, 32, 32, 32);
		}
		if (RaceGUISpiritProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_3, this.leftPos + 138, this.topPos + 1, 0, 0, 32, 32, 32, 32);
		}
		if (RaceGUIHumanProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_4, this.leftPos + 138, this.topPos + 1, 0, 0, 32, 32, 32, 32);
		}
		if (RaceGUIDemonProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_5, this.leftPos + 138, this.topPos + 1, 0, 0, 32, 32, 32, 32);
		}
		guiGraphics.blit(IMAGE_6, this.leftPos + 3, this.topPos + 36, 0, 0, 168, 3, 168, 3);
		guiGraphics.blit(IMAGE_7, this.leftPos + 3, this.topPos + 66, 0, 0, 168, 3, 168, 3);
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
		if (RaceGUIDemonProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.race_gui.label_demon"), 73, 5, -52225, false);
		if (RaceGUIHumanProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.race_gui.label_human"), 73, 5, -256, false);
		if (RaceGUISpiritProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.race_gui.label_spirit"), 73, 5, -16711681, false);
		if (RaceGUIDraconidProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.misfitcraft.race_gui.label_draconid"), 70, 5, -65485, false);
		guiGraphics.drawString(this.font, RaceGUIDifficultyDisplayProcedure.execute(entity), 7, 24, -1, false);
		guiGraphics.drawString(this.font, RaceGUIHealthDisplayProcedure.execute(entity), 7, 43, -1, false);
		guiGraphics.drawString(this.font, RaceGUIMPDisplayProcedure.execute(entity), 7, 55, -1, false);
		guiGraphics.drawString(this.font, RaceGUIStrengthDisplayProcedure.execute(entity), 7, 72, -1, false);
		guiGraphics.drawString(this.font, RaceGUIWeaknessDisplayProcedure.execute(entity), 7, 85, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_raceselect = new ImageButton(this.leftPos + 66, this.topPos + 105, 41, 31,
				new WidgetSprites(ResourceLocation.parse("misfitcraft:textures/screens/raceselect.png"), ResourceLocation.parse("misfitcraft:textures/screens/raceselecthover.png")), e -> {
					int x = RaceGUIScreen.this.x;
					int y = RaceGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new RaceGUIButtonMessage(0, x, y, z));
						RaceGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_raceselect);
		imagebutton_nextbutton = new ImageButton(this.leftPos + 119, this.topPos + 105, 48, 16,
				new WidgetSprites(ResourceLocation.parse("misfitcraft:textures/screens/nextbutton.png"), ResourceLocation.parse("misfitcraft:textures/screens/nextbuttonhover.png")), e -> {
					int x = RaceGUIScreen.this.x;
					int y = RaceGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new RaceGUIButtonMessage(1, x, y, z));
						RaceGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_nextbutton);
		imagebutton_backbutton = new ImageButton(this.leftPos + 7, this.topPos + 105, 48, 16,
				new WidgetSprites(ResourceLocation.parse("misfitcraft:textures/screens/backbutton.png"), ResourceLocation.parse("misfitcraft:textures/screens/backbuttonhover.png")), e -> {
					int x = RaceGUIScreen.this.x;
					int y = RaceGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new RaceGUIButtonMessage(2, x, y, z));
						RaceGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_backbutton);
	}
}