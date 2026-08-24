package com.omuzluk;

import com.omuzluk.capability.CapabilityOmuzluk;
import com.omuzluk.capability.IOmuzlukData;
import com.omuzluk.network.NetworkHandler;
import com.omuzluk.proxy.CommonProxy;
import com.omuzluk.proxy.GuiHandlerOmuzluk;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = OmuzlukMod.MODID, name = OmuzlukMod.NAME, version = OmuzlukMod.VERSION)
public class OmuzlukMod {

    public static final String MODID = "omuzluk";
    public static final String NAME = "Omuzluk Modu";
    public static final String VERSION = "1.0.0";

    @Mod.Instance(MODID)
    public static OmuzlukMod instance;

    @SidedProxy(clientSide = "com.omuzluk.proxy.ClientProxy", serverSide = "com.omuzluk.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        CapabilityOmuzluk.register();
        NetworkHandler.register();
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandlerOmuzluk());
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }
}
