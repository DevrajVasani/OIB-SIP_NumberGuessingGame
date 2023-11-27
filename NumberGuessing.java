import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 10; // Set a maximum number of attempts
        int attempts = 0;
        int correctGuesses = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ". Try to guess it.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");

            if (scanner.hasNextInt()) {
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    correctGuesses++;
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume invalid input to avoid an infinite loop
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + numberToGuess + ".");
        }

        double accuracy = (double) correctGuesses / attempts * 100;
        int score = calculateScore(attempts);
        System.out.println("Game Over. Accuracy: " + accuracy + "%, Score: " + score);

        scanner.close();
    }

    private static int calculateScore(int attempts) {
        if (attempts >= 1 && attempts <= 10) {
            return 1;
        } else if (attempts >= 11 && attempts <= 20) {
            return 2;
        } else if (attempts >= 21 && attempts <= 30) {
            return 3;
        } else if (attempts >= 31 && attempts <= 40) {
            return 4;
        } else if (attempts >= 41 && attempts <= 50) {
            return 5;
        } else if (attempts >= 51 && attempts <= 60) {
            return 6;
        } else if (attempts >= 61 && attempts <= 70) {
            return 7;
        } else if (attempts >= 71 && attempts <= 80) {
            return 8;
        } else if (attempts >= 81 && attempts <= 90) {
            return 9;
        } else {
            return 10; // Maximum score for attempts 91-100
        }
    }
}
