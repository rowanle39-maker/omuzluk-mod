package com.omuzluk.network;

import com.omuzluk.OmuzlukMod;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler {

    public static final SimpleNetworkWrapper INSTANCE =
            NetworkRegistry.INSTANCE.newSimpleChannel(OmuzlukMod.MODID);

    private static int id = 0;

    public static void register() {
        INSTANCE.registerMessage(MessageOpenOmuzlukGui.Handler.class, MessageOpenOmuzlukGui.class, id++, Side.SERVER);
    }
}
