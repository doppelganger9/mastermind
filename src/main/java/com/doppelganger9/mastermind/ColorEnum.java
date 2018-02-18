package com.doppelganger9.mastermind;

import lombok.Getter;

/**
 * Possible Color choices in the game.
 */
public enum ColorEnum {
    R ("Red"),
    J ("Yellow"),
    B("Blue"),
    O("Orange"),
    V("Green"),
    N("Black");

    private @Getter() String label;

    ColorEnum(String label) {
        this.label = label;
    }

    public static ColorEnum fromLabel(String label) {
        for(ColorEnum c : ColorEnum.values()) {
            if (c.getLabel().equals(label)) {
                return c;
            }
        }
        return null;
    }
}