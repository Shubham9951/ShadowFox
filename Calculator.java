import java.util.Scanner;

public class Calculator {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n==== Enhanced Console Calculator ====");
            System.out.println("1. Basic Arithmetic");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> basicArithmetic();
                case 2 -> scientificCalculations();
                case 3 -> unitConversions();
                case 4 -> {
                    System.out.println("Exiting calculator. Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // Basic Arithmetic
    static void basicArithmetic() {
        System.out.println("\n-- Basic Arithmetic --");
        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();

        System.out.println("Select operation (+ - * /): ");
        char op = scanner.next().charAt(0);

        switch (op) {
            case '+' -> System.out.println("Result: " + (a + b));
            case '-' -> System.out.println("Result: " + (a - b));
            case '*' -> System.out.println("Result: " + (a * b));
            case '/' -> {
                if (b != 0) {
                    System.out.println("Result: " + (a / b));
                } else {
                    System.out.println("Error: Cannot divide by zero!");
                }
            }
            default -> System.out.println("Invalid operator!");
        }
    }

    // Scientific Calculations
    static void scientificCalculations() {
        System.out.println("\n-- Scientific Calculations --");
        System.out.println("1. Square Root");
        System.out.println("2. Power (x^y)");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                System.out.print("Enter number: ");
                double num = scanner.nextDouble();
                if (num >= 0) {
                    System.out.println("Square root: " + Math.sqrt(num));
                } else {
                    System.out.println("Error: Cannot take square root of negative number.");
                }
            }
            case 2 -> {
                System.out.print("Enter base: ");
                double base = scanner.nextDouble();
                System.out.print("Enter exponent: ");
                double exponent = scanner.nextDouble();
                System.out.println("Result: " + Math.pow(base, exponent));
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    // Unit Conversions
    static void unitConversions() {
        System.out.println("\n-- Unit Conversions --");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. USD to INR");
        System.out.println("4. INR to USD");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                System.out.print("Enter temperature in Celsius: ");
                double c = scanner.nextDouble();
                System.out.println("Fahrenheit: " + (c * 9 / 5 + 32));
            }
            case 2 -> {
                System.out.print("Enter temperature in Fahrenheit: ");
                double f = scanner.nextDouble();
                System.out.println("Celsius: " + ((f - 32) * 5 / 9));
            }
            case 3 -> {
                System.out.print("Enter USD: ");
                double usd = scanner.nextDouble();
                System.out.println("INR: " + (usd * 83.0)); // Approximate rate
            }
            case 4 -> {
                System.out.print("Enter INR: ");
                double inr = scanner.nextDouble();
                System.out.println("USD: " + (inr / 83.0));
            }
            default -> System.out.println("Invalid option.");
        }
    }
}
