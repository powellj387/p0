//@author Julian Powell
package pig;

import java.io.PrintStream;
import java.util.Scanner;
public class ConsoleInterface implements PigUI
{
    private final Scanner userInput;
    private final PrintStream output;

    public ConsoleInterface(java.util.Scanner scanner, java.io.PrintStream out)
    {
        userInput = scanner;
        output = out;
    }
    public int askUserForSeed()
    {
        output.println("What seed would you like?");

        String userSeed = userInput.nextLine();
        return Integer.valueOf(userSeed); 
    }
    public void displayCurrentScores(int player1Score, int player2Score)
    {
       output.print("Player 1 score: ");
       output.println(player1Score);

       output.print("Player 2 score: ");
       output.println(player2Score);
    }
    public void displayGameOver(int player1Score,int player2Score)
    {
        output.println("Game Over!!!");

        output.print("Player 1 score: ");
        output.println(player1Score);

        output.print("Player 2 score: ");
        output.println(player2Score);

    }
    public void displayPlayersTurn(int playerNumber)
    {
        output.print("It is player ");
        output.print(playerNumber);
        output.println("'s turn.");
    }
    public void displayRollResult(int diceRoll)
    {
        output.print("Roll: ");
        output.println(diceRoll);
    }
    public void displayTurnResults(int playerNumber, int turnTotal, int newScore)
    {
        output.print("Turn total: ");
        output.println(turnTotal);

        output.print("New score: ");
        output.println(newScore);
    }
}
