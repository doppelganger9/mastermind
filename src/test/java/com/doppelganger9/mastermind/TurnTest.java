package com.doppelganger9.mastermind;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TurnTest {

    @Test void shouldHaveGetters() {
        Turn t = new Turn("ABCDE", 1, 2, 3);

        assertEquals(1, t.nbCorrect());
        assertEquals(2, t.nbMisplaced());
        assertEquals(3, t.turn());
        assertEquals("ABCDE", t.userInput());
    }

    @Test void shouldOutputBoardLine() {
        Turn t = new Turn("ABCDE", 1, 2, 3);
        assertEquals("|ABCDE| 1 | 2 | 4/10 |\n", t.toBoardLineOutput());
    }

    @Test void shouldOutputBoardLineWhenTurnEqualOrOver9() {
        Turn t = new Turn("ABCDE", 1, 2, 9);
        assertEquals("|ABCDE| 1 | 2 |10/10 |\n", t.toBoardLineOutput());
    }
}
