package com.bsu;

import com.sun.media.sound.InvalidFormatException;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int numOfEq = 5;

            if (numOfEq < 1) {
                throw new InvalidFormatException(" Error. Invalid data entry form!");
            }
            double[][] tempMatrix = new double[numOfEq][numOfEq];
            double[] resultEq = new double[numOfEq];
            resultEq[0] = 1.2677;
            resultEq[1] = 1.6819;
            resultEq[2] = -2.3657;
            resultEq[3] = -6.5369;
            resultEq[4] = 2.8351;


            fillMatrix(numOfEq, tempMatrix);
            showMatrixGauss(numOfEq, tempMatrix, resultEq);
            mainFunc(numOfEq, tempMatrix, resultEq);
            // showMatrix(numOfEq, checkReverse(numOfEq, tempMatrix));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static double[][] fillMatrix(int n, double[][] matrix) {

        matrix[0][0] = 0.6444;
        matrix[0][1] = 0.0000;
        matrix[0][2] = -0.1683;
        matrix[0][3] = 0.1184;
        matrix[0][4] = 0.1973;
        matrix[1][0] = -0.0395;
        matrix[1][1] = 0.4208;
        matrix[1][2] = 0.0000;
        matrix[1][3] = -0.0802;
        matrix[1][4] = 0.0263;
        matrix[2][0] = 0.0132;
        matrix[2][1] = -0.1184;
        matrix[2][2] = 0.7627;
        matrix[2][3] = 0.0145;
        matrix[2][4] = 0.0460;
        matrix[3][0] = 0.0395;
        matrix[3][1] = 0.0000;
        matrix[3][2] = -0.0960;
        matrix[3][3] = 0.7627;
        matrix[3][4] = 0.0000;
        matrix[4][0] = 0.0263;
        matrix[4][1] = -0.0395;
        matrix[4][2] = 0.1907;
        matrix[4][3] = -0.0158;
        matrix[4][4] = 0.5523;

        return matrix;
    }

    public static void showMatrixGauss(int n, double[][] matrix, double[] resultEq) {
        System.out.println(" First matrix: ");
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print(" | " + resultEq[i] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void showMatrix(int n, double[][] matrix) {
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static double[][] matrixMultiplication(int n, double[][] A, double[][] B) {
        double[][] result = new double[A.length][B[0].length];

        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < B[0].length; ++j) {
                for (int k = 0; k < A[0].length; ++k) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;

    }

    public static void mainFunc(int n, double[][] A, double[] b) {  // Метод Гаусса

        // Прямой ход
        double[][] C = new double[n][n];
        double[][] cT = new double[n][n];
        double[][] aT = new double[n][n];
        double tmp = 0.0;
        double tmp2 = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = 0.0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aT[i][j] = A[j][i];
            }
        }

        A = matrixMultiplication(n, aT, A);
        showMatrix(n, A);
        // Преобразование первой строки
        C[0][0] = Math.sqrt(A[0][0]);
        for (int i = 1; i < n; ++i) {
            C[0][i] = A[0][i] / C[0][0];
        }
///
        for (int i = 1; i < n; ++i) {

            for (int k = 0; k <= i - 1; ++k) {
                tmp = tmp + C[k][i] * C[k][i];
            }
            C[i][i] = Math.sqrt(A[i][i] - tmp);
            tmp = 0;
            for (int j = i + 1; j < n; ++j) {
                for (int k = 0; k <= i - 1; ++k) {
                    tmp2 = tmp2 + C[k][i] * C[k][j];
                }
                C[i][j] = 1 / C[i][i];
                C[i][j] *= (A[i][j] - tmp2);
                tmp2 = 0;
            }
        }
        System.out.println(" S : ");
        showMatrix(n, C);

        // транспонирование
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cT[i][j] = C[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double temp1 = cT[i][j];
                cT[i][j] = cT[j][i];
                cT[j][i] = temp1;
            }
        }
        // Обратный ход

        double[] y = new double[n];
        y[0] = b[0] / cT[0][0];

        for (int i = 1; i < n; i++) {
            double sum = 0.0;

            for (int j = 0; j <= i - 1; j++) {
                sum += cT[i][j] * y[j];
            }

            y[i] = (b[i] - sum) / cT[i][i];
        }


        for (int i = 0; i < n; ++i) {
            System.out.println(" " + y[i]);
        }


        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += C[i][j] * x[j];
            }
            x[i] = (y[i] - sum) / C[i][i];


        }
        for (int i = 0; i < n; ++i) {
            System.out.println("x = " + x[i]);
        }

        double sumdet = 1;
        for (int i = 0; i < n; ++i) {
            sumdet *= C[i][i] * C[i][i];
        }
        System.out.println("d(A) = " + sumdet);

    }
}