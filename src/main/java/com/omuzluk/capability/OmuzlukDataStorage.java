package com.omuzluk.capability;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class OmuzlukDataStorage implements IStorage<IOmuzlukData> {

    @Override
    public NBTBase writeNBT(Capability<IOmuzlukData> capability, IOmuzlukData instance, EnumFacing side) {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setTag("Left", instance.getLeft().isEmpty() ? new NBTTagCompound() : instance.getLeft().writeToNBT(new NBTTagCompound()));
        tag.setTag("Right", instance.getRight().isEmpty() ? new NBTTagCompound() : instance.getRight().writeToNBT(new NBTTagCompound()));
        return tag;
    }

    @Override
    public void readNBT(Capability<IOmuzlukData> capability, IOmuzlukData instance, EnumFacing side, NBTBase nbt) {
        NBTTagCompound tag = (NBTTagCompound) nbt;
        instance.setLeft(tag.hasKey("Left") ? new ItemStack(tag.getCompoundTag("Left")) : ItemStack.EMPTY);
        instance.setRight(tag.hasKey("Right") ? new ItemStack(tag.getCompoundTag("Right")) : ItemStack.EMPTY);
    }
}
