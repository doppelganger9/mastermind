package com.doppelganger9.mastermind;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ColorEnumTest {

    private static Stream<Arguments> shouldHaveALabel() {
        return Stream.of(
            Arguments.of("Blue", ColorEnum.B),
            Arguments.of("Yellow", ColorEnum.J),
            Arguments.of("Black", ColorEnum.N),
            Arguments.of("Green", ColorEnum.V),
            Arguments.of("Red", ColorEnum.R),
            Arguments.of("Orange", ColorEnum.O)
        );
    }

    @ParameterizedTest
    @MethodSource
    void shouldHaveALabel(String colorLabel, ColorEnum colorEnum) {
        assertEquals(colorLabel, colorEnum.getLabel());
    }

    @Test void shouldFindEnumFromEnumName() {
        assertEquals(ColorEnum.B, ColorEnum.valueOf("B"));
    }

    @Test void shouldFindEnumFromEnumLabel() {
        assertEquals(ColorEnum.B, ColorEnum.fromLabel("Blue"));
    }

    @Test void shouldFindEnumFromUnknonwEnumLabel() {
        assertNull(ColorEnum.fromLabel("Blert"));
    }
}
