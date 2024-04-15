import java.util.Random;
import java.util.Scanner;

public class RandomNumberGame
{
    final int MIN = 1,
            MAX = 100;
    final String PICK_NUMBER = "Pick a number between " + MIN + " and " + MAX,
            OUT_OF_RANGE = "Your guess is not between " + MIN + " and " + MAX + ", please try again",
            HIGHER = "Please pick a higher number",
            LOWER = "Please pick a lower number",
            WIN = "You win!",
            LOSE = "You lose, the number was ";

    RandomNumberGame()
    {
        int randomNumber = getRandom();
        guessNumber(randomNumber);
    }

    // Generate random number to be guessed
    private int getRandom()
    {
        Random random = new Random();
        // + 1 added to make the upperbound inclusive
        return random.nextInt((MAX + 1) - MIN) + MIN;
    }

    // play game
    private void guessNumber(int numToGuess) {
        while (true) {
            // user picks a number
            Scanner scanner = new Scanner(System.in);
            System.out.println(PICK_NUMBER);
            int userInput = scanner.nextInt();
            System.out.println("Random Num: " + numToGuess);

            // validate range
            if (userInput >= MIN && userInput <= MAX) {
                // four more guesses
                for (int i = 0; i < 4; i++) {
                    // user input too small
                    if (userInput < numToGuess) {
                        System.out.println(HIGHER);
                    }
                    // user input too large
                    else if (userInput > numToGuess) {
                        System.out.println(LOWER);
                    }
                    // number guessed correctly
                    else {
                        System.out.println(WIN);
                        scanner.close();
                        return;
                    }

                    // get next guess
                    userInput = scanner.nextInt();
                }

                // user loses and num to guess is revealed
                System.out.println(LOSE + numToGuess);
                scanner.close();
                return;
            } else {
                System.out.println(OUT_OF_RANGE);
            }
        }
    }
}
