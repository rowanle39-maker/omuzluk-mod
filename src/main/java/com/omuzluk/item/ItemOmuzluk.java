package com.omuzluk.item;

import com.omuzluk.OmuzlukMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Tamamen kozmetik bir omuzluk esyasi. Sag/sol taraf ve materyal bilgisi tasir.
 * Bu item'in dogrudan bir savas/zirh degeri yoktur; sadece Omuzluk ekranindaki
 * ilgili slota (SlotOmuzluk) yerlestirilerek karakterde gorsel olarak gosterilir.
 */
public class ItemOmuzluk extends Item {

    private final EnumOmuzlukMaterial material;
    private final EnumOmuzlukSide side;

    public ItemOmuzluk(EnumOmuzlukMaterial material, EnumOmuzlukSide side) {
        this.material = material;
        this.side = side;
        String regName = "omuzluk_" + material.getName() + "_" + side.name().toLowerCase();
        setRegistryName(regName);
        setTranslationKey(regName);
        setCreativeTab(CreativeTabs.COMBAT);
        setMaxStackSize(1);
    }

    public EnumOmuzlukMaterial getMaterial() {
        return material;
    }

    public EnumOmuzlukSide getSide() {
        return side;
    }
}
