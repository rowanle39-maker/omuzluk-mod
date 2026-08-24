package com.omuzluk.inventory;

import com.omuzluk.capability.IOmuzlukData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

/**
 * 2 slotluk sanal envanter: 0 = sol omuzluk, 1 = sag omuzluk.
 * Gercek veri oyuncunun IOmuzlukData capability'sinde tutulur; bu sinif
 * sadece Container/Slot sisteminin ihtiyac duydugu IInventory kopruusudur.
 */
public class InventoryOmuzluk implements IInventory {

    public static final int SLOT_SOL = 0;
    public static final int SLOT_SAG = 1;

    private final IOmuzlukData data;

    public InventoryOmuzluk(IOmuzlukData data) {
        this.data = data;
    }

    @Override
    public int getSizeInventory() {
        return 2;
    }

    @Override
    public boolean isEmpty() {
        return data.getLeft().isEmpty() && data.getRight().isEmpty();
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return index == SLOT_SOL ? data.getLeft() : data.getRight();
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        ItemStack current = getStackInSlot(index);
        if (current.isEmpty()) return ItemStack.EMPTY;
        ItemStack result = current.splitStack(count);
        setInventorySlotContents(index, current.isEmpty() ? ItemStack.EMPTY : current);
        return result;
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        ItemStack current = getStackInSlot(index);
        setInventorySlotContents(index, ItemStack.EMPTY);
        return current;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        if (index == SLOT_SOL) {
            data.setLeft(stack);
        } else {
            data.setRight(stack);
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public void markDirty() {
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openInventory(EntityPlayer player) {
    }

    @Override
    public void closeInventory(EntityPlayer player) {
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true; // Gercek gecerlilik kontrolu SlotOmuzluk icinde yapilir.
    }

    @Override
    public int getField(int id) { return 0; }
    @Override
    public void setField(int id, int value) { }
    @Override
    public int getFieldCount() { return 0; }

    @Override
    public void clear() {
        data.setLeft(ItemStack.EMPTY);
        data.setRight(ItemStack.EMPTY);
    }

    @Override
    public String getName() {
        return "container.omuzluk";
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TextComponentString("Omuzluk");
    }
}
