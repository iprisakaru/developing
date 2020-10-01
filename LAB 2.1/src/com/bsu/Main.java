package com.bsu;

import com.sun.media.sound.InvalidFormatException;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter a number of rows: ");
            int rows = sc.nextInt();

            System.out.println("Enter a number of column: ");
            int columns = sc.nextInt();

            if (rows < 1 || columns < 1) {
                throw new InvalidFormatException(" Error. Invalid data entry form!");
            }
            int[][] tempMatrix = new int[rows][columns];
            fillMatrix(rows, columns, tempMatrix);
            System.out.println(tempMatrix[1][1]);
            showMatrix(rows, columns, tempMatrix);
            ArrayList<String>setLetter = numMoreArMean(rows, columns, tempMatrix);
            System.out.println(setLetter);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static int[][] fillMatrix(int rows, int columns, int[][] matrix) {


        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (int) (Math.random() * (10 + 10)) - 10;
            }
        }
        return matrix;
    }

    public static void showMatrix(int rows, int columns, int[][] matrix) {
        System.out.println(" Temple matrix: ");
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
        System.out.println();
    }

    public static ArrayList numMoreArMean(int rows, int columns, int[][] matrix) {

        double ArMeanTemp = 0;
        ArrayList<String> result = new ArrayList<String>();
        String tmpString = "";
        System.out.println("Elements that are greater in modulus than the arithmetic mean of the elements of this row: ");
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                ArMeanTemp += matrix[i][j];
            }
            ArMeanTemp /= columns;
            for (int j = 0; j < columns; j++) {
                if (Math.abs(matrix[i][j]) > ArMeanTemp) {
                    tmpString+=matrix[i][j];
                    tmpString+=" ";
                }
            }
            result.add(tmpString);
            tmpString="";
            ArMeanTemp = 0;
        }
      return result;
    }

}