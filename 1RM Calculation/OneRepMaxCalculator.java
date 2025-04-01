import java.util.InputMismatchException;
import java.util.Scanner;

public class OneRepMaxCalculator {

    public static double calculateOneRepMax(double weight, int reps) {
        return weight / (1.0278 - (0.0278 * reps));
    }

    public static double calculateEstimatedWeight(double oneRepMax, int reps) {
        return oneRepMax / (1 + ((double) reps / 30));
    }

    private static double getValidDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double input = scanner.nextDouble();
                if (input > 0) return input;
                System.out.println("Error: Value must be a positive number.");
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid numeric value.");
                scanner.next();
            }
        }
    }

    private static int getValidIntInput(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = scanner.nextInt();
                if (input >= min && input <= max) return input;
                System.out.println("Error: Value must be between " + min + " and " + max + ".");
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid whole number.");
                scanner.next();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double weight = getValidDoubleInput(scanner, "Enter the weight lifted (kg): ");
        int reps = getValidIntInput(scanner, "Enter the number of reps performed: ", 1, 10);

        double oneRepMax = calculateOneRepMax(weight, reps);
        System.out.printf("Estimated 1RM: %.2f kg\n", oneRepMax);

        for (int i = 2; i <= 8; i++) {
            System.out.printf("Estimated %dRM: %.2f kg\n", i, calculateEstimatedWeight(oneRepMax, i));
        }

        scanner.close();
    }
}
