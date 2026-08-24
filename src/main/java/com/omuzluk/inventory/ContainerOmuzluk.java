package com.omuzluk.inventory;

import com.omuzluk.event.CapabilityAttachHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Omuzluk ekraninin sunucu tarafi container'i.
 * - Slot 0: sol omuzluk
 * - Slot 1: sag omuzluk
 * - Slot 2..28: oyuncunun ana envanteri + hotbar'i (kolaylik icin, boylece
 *   omuzlugu direkt bu ekrandan surukleyip birakabilir).
 */
public class ContainerOmuzluk extends Container {

    private final InventoryOmuzluk omuzlukInventory;

    public ContainerOmuzluk(InventoryPlayer playerInv) {
        EntityPlayer player = playerInv.player;
        this.omuzlukInventory = new InventoryOmuzluk(CapabilityAttachHandler.get(player));

        // Sol omuzluk slotu
        this.addSlotToContainer(new SlotOmuzluk(omuzlukInventory, InventoryOmuzluk.SLOT_SOL, 62, 20,
                com.omuzluk.item.EnumOmuzlukSide.LEFT));
        // Sag omuzluk slotu
        this.addSlotToContainer(new SlotOmuzluk(omuzlukInventory, InventoryOmuzluk.SLOT_SAG, 98, 20,
                com.omuzluk.item.EnumOmuzlukSide.RIGHT));

        // Oyuncu envanteri (3 satir x 9)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlotToContainer(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 51 + row * 18));
            }
        }
        // Hotbar
        for (int col = 0; col < 9; col++) {
            this.addSlotToContainer(new Slot(playerInv, col, 8 + col * 18, 109));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack result = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack stackInSlot = slot.getStack();
            result = stackInSlot.copy();

            if (index < 2) {
                // Omuzluk slotundan oyuncu envanterine
                if (!this.mergeItemStack(stackInSlot, 2, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                // Oyuncu envanterinden omuzluk slotlarina (uygun olan tarafa).
                // mergeItemStack, hedef slotun isItemValid metodunu otomatik kontrol eder,
                // yani sag omuzluk itemi sadece sag slota, sol ise sadece sol slota gider.
                if (!this.mergeItemStack(stackInSlot, 0, 2, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (stackInSlot.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return result;
    }
}
