package com.doppelganger9.mastermind;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AppTest {


    @Test public void shouldGenerateSolution() {
        String s = App.generateRandomSolution();
        assertNotNull(s);
        assertEquals(4, s.length());
    }

    @Test public void shouldCountCorrectAnswers() {
        assertEquals(0, App.countCorrectPositionsAndColors("RRRRR", "BBBBB"));
        assertEquals(1, App.countCorrectPositionsAndColors("RRRRR", "BBRBB"));
        assertEquals(2, App.countCorrectPositionsAndColors("RRRRR", "BBRRB"));
        assertEquals(3, App.countCorrectPositionsAndColors("RRRRR", "BRRRB"));
        assertEquals(4, App.countCorrectPositionsAndColors("RRRRR", "RRRRB"));
        assertEquals(5, App.countCorrectPositionsAndColors("RRRRR", "RRRRR"));
        assertEquals(1, App.countCorrectPositionsAndColors("RRRRR", "R"));
        assertEquals(0, App.countCorrectPositionsAndColors("RRRRR", ""));
        assertEquals(0, App.countCorrectPositionsAndColors("RRRRR", null));
        assertEquals(0, App.countCorrectPositionsAndColors(null, null));
    }

    @Test
    public void shouldCountMisplacedColors() {
        assertEquals(0, App.countMisplacedColors("RNJOB", "VVVVV"));
        assertEquals(1, App.countMisplacedColors("RNJOB", "VVRVV"));
        assertEquals(2, App.countMisplacedColors("RNJOB", "VVRVJ"));
        assertEquals(3, App.countMisplacedColors("RNJOB", "NVRVJ"));
        assertEquals(4, App.countMisplacedColors("RNJOB", "NORVJ"));
        assertEquals(5, App.countMisplacedColors("RNJOB", "NORBJ"));

        assertEquals(1, App.countMisplacedColors("RRRRR", "R"));
        assertEquals(0, App.countMisplacedColors("RRRRR", ""));
        assertEquals(0, App.countMisplacedColors("RRRRR", null));
        assertEquals(0, App.countMisplacedColors(null, null));
    }
}
