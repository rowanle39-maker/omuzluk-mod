package com.omuzluk.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilityOmuzluk {

    @CapabilityInject(IOmuzlukData.class)
    public static Capability<IOmuzlukData> OMUZLUK_CAP = null;

    public static void register() {
        CapabilityManager.INSTANCE.register(IOmuzlukData.class, new OmuzlukDataStorage(), OmuzlukData::new);
    }
}
