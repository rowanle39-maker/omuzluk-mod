package com.omuzluk.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nullable;

public class OmuzlukProvider implements ICapabilitySerializable<NBTBase> {

    private final IOmuzlukData instance = new OmuzlukData();

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityOmuzluk.OMUZLUK_CAP;
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == CapabilityOmuzluk.OMUZLUK_CAP) {
            return CapabilityOmuzluk.OMUZLUK_CAP.cast(instance);
        }
        return null;
    }

    @Override
    public NBTBase serializeNBT() {
        return CapabilityOmuzluk.OMUZLUK_CAP.getStorage().writeNBT(CapabilityOmuzluk.OMUZLUK_CAP, instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        CapabilityOmuzluk.OMUZLUK_CAP.getStorage().readNBT(CapabilityOmuzluk.OMUZLUK_CAP, instance, null, nbt);
    }
}
