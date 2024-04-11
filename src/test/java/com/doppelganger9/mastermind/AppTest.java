package com.doppelganger9.mastermind;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AppTest {

    @Test void shouldGenerateSolution() {
        String s = App.generateRandomSolution();
        assertNotNull(s);
        assertEquals(4, s.length());
    }

    private static Stream<Arguments> correctAnswers() {
        return Stream.of(
            Arguments.of(0, "RRRRR", "BBBBB"),
            Arguments.of(1, "RRRRR", "BBRBB"),
            Arguments.of(2, "RRRRR", "BBRRB"),
            Arguments.of(3, "RRRRR", "BRRRB"),
            Arguments.of(4, "RRRRR", "RRRRB"),
            Arguments.of(5, "RRRRR", "RRRRR"),
            Arguments.of(1, "RRRRR", "R"),
            Arguments.of(0, "RRRRR", ""),
            Arguments.of(0, "RRRRR", (String) null),
            Arguments.of(0, (String) null, (String) null)
        );
    }

    @ParameterizedTest
    @MethodSource("correctAnswers")
    void shouldCountCorrectAnswers(int count, String expected, String given) {
        assertEquals(count, App.countCorrectPositionsAndColors(expected, given));
    }

    private static Stream<Arguments> countMisplacedColorsArgs() {
        return Stream.of(
            Arguments.of(0,"RNJOB", "VVVVV"),
            Arguments.of(1, "RNJOB", "VVRVV"),
            Arguments.of(2, "RNJOB", "VVRVJ"),
            Arguments.of(3, "RNJOB", "NVRVJ"),
            Arguments.of(4, "RNJOB", "NORVJ"),
            Arguments.of(5, "RNJOB", "NORBJ"),

            Arguments.of(1, "RRRRR", "R"),
            Arguments.of(0, "RRRRR", ""),
            Arguments.of(0, "RRRRR", null),
            Arguments.of(0, null, null)
        );
    }

    @ParameterizedTest
    @MethodSource("countMisplacedColorsArgs")
    void shouldCountMisplacedColors(int count, String expected, String given) {
        assertEquals(count, App.countMisplacedColors(expected, given));
    }
}
