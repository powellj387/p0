//@author Julian Powell
package pig;

import java.io.PrintStream;
import java.util.Scanner;

public class ConsolePigPlayer implements PigPlayer
{
    private final Scanner userInput;
    private final PrintStream output;

    public ConsolePigPlayer(java.util.Scanner scanner, java.io.PrintStream out)
    {
        userInput = scanner;
        output = out;
    }
    public boolean isRolling(int myScore, int otherScore, int turnTotal)
    {
        output.print("Turn total: ");
        output.print(turnTotal);
        output.print("\tRoll/Hold? ");

        String decision = userInput.nextLine();
        return(myScore<100&&otherScore<100&&decision.length()<1); //returns true if both players have not won yet
                                                                  // and the input by the user is nothing more
                                                                  //than them pressing the enter key
    }
}
