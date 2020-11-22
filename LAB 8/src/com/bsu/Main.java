package com.bsu;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new File("emails.txt"))) {
            while (sc.hasNextLine()) {
                String msg = sc.nextLine();
                if (ifValid(msg)) {
                    System.out.println("Right email" + msg);
                } else {
                    System.out.println("Wrong email - " + msg);
                }
            }
        } catch (Exception ex) {
            System.out.println(new Exception());
        }
    }

    public static boolean ifValid(String msg) {
        boolean result = msg.matches("^([a-zA-Z0-9_.-]+)@([a-zA-Z_.]+).([a-zA-Z])$");
        return result;
    }


}
