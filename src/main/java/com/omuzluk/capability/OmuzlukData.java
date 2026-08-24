package com.omuzluk.capability;

import net.minecraft.item.ItemStack;

public class OmuzlukData implements IOmuzlukData {

    private ItemStack left = ItemStack.EMPTY;
    private ItemStack right = ItemStack.EMPTY;

    @Override
    public ItemStack getLeft() {
        return left;
    }

    @Override
    public void setLeft(ItemStack stack) {
        this.left = stack;
    }

    @Override
    public ItemStack getRight() {
        return right;
    }

    @Override
    public void setRight(ItemStack stack) {
        this.right = stack;
    }
}
