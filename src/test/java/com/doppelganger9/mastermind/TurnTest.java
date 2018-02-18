package com.doppelganger9.mastermind;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TurnTest {

    @Test
    public void shouldHaveGetters() {
        Turn t = new Turn("ABCDE", 1, 2, 3);

        assertEquals(1, t.getNbCorrect().intValue());
        assertEquals(2, t.getNbMisplaced().intValue());
        assertEquals(3, t.getTurn().intValue());
        assertEquals("ABCDE", t.getUserInput());
    }

    @Test
    public void shouldOutputBoardLine() {
        Turn t = new Turn("ABCDE", 1, 2, 3);
        assertEquals("|ABCDE| 1 | 2 | 4/10 |\n", t.toBoardLineOutput());
    }

    @Test
    public void shouldOutputBoardLineWhenTurnEqualOrOver9() {
        Turn t = new Turn("ABCDE", 1, 2, 9);
        assertEquals("|ABCDE| 1 | 2 |10/10 |\n", t.toBoardLineOutput());
    }
}
