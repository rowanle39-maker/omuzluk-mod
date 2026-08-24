package com.omuzluk.event;

import com.omuzluk.OmuzlukMod;
import com.omuzluk.capability.CapabilityOmuzluk;
import com.omuzluk.capability.IOmuzlukData;
import com.omuzluk.capability.OmuzlukProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = OmuzlukMod.MODID)
public class CapabilityAttachHandler {

    public static final ResourceLocation OMUZLUK_CAP_ID = new ResourceLocation(OmuzlukMod.MODID, "omuzluk_data");

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(OMUZLUK_CAP_ID, new OmuzlukProvider());
        }
    }

    public static IOmuzlukData get(EntityPlayer player) {
        return player.getCapability(CapabilityOmuzluk.OMUZLUK_CAP, null);
    }
}
