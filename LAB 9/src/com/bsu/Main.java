package com.bsu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Flats> minskFlats = Arrays.asList(
                new Flats("Ivanov's flat", 34.5, "Nemiga", 240),
                new Flats("Levakov's flat", 216, "Malinovka", 320),
                new Flats("Karpovich's flat", 64.5, "Sportivnaya", 150),
                new Flats("Filiptsov's flat", 150, "Nemiga", 510),
                new Flats("Volchkova's flat", 75.3, "Nemiga", 15));


        List<Flats> test1 = minskFlats.stream().filter(f -> f.getNearestMetro().equals("Nemiga")).collect(Collectors.toList());
        test1.forEach(System.out::println);
        System.out.println();

        System.out.println(minskFlats.stream().filter(f -> f.getNumOfSqM() > 100).count() + "\n");

        System.out.println(minskFlats.stream().filter(f -> f.getNumOfSqM() > 100 && "Nemiga".equals(f.getNearestMetro())).findAny() + "\n");

        System.out.println(minskFlats.stream().allMatch(f -> f.getNumOfSqM() > 10) + "\n");

        System.out.println(minskFlats.stream().collect(Collectors.groupingBy(Flats::getNearestMetro)) + "\n");

        minskFlats.stream().map(f -> f.getNameOfFlat() + " - " + f.getPricePerMonth() + "$").forEach(System.out::println);


    }
}