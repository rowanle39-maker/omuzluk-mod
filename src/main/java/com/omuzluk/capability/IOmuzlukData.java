package com.omuzluk.capability;

import net.minecraft.item.ItemStack;

/**
 * Bir oyuncunun sag ve sol omuzluk esyalarini tutan capability arayuzu.
 */
public interface IOmuzlukData {
    ItemStack getLeft();
    void setLeft(ItemStack stack);

    ItemStack getRight();
    void setRight(ItemStack stack);
}
