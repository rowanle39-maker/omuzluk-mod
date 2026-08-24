package com.omuzluk.client.gui;

import com.omuzluk.network.NetworkHandler;
import com.omuzluk.network.MessageOpenOmuzlukGui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.client.event.GuiScreenEvent;

import java.util.List;

/**
 * Vanilla envanter ekranina (E tusu ile acilan ekran) kucuk bir "Omuzluk" butonu ekler.
 * Butona tiklaninca sunucudan Omuzluk ekranini acmasi istenir.
 */
@Mod.EventBusSubscriber(modid = "omuzluk", value = Side.CLIENT)
@SideOnly(Side.CLIENT)
public class InventoryButtonHandler {

    private static final int BUTTON_ID = 9421;

    @SubscribeEvent
    public static void onInitGui(GuiScreenEvent.InitGuiEvent.Post event) {
        if (event.getGui() instanceof GuiInventory) {
            GuiInventory gui = (GuiInventory) event.getGui();
            int guiLeft = getGuiLeft(gui);
            int guiTop = getGuiTop(gui);
            List<net.minecraft.client.gui.GuiButton> buttons = event.getButtonList();
            buttons.add(new GuiButton(BUTTON_ID, guiLeft + 178, guiTop + 5, 60, 20, "Omuzluk"));
        }
    }

    @SubscribeEvent
    public static void onActionPerformed(GuiScreenEvent.ActionPerformedEvent.Post event) {
        if (event.getGui() instanceof GuiInventory && event.getButton() != null
                && event.getButton().id == BUTTON_ID) {
            NetworkHandler.INSTANCE.sendToServer(new MessageOpenOmuzlukGui());
        }
    }

    // guiLeft/guiTop alanlari GuiContainer sinifinda tanimlidir (GuiInventory ondan turer).
    private static int getGuiLeft(GuiInventory gui) {
        try {
            java.lang.reflect.Field f = net.minecraft.client.gui.inventory.GuiContainer.class.getDeclaredField("guiLeft");
            f.setAccessible(true);
            return f.getInt(gui);
        } catch (Exception e) {
            return 0;
        }
    }

    private static int getGuiTop(GuiInventory gui) {
        try {
            java.lang.reflect.Field f = net.minecraft.client.gui.inventory.GuiContainer.class.getDeclaredField("guiTop");
            f.setAccessible(true);
            return f.getInt(gui);
        } catch (Exception e) {
            return 0;
        }
    }
}
