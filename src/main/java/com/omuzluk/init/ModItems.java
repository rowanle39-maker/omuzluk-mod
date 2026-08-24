package com.omuzluk.init;

import com.omuzluk.OmuzlukMod;
import com.omuzluk.item.EnumOmuzlukMaterial;
import com.omuzluk.item.EnumOmuzlukSide;
import com.omuzluk.item.ItemOmuzluk;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = OmuzlukMod.MODID)
public class ModItems {

    public static final List<ItemOmuzluk> OMUZLUKLAR = new ArrayList<>();

    // Sag/sol X 4 materyal = 8 item, alanlara referans olarak tutuyoruz.
    public static ItemOmuzluk OMUZLUK_DERI_SOL;
    public static ItemOmuzluk OMUZLUK_DERI_SAG;
    public static ItemOmuzluk OMUZLUK_DEMIR_SOL;
    public static ItemOmuzluk OMUZLUK_DEMIR_SAG;
    public static ItemOmuzluk OMUZLUK_ALTIN_SOL;
    public static ItemOmuzluk OMUZLUK_ALTIN_SAG;
    public static ItemOmuzluk OMUZLUK_ELMAS_SOL;
    public static ItemOmuzluk OMUZLUK_ELMAS_SAG;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        OMUZLUK_DERI_SOL = create(EnumOmuzlukMaterial.LEATHER, EnumOmuzlukSide.LEFT);
        OMUZLUK_DERI_SAG = create(EnumOmuzlukMaterial.LEATHER, EnumOmuzlukSide.RIGHT);
        OMUZLUK_DEMIR_SOL = create(EnumOmuzlukMaterial.IRON, EnumOmuzlukSide.LEFT);
        OMUZLUK_DEMIR_SAG = create(EnumOmuzlukMaterial.IRON, EnumOmuzlukSide.RIGHT);
        OMUZLUK_ALTIN_SOL = create(EnumOmuzlukMaterial.GOLD, EnumOmuzlukSide.LEFT);
        OMUZLUK_ALTIN_SAG = create(EnumOmuzlukMaterial.GOLD, EnumOmuzlukSide.RIGHT);
        OMUZLUK_ELMAS_SOL = create(EnumOmuzlukMaterial.DIAMOND, EnumOmuzlukSide.LEFT);
        OMUZLUK_ELMAS_SAG = create(EnumOmuzlukMaterial.DIAMOND, EnumOmuzlukSide.RIGHT);

        for (ItemOmuzluk item : OMUZLUKLAR) {
            event.getRegistry().register(item);
        }
    }

    private static ItemOmuzluk create(EnumOmuzlukMaterial material, EnumOmuzlukSide side) {
        ItemOmuzluk item = new ItemOmuzluk(material, side);
        OMUZLUKLAR.add(item);
        return item;
    }

    /**
     * Bir item'in gecerli bir omuzluk olup olmadigini ve verilen tarafa uyup uymadigini kontrol eder.
     */
    public static boolean isValidFor(net.minecraft.item.ItemStack stack, EnumOmuzlukSide side) {
        if (stack.isEmpty() || !(stack.getItem() instanceof ItemOmuzluk)) {
            return false;
        }
        return ((ItemOmuzluk) stack.getItem()).getSide() == side;
    }
}
