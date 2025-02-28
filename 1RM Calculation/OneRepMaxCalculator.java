import java.util.InputMismatchException;
import java.util.Scanner;

public class OneRepMaxCalculator {

    // Method to calculate the 1RM using the Epley formula
    public static double calculateOneRepMax(double weight, int reps) {
        return weight / (1.0278 - (0.0278 * reps));
    }

    // Method to calculate the estimated weight for a given rep count
    public static double calculateEstimatedWeight(double oneRepMax, int reps) {
        return oneRepMax / (1 + ((double) reps / 30));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight = 0;
        int reps = 0;

        // Get weight input with validation
        while (true) {
            try {
                System.out.print("Enter the weight lifted (kg): ");
                weight = scanner.nextDouble();

                if (weight <= 0) {
                    System.out.println("Error: Weight must be a positive number.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid numeric value for weight.");
                scanner.next(); // Clear invalid input
            }
        }

        // Get reps input with validation
        while (true) {
            try {
                System.out.print("Enter the number of reps performed: ");
                reps = scanner.nextInt();

                if (reps <= 0) {
                    System.out.println("Error: Reps must be a positive number.");
                } else if (reps > 10) {
                    System.out.println("Warning: The Epley formula is most accurate for reps ≤ 10.");
                    break;
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid whole number for reps.");
                scanner.next(); // Clear invalid input
            }
        }

        // Call the method to calculate the 1RM
        double oneRepMax = calculateOneRepMax(weight, reps);
        System.out.printf("Estimated 1RM: %.2f kg\n", oneRepMax);

        // Output the estimated weight for 2, 3, 4, and 5 reps
        System.out.printf("Estimated 2RM: %.2f kg\n", calculateEstimatedWeight(oneRepMax, 2));
        System.out.printf("Estimated 3RM: %.2f kg\n", calculateEstimatedWeight(oneRepMax, 3));
        System.out.printf("Estimated 4RM: %.2f kg\n", calculateEstimatedWeight(oneRepMax, 4));
        System.out.printf("Estimated 5RM: %.2f kg\n", calculateEstimatedWeight(oneRepMax, 5));
        System.out.printf("Estimated 6RM: %.2f kg\n", calculateEstimatedWeight(oneRepMax, 6));
        System.out.printf("Estimated 7RM: %.2f kg\n", calculateEstimatedWeight(oneRepMax, 7));
        System.out.printf("Estimated 8RM: %.2f kg\n", calculateEstimatedWeight(oneRepMax, 8));

        scanner.close();
    }
}
