package com.bsu;

class MaxOfTwo {
    static int findMaxMoreTwo(int[][] matrix) {
        int rows = matrix.length;
        int column = matrix[0].length;

        int temp = 0, temp1 = 0, r = 0, temp2 = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                temp2 = matrix[i][j];
                matrix[i][j] = 0;

                for (int k = 0; k < rows; k++) {
                    for (int f = 0; f < column; f++) {
                        if (temp2 == matrix[k][f])
                        {
                            temp = matrix[k][f];
                        } else
                            r++;
                    }

                    if (temp1 > temp)
                        temp = temp1;
                }

                temp1 = temp;
                matrix[i][j] = temp2;

            }
        }
        double kof;
        kof = Math.pow((double) rows, 4);

        if (r == kof)
            return 0;
        else
            return temp;
    }
}