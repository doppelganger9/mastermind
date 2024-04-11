package com.doppelganger9.mastermind;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Possible Color choices in the game.
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
enum ColorEnum {
    R ("Red"),
    J ("Yellow"),
    B("Blue"),
    O("Orange"),
    V("Green"),
    N("Black");

    private final String label;

    static ColorEnum fromLabel(String label) {
        for(ColorEnum c : ColorEnum.values()) {
            if (c.getLabel().equals(label)) {
                return c;
            }
        }
        return null;
    }
}