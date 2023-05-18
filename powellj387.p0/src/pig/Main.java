//@author Julian Powell
package pig;

import java.io.PrintStream;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args)
    {
        //constructor calling
        Scanner scan = new Scanner(in);
        PrintStream output = new PrintStream(out);
        PigUI gameInterface = new ConsoleInterface(new Scanner(in), out);

        ConsolePigPlayer player1 = new ConsolePigPlayer(scan,output);
        ConsolePigPlayer player2 = new ConsolePigPlayer(scan, output);

        //placing seed for the game
        int gameSeed = gameInterface.askUserForSeed();

        //calling PigGame constructor and running the game itself
        PigGame myGame = new PigGame(player1,player2, gameSeed, gameInterface);
        myGame.play();
    }
}

