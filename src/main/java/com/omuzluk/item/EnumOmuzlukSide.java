package com.omuzluk.item;

public enum EnumOmuzlukSide {
    LEFT("sol"),
    RIGHT("sag");

    private final String turkce;

    EnumOmuzlukSide(String turkce) {
        this.turkce = turkce;
    }

    public String getTurkce() {
        return turkce;
    }
}
