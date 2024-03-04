import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*
     * Author: Farrell, J (2018)
     * Title: Java Programming, Ninth Edition
     * Publisher: Cengage
     * Year: 2018
     */

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        
        /*
     * Author: Farrell, J (2018)
     * Title: Java Programming, Ninth Edition
     * Publisher: Cengage
     * Year: 2018
     */

        do {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + (rounds + 1) + ": Guess the number between " + lowerBound + " and " + upperBound);

            while (attempts < maxAttempts && !guessedCorrectly) {
                int userGuess = getUserInput(scanner);

                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                    guessedCorrectly = true;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've reached the maximum number of attempts. The correct number was: " + targetNumber);
            }

            rounds++;

            System.out.print("\nDo you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("\nGame Over! Your total score is: " + score);
        scanner.close();
    }

    private static int getUserInput(Scanner scanner) {
        int userGuess = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
                scanner.nextLine(); 
            }
        }

        return userGuess;
    }
}
/*
     * Author: Farrell, J (2018)
     * Title: Java Programming, Ninth Edition
     * Publisher: Cengage
     * Year: 2018
     */
