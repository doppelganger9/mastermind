package com.doppelganger9.mastermind;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ColorEnumTest {

    @Test
    public void shouldHaveALabel() {
        assertEquals("Blue", ColorEnum.B.getLabel());
        assertEquals("Yellow", ColorEnum.J.getLabel());
        assertEquals("Black", ColorEnum.N.getLabel());
        assertEquals("Green", ColorEnum.V.getLabel());
        assertEquals("Red", ColorEnum.R.getLabel());
        assertEquals("Orange", ColorEnum.O.getLabel());
    }

    @Test
    public void shouldFindEnumFromEnumName() {
        assertEquals(ColorEnum.B, ColorEnum.valueOf("B"));
    }

    @Test
    public void shouldFindEnumFromEnumLabel() {
        assertEquals(ColorEnum.B, ColorEnum.fromLabel("Blue"));
    }

    @Test
    public void shouldFindEnumFromUnknonwEnumLabel() {
        assertNull(ColorEnum.fromLabel("Blert"));
    }
}
