package com.omuzluk.proxy;

import com.omuzluk.client.render.LayerOmuzluk;
import com.omuzluk.init.ModItems;
import com.omuzluk.item.ItemOmuzluk;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit() {
        registerItemModels();
    }

    @Override
    public void init() {
        registerRenderLayers();
    }

    private void registerItemModels() {
        for (ItemOmuzluk item : ModItems.OMUZLUKLAR) {
            ModelLoader.setCustomModelResourceLocation(item, 0,
                    new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }

    private void registerRenderLayers() {
        RenderManager rm = Minecraft.getMinecraft().getRenderManager();
        for (RenderPlayer renderPlayer : rm.getSkinMap().values()) {
            renderPlayer.addLayer(new LayerOmuzluk(renderPlayer));
        }
    }
}
