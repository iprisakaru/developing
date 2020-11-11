package com.bsu;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String tempString = "";
            System.out.println("Enter some text: ");
            String nextLineText = sc.nextLine();
            while (!nextLineText.isEmpty()) {
                tempString += nextLineText;
                tempString += " ";
                nextLineText = sc.nextLine();
            }
            System.out.println("" + findUniqWords(tempString));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static HashSet<String> findUniqWords(String tempString) {
        String[] words = tempString.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^\\w]", "");
        }

        HashSet<String> result = new HashSet<String>(tempString.length());
        char[] tempWord;
        for (int i = 0; i < words.length; i++) {
            tempWord = words[i].toLowerCase().toCharArray();
            for (int j = 0; j < tempWord.length - 1; j++) {
                for (int k = j + 1; k < tempWord.length; k++) {
                    if (tempWord[j] == tempWord[k]) {
                        result.add(words[i]);
                    }
                }
            }
        }
        return result;
    }

}
