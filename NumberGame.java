import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println("=========================================");
        System.out.println("      WELCOME TO THE NUMBER GAME!        ");
        System.out.println("=========================================");
        System.out.println("Guess a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
        System.out.println("You have up to " + MAX_ATTEMPTS + " attempts per round.");

        boolean playAgain = true;

        while (playAgain) {
            roundsPlayed++;
            int targetNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n--- Round " + roundsPlayed + " Started ---");

            while (attemptsUsed < MAX_ATTEMPTS) {
                int guess = readGuess(scanner, attemptsUsed + 1);
                attemptsUsed++;

                if (guess == targetNumber) {
                    guessedCorrectly = true;
                    roundsWon++;
                    int attemptsLeft = MAX_ATTEMPTS - attemptsUsed;
                    int roundScore = (attemptsLeft + 1) * 10;
                    totalScore += roundScore;

                    System.out.println("Correct! You guessed it in " + attemptsUsed +
                            (attemptsUsed == 1 ? " attempt." : " attempts."));
                    System.out.println("Round Score: +" + roundScore + " | Total Score: " + totalScore);
                    break;
                } else if (guess > targetNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }

                int remaining = MAX_ATTEMPTS - attemptsUsed;
                if (remaining > 0) {
                    System.out.println("Attempts remaining: " + remaining);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The number was: " + targetNumber);
                System.out.println("Current Total Score: " + totalScore);
            }

            playAgain = askPlayAgain(scanner);
        }

        System.out.println("\n=========================================");
        System.out.println("              FINAL SUMMARY              ");
        System.out.println("=========================================");
        System.out.println("Rounds Played : " + roundsPlayed);
        System.out.println("Rounds Won    : " + roundsWon);
        System.out.println("Final Score   : " + totalScore);
        System.out.println("Thanks for playing!");

        scanner.close();
    }

    private static int readGuess(Scanner scanner, int attemptNumber) {
        while (true) {
            System.out.print("Attempt " + attemptNumber + " - Enter your guess (" +
                    MIN_NUMBER + "-" + MAX_NUMBER + "): ");
            if (scanner.hasNextInt()) {
                int guess = scanner.nextInt();
                if (guess >= MIN_NUMBER && guess <= MAX_NUMBER) {
                    return guess;
                }
                System.out.println("Please enter a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.next();
            }
        }
    }

    private static boolean askPlayAgain(Scanner scanner) {
        while (true) {
            System.out.print("\nDo you want to play another round? (y/n): ");
            String choice = scanner.next().trim().toLowerCase();
            if (choice.equals("y") || choice.equals("yes")) {
                return true;
            } else if (choice.equals("n") || choice.equals("no")) {
                return false;
            }
            System.out.println("Please enter 'y' or 'n'.");
        }
    }
}