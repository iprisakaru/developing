package com.bsu;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


class MainTest {

    @Test
    public void testOne() {
        ArrayList<String> expectedData = new ArrayList<String>();;
        expectedData.add("7 ");
        expectedData.add("4 -8 -1");
        expectedData.add("9 8 ");
        int[][] TestMatrix = {{5, 3, 7},
                {4, -8,-1},
                {9, 5,8}};
        ArrayList<String> actualData = Main.numMoreArMean(3,3, TestMatrix);
        Assert.assertEquals(expectedData, actualData);
    }
}