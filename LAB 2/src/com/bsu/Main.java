package com.bsu;

import com.sun.media.sound.InvalidFormatException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner cin = new Scanner(System.in)) {

            System.out.print("Enter rows: ");
            int rows = tryInputInteger(cin);
            if (rows <= 0) {
                throw new InvalidFormatException("Matrix size can't be negative");
            }

            System.out.print("Enter column: ");
            int column = tryInputInteger(cin);
            if (column <= 0) {
                throw new InvalidFormatException("Matrix size can't be negative");
            }

            int[][] matrix = new int[rows][column];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < column; j++) {
                    matrix[i][j] = getRandomNumber(0, 10);
                }
            }

            System.out.print("Randomly generated matrix is: \n");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < column; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.print('\n');
            }

            System.out.println("The maximum of the numbers occurring in a given matrix more than once is "
                    + MaxOfTwo.findMaxMoreTwo(matrix));
        } catch (Exception ex) {
            System.out.println("Error while reading: " + ex);
        }
    }

    private static int tryInputInteger(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
                System.out.print("Error: that’s not "
                        + "an integer. Try again: ");
            }
        }
    }

    private static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}

