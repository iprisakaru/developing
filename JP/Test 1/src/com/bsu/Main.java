package com.bsu;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

    static List<Users> us = new ArrayList<>();
    static List<Horses> hs = new ArrayList<>();
    static Query req = new Query();
    static List<Horses> result = new ArrayList<>();

    public static void main(String[] args) {
        try (FileReader reader = new FileReader("users.txt");
             Scanner scan = new Scanner(reader);
             Scanner scanIn = new Scanner(System.in)) {

            while (scan.hasNextLine()) {
                String str = scan.nextLine();
                String[] arr = str.split(";");

                Users userInfo = new Users(arr);

                us.add(userInfo);
            }

            menuRegistr(scanIn);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try (FileReader reader = new FileReader("horses.txt");
             Scanner scan2 = new Scanner(reader);
             Scanner scanIn2 = new Scanner(System.in)) {

            while (scan2.hasNextLine()) {
                String str1 = scan2.nextLine();
                String[] arr2 = str1.split(";");

                Horses horsesInfo = new Horses(arr2);

                hs.add(horsesInfo);
            }

            menuAfterRegistr(scanIn2);


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void menuAfterRegistr(Scanner in2) throws Exception{
        System.out.println("1. View all records");
        System.out.println("2. Search for a horse by number(access rights required) ");
        System.out.println("3. View all stats of all horses");
        System.out.println("4. Exit.");
        String task="";
        int msg = in2.nextInt();
        switch (msg) {
            case 1:
                System.out.println("All records:");
                outAllRecords(hs);
            break;
            case 2:

                System.out.println("Enter the number of horse:");
                task=in2.next();
                System.out.println("Searching your horse:)");
                result=req.findHorse(task,hs);
                printOutHorse(result);
                break;

            default:
                System.out.println("I'm sorry:( \n Check your request again");
                break;
        }
    }

    public static void menuRegistr(Scanner in) throws Exception {
        System.out.println("\n\n\bMENU");
        System.out.println("Choose one of the actions: ");
        System.out.println("1. Sing Up");
        System.out.println("2. Sing In");
        int mainMsg = in.nextInt();
        String un;
        String pass;
        String task="";
        switch (mainMsg){
            case 1:
                System.out.println("Enter your username:");
                task=task + in.next() + ";";
                System.out.println("Enter your login:");
                task=task + in.next() + ";";
                System.out.println("Enter your email:");
                task=task + in.next() + ";";
                System.out.println("Enter your password:");
                task=task + in.next() + ";";
                try (FileWriter writer = new FileWriter("users.txt", true)) {
                    writer.write("\n"+task);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println("You are signed.");

                break;
            case 2:
                System.out.println("Enter your username:");
                un = in.next();
                System.out.println("Enter your password:");
                pass=in.next();
                if (checkUser(un,pass,us)) { System.out.println("You have entered.");}
                else System.out.println("Check your data. And try again");
                break;
            default:
                System.out.println("I'm sorry:( \n Check your request again");
                break;

        }

    }

    static void printOutHorse(List<Horses>result) throws Exception {
        System.out.println("Horses that was found:");
        for (Horses i : result) {
            System.out.println(i.getHorseName()+"\n"+i.getUniqueNumber()+"\n"+i.getDateOfBirth()+"\n"+i.getKindOfCompetition()+"\n"+i.getNumberOfWins());
        }
    }
    static void resultOutput(String str) throws Exception {
        try (FileWriter writer = new FileWriter("logfile.txt", true)) {
            writer.write(str + "\n");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

   static boolean checkUser(String un, String pass, List<Users>us){
        int tmp=0;
        for (Users i : us) {
            if ((i.getUsername().equals(un))&&(i.getPassword().equals(pass))) {
                tmp++;
            }
        }
        return (tmp>0);
    }
    static void outAllRecords(List<Horses>hs){
        for(Horses i: hs){
            System.out.println(i.getHorseName()+"\n"+i.getDateOfBirth()+"\n"+i.getNumberOfWins()+"\n");
        }
    }

}

