package com.bsu;



import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int k;
        double x;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter k : ");
            k = scanner.nextInt();
            System.out.println("Enter x (-1;1) : ");
            x = scanner.nextDouble();
            double e = Math.pow(10, -k);
            if (x <= -1 || x >= 1) {
                throw new Exception("Out of the interval");
            }

            double expectedResult = Math.log1p(x);
            double actualResult = taylorRoadSum(x, e);
            System.out.println("Expected result: " + reductionNumber(expectedResult));
            System.out.println("Actual result: " + reductionNumber(actualResult));
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static double taylorRoadSum(double x, double e) {

        double resultsum = 0.0;
        double AddTo = x;
        int temp = 1;
        while (Math.abs(AddTo) >= e) {
            resultsum += AddTo;
            temp += 1;
            AddTo = Math.pow(-1, temp + 1) * Math.pow(x, temp) / temp;
        }
        return resultsum;
    }

    private static String reductionNumber(double value) {
        return String.format("%.3f", value);
    }

}