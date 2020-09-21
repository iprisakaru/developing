package com.bsu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void testFindMaxMoreTwo() {

        int[][] matrix = {{1, 4, 3}, {4, 3, 6}, {5, 2, 10}};
        int result = MaxOfTwo.findMaxMoreTwo(matrix);
        assertEquals(4, result);

        //////////////////////////////////////////

        int[][] matrix2 = {{1, 8, 3}, {4, 8, 6}, {5, 2, 10}};
        result = MaxOfTwo.findMaxMoreTwo(matrix2);
        assertEquals(8, result);


    }


}
