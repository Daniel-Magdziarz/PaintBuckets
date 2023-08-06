/*This program calculates the amount of buckets needed to paint a wall. It features an interactive menu,
.hasNextInt, Enhanced Switch & stripIndent (Java 14 and up), try-catch, and method overloading.
This was written in IntelliJ with Java 17*/
//Author: Daniel Magdziarz

import java.util.Scanner;

public class Main {
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        boolean quit = false;
        int userInputIntMenu;
        menu();
        while (!quit) {
            System.out.print("Enter menu choice: ");
            boolean isInteger = keyboard.hasNextInt();
            if (isInteger) {
                userInputIntMenu = keyboard.nextInt();
                keyboard.nextLine();
            } else {
                String wrongInput = keyboard.nextLine();
                System.out.println("\"" + wrongInput + "\" is a wrong input. Enter numerical value for menu selection.");
                continue;
            }

            switch (userInputIntMenu) {
                case 0 -> menu();
                case 1 -> {
                    double width, height, areaPerBucket, extraBuckets;
                    System.out.println("Enter width of the wall. ");
                    width = inputValidationDouble();
                    System.out.println("Enter height of the wall. ");
                    height = inputValidationDouble();
                    System.out.println("Enter the area that a bucket can cover. ");
                    areaPerBucket = inputValidationDouble();
                    System.out.println("Enter the amount of buckets you have in stock. ");
                    extraBuckets = inputValidationDouble();
                    System.out.println("\nThere are " + getBucketCount(width, height, areaPerBucket, extraBuckets)
                            + " buckets needed for the job.");
                }
                case 2 -> {
                    double width, height, areaPerBucket;
                    System.out.println("Enter width of the wall. ");
                    width = inputValidationDouble();
                    System.out.println("Enter height of the wall. ");
                    height = inputValidationDouble();
                    System.out.println("Enter the area that a bucket can cover. ");
                    areaPerBucket = inputValidationDouble();
                    System.out.println("\nThere are " + getBucketCount(width, height, areaPerBucket)
                            + " buckets needed for the job.");
                }
                case 3 -> {
                    double area, areaPerBucket;
                    System.out.println("Enter the area of the wall. ");
                    area = inputValidationDouble();
                    System.out.println("Enter the area that a bucket can cover. ");
                    areaPerBucket = inputValidationDouble();
                    System.out.println("There are " + getBucketCount(area, areaPerBucket)
                            + " buckets needed for the job.");
                }
                case 4 -> {
                    System.out.println("Bye...");
                    quit = true;
                }
                default -> System.out.println("Wrong menu selection. Try again.");
            }
        }
        keyboard.close();
    }

    public static int getBucketCount(double width, double height, double areaPerBucket, double extraBuckets) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0) {
            return -1;
        }

        int extraBucketsWhole = (int) Math.floor(extraBuckets);

        int bucketsNeeded = (int) (Math.ceil((width * height) / areaPerBucket) - extraBucketsWhole);
        return bucketsNeeded < 0 ? 0 : bucketsNeeded;
    }

    public static int getBucketCount(double width, double height, double areaPerBucket) {

        return getBucketCount(width, height, areaPerBucket, 0);
    }

    public static int getBucketCount(double area, double areaPerBucket) {
        if (area <= 0 || areaPerBucket <= 0) {
            return -1;
        }

        return (int) (Math.ceil((area / areaPerBucket)));
    }

    public static double inputValidationDouble() {
        double userInput;
        while (true) {
            System.out.print("\tInput: ");
            String userInputStr = keyboard.nextLine();
            try {
                userInput = Double.parseDouble(userInputStr);
                return userInput;
            } catch (NumberFormatException nfe) {
                System.out.println("Please provide a numerical value only.");
            }
        }
    }

    public static void menu() {
        System.out.println("""
                    \n***This program calculates the amount of paint buckets needed to paint a wall***
                0. Press 0 to see the Main Menu.
                1. Press 1 if you have the following:
                    a) Wall's WIDTH.
                    b) Wall's HEIGHT.
                    b) AREA that a bucket can cover.
                    c) The amount of EXTRA BUCKETS in stock.
                2. Press 2 if you have the following:
                    a) Wall's WIDTH.
                    b) Wall's HEIGHT.
                    c) AREA that a bucket can cover.
                3. Press 3 if you have the following:
                    a) AREA of the wall.
                    b) AREA that a bucket can cover.
                4. Press 4 to exit.
                """);
    }
}
