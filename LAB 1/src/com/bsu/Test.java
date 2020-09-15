package com.bsu;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    public void test(){
        double x = 0.78;
        double e =10E-3;
        double expectedResult = Math.log1p(x);
        double actualResult = Main.taylorRoadSum(x,e);
        assertEquals(expectedResult, actualResult, 5E-4);
        x=1.0;
        expectedResult = Math.log1p(x);
        actualResult = Main.taylorRoadSum(x,e);
        assertEquals(expectedResult,actualResult,5E-4);
        x = 0.5;
        expectedResult = Math.log1p(x);
        actualResult = Main.taylorRoadSum(x,e);
        assertEquals(expectedResult,actualResult,5E-4);
    }

}