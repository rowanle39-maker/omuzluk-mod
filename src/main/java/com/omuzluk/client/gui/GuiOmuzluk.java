package com.omuzluk.client.gui;

import com.omuzluk.OmuzlukMod;
import com.omuzluk.inventory.ContainerOmuzluk;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.GlStateManager;

public class GuiOmuzluk extends GuiContainer {

    private static final ResourceLocation BACKGROUND =
            new ResourceLocation(OmuzlukMod.MODID, "textures/gui/omuzluk_gui.png");

    private final EntityPlayer player;

    public GuiOmuzluk(ContainerOmuzluk container, EntityPlayer player) {
        super(container);
        this.player = player;
        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1F, 1F, 1F, 1F);
        mc.getTextureManager().bindTexture(BACKGROUND);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        fontRenderer.drawString("Omuzluk", 8, 6, 0x404040);
        fontRenderer.drawString("Sol", 55, 40, 0x606060);
        fontRenderer.drawString("Sag", 92, 40, 0x606060);
        fontRenderer.drawString("Envanter", 8, 42, 0x404040);
    }
}
