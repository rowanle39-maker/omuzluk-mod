package com.omuzluk.proxy;

import com.omuzluk.client.gui.GuiOmuzluk;
import com.omuzluk.inventory.ContainerOmuzluk;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandlerOmuzluk implements IGuiHandler {

    public static final int GUI_ID_OMUZLUK = 0;

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == GUI_ID_OMUZLUK) {
            return new ContainerOmuzluk(player.inventory);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == GUI_ID_OMUZLUK) {
            return new GuiOmuzluk(new ContainerOmuzluk(player.inventory), player);
        }
        return null;
    }
}
