package com.bsu;


import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MainTest {

    @Test
    public void testOne() {
        HashSet<String> letterActual = new HashSet<String>();
        ;
        HashSet<String> letterExpected = Main.findUniqWords("Listen to me Morty I know that new situations can be intimidating" +
                " You are looking around and it is all scary and different but you know meeting them head on charging into them like a bull that is how we grow as people");
        letterActual.add("intimidating");
        letterActual.add("meeting");
        letterActual.add("looking");
        letterActual.add("bull");
        letterActual.add("situations");
        letterActual.add("people");
        letterActual.add("that");
        letterActual.add("different");
        letterActual.add("all");
        letterActual.add("charging");
        assertEquals(letterExpected, letterActual);
    }
}