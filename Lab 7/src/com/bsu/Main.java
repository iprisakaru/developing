package com.bsu;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Sort implements Runnable {
    Integer[] arr;
    int msg;

    public Sort(Integer[] arr, int msg) {
        this.arr = arr;
        this.msg = msg;
    }


    public void run() {
        switch (msg) {
            case 1 -> Arrays.sort(arr, Comparator.naturalOrder());
            case 2 -> Arrays.sort(arr, Comparator.reverseOrder());
            case 3 -> Arrays.sort(arr, Comparator.comparingInt(x -> x.toString().length()));
            case 4 -> Arrays.sort(arr, Comparator.comparingInt(x -> x.toString().length()).reversed());
            default -> throw new InvalidParameterException("Try again:(");
        }
    }
}

public class Main {
    static public void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter the number of elements");
            int n = scan.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * (200 + 1)) - 100;
            }
            showArray(Arrays.asList(arr));

            showMenu();
            int msg = scan.nextInt();

            Thread thread = new Thread(new Sort(arr, msg));
            thread.start();
            thread.join();

            System.out.println("\nSorted array:");
            showArray(Arrays.asList(arr));
        } catch (Exception ex) {
            System.out.println("Try again");
        }

    }

    public static void showArray(List<Integer> arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void showMenu() {
        System.out.println("1.Sort ascending value of numbers");
        System.out.println("2.Sort descending value of numbers");
        System.out.println("3.Sorting in ascending order of lengths of numbers");
        System.out.println("4.Sorting in descending order of lengths of numbers");
    }
}