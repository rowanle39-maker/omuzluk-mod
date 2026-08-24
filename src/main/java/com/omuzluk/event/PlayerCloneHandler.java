package com.omuzluk.event;

import com.omuzluk.OmuzlukMod;
import com.omuzluk.capability.IOmuzlukData;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

/**
 * Oyuncu oldugunde (respawn) omuzluklarin dusmemesi/silinmemesi icin
 * eski capability verisini yeni oyuncu nesnesine kopyalar.
 */
@Mod.EventBusSubscriber(modid = OmuzlukMod.MODID)
public class PlayerCloneHandler {

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        IOmuzlukData oldData = CapabilityAttachHandler.get(event.getOriginal());
        IOmuzlukData newData = CapabilityAttachHandler.get(event.getEntityPlayer());
        if (oldData != null && newData != null) {
            newData.setLeft(oldData.getLeft());
            newData.setRight(oldData.getRight());
        }
    }
}
