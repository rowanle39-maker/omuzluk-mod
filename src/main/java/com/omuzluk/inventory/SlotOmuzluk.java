package com.omuzluk.inventory;

import com.omuzluk.init.ModItems;
import com.omuzluk.item.EnumOmuzlukSide;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotOmuzluk extends Slot {

    private final EnumOmuzlukSide side;

    public SlotOmuzluk(IInventory inventory, int index, int x, int y, EnumOmuzlukSide side) {
        super(inventory, index, x, y);
        this.side = side;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return ModItems.isValidFor(stack, side);
    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }
}
