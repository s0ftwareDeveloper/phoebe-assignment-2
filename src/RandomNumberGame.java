import java.util.Random;
import java.util.Scanner;

public class RandomNumberGame
{
    final int MIN = 1,
            MAX = 100,
            MAX_GUESSES = 5;
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
        Scanner scanner = new Scanner(System.in);
        int guessCount = 0;

        while (true) {

            // user picks a number
            System.out.println(PICK_NUMBER);
            int userInput = scanner.nextInt();

            // validate range
            if (userInput >= MIN && userInput <= MAX)
            {
                //add to guess count
                guessCount++;

                // number guessed correctly
                if(userInput == numToGuess)
                {
                    System.out.println(WIN);
                    //exits method
                    return;
                }
                // ran out of guesses
                else if(guessCount >= MAX_GUESSES)
                {
                    // too many guesses
                    break;
                }
                // user input too small
                else if (userInput < numToGuess) {
                    System.out.println(HIGHER);
                }
                // user input too large
                else {
                    System.out.println(LOWER);
                }

            }
            else
            {
                System.out.println(OUT_OF_RANGE);
            }
        }

        // user loses and num to guess is revealed
        System.out.println(LOSE + numToGuess);
        scanner.close();
    }
}
