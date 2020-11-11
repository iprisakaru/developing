package com.bsu;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Company> companies = new ArrayList<>();

    static Query req = new Query();
    static List<Company> result = new ArrayList<>();

    public static void main(String[] args) {
        try (FileReader reader = new FileReader("input.txt");
             Scanner scan = new Scanner(reader); Scanner scanIn = new Scanner(System.in)) {

            while (scan.hasNextLine()) {
                String str = scan.nextLine();
                String[] arr = str.split(";");

                Company compInfo = new Company(arr);

                companies.add(compInfo);
            }
            menu(scanIn);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void printOutput(List<Company> result) throws Exception {
        for (Company i : result) {
            System.out.println(i.getNameOfCompany());
            resultOutput("Result of your request: " + i.getNameOfCompany());
        }
    }

    static void resultOutput(String str) throws Exception {
        try (FileWriter writer = new FileWriter("logfile.txt", true)) {
            writer.write(str + "\n");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    static public void getTime() throws Exception {
        try (FileWriter writer = new FileWriter("logfile.txt", true)) {
            Date date = new Date();
            writer.write("\n" + date.toString() + "\n");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void menu(Scanner in) throws Exception {
        System.out.println("\n\n\bMENU");
        System.out.println("Here are all request types: ");
        System.out.println("1. Find a company by short name");
        System.out.println("2. Find companies by department of work");
        System.out.println("3. Find companies by activity kind");
        System.out.println("4. Find companies by foundation date (from [year] to [year]) ");
        System.out.println("5. Find companies by employees number (from [number] to [number])");
        int fromData;
        int toData;

        String task;
        int msg = in.nextInt();
        switch (msg) {
            case 1:
                System.out.println("Enter the short name of the company: ");
                task = in.next();
                System.out.println("I'm thinking about your request:)... ");
                result = req.findShortNameOfCompany(task, companies);
                getTime();
                try (FileWriter writer = new FileWriter("logfile.txt", true)) {
                    writer.write("Request was -" + task + "-;\n");
                    writer.write(result.size() + " companies was found\n");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case 2:
                System.out.println("Enter the department of work: ");
                task = in.next();
                System.out.println("I'm thinking about your request:)... ");
                result = req.findIndustry(task, companies);
                getTime();
                try (FileWriter writer = new FileWriter("logfile.txt", true)) {
                    writer.write("Request was -" + task + "-;\n");
                    writer.write(result.size() + " companies was found\n");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case 3:
                System.out.println("Enter the kind of activity: ");
                task = in.next();
                System.out.println("I'm thinking about your request:)... ");
                result = req.findKindOfActivity(task, companies);
                getTime();
                try (FileWriter writer = new FileWriter("logfile.txt", true)) {
                    writer.write("Request was -" + task + "-;\n");
                    writer.write(result.size() + " companies was found\n");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case 4:
                System.out.println("Enter the beginnings of company foundation: ");
                fromData = Integer.parseInt(in.next());
                System.out.println("Ok, right...\nEnter the endings of company foundation: ");
                toData = Integer.parseInt((in.next()));
                System.out.println("I'm thinking about your request:)... ");
                result = req.findDateOfFoundation(fromData, toData, companies);
                getTime();
                try (FileWriter writer = new FileWriter("logfile.txt", true)) {
                    writer.write("Request to find companies that founded from " + fromData + " to " + toData + ";\n");
                    writer.write(result.size() + " companies was found\n");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case 5:
                System.out.println("Enter beginning of the interval of the number: ");
                fromData = Integer.parseInt(in.next());
                System.out.println("Ok, right...\nEnter ending of the interval of the number:: ");
                toData = Integer.parseInt((in.next()));
                System.out.println("I'm thinking about your request:)... ");
                result = req.findCountOfEmployees(fromData, toData, companies);
                getTime();
                try (FileWriter writer = new FileWriter("logfile.txt", true)) {
                    writer.write(result.size() + " companies was found\n");
                    writer.write("Request to find companies with the number workers from " + fromData + " to " + toData + ";\n");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            default:
                System.out.println("I'm sorry:( \n Check your request again");
                break;
        }
        printOutput(result);
        menu(in);
    }


}

