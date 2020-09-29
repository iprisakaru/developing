package com.bsu;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;


class MainTest {

    @Test
    public void testOne() {
        Set<Character> letterExpected = Set.of('a', 'b', 'c', 'd', 'e', 'f', 'h', 'i','k','l','m', 'n', 'o', 'r', 's', 't', 'u', 'v', 'w', 'y');
        List<String> text = Arrays.asList("Life is not a movie from the Internet","You can't rewind back");
        Set<Character> letterActual = Main.uniqueLetters(text);
        Assert.assertEquals(letterExpected, letterActual);
    }
    }
