package com.omuzluk.item;

/**
 * Omuzluk (shoulder pad) materyal turleri.
 * Her materyalin render icin kullanilan bir rengi vardir (RGB, 0xRRGGBB).
 */
public enum EnumOmuzlukMaterial {
    LEATHER("leather", 0xA06540),
    IRON("iron", 0xD8D8D8),
    GOLD("gold", 0xFFD700),
    DIAMOND("diamond", 0x4DE8E8);

    private final String name;
    private final int color;

    EnumOmuzlukMaterial(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }
}
