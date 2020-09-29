package com.bsu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            List<String> inputText = new ArrayList<>();
            System.out.println("Enter some of your lines: ");
            String nextLineText = sc.nextLine();
            while (!nextLineText.isEmpty()) {
                inputText.add(nextLineText);
                nextLineText = sc.nextLine();
            }

            Set<Character> setLetter = uniqueLetters(inputText);
            System.out.println("All words highlighted in alphabetical order: " + setLetter);
        }
    }

    static Set<Character> uniqueLetters(List<String> text) {
        Set<Character> answer = new HashSet<>();
        char[] copyLine;
        int numLetter;
        for (String i : text) {
            copyLine = i.toLowerCase().toCharArray();
            for (char j : copyLine) {
                numLetter = j;
                if ((numLetter >= 97) && (numLetter <= 122)) {
                    answer.add(j);
                }
            }
        }
        return answer;
    }




}