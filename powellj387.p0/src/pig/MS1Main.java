//@author Julian Powell
package pig;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class MS1Main
{
    public static void main(String[] args)
    {
        //calling constructors
        PigUI myConsoleInterface = new ConsoleInterface(new Scanner(in), out);
        Die myDie = new Die(myConsoleInterface.askUserForSeed());

        //printing the first 10 "random" outputs to the console
        for(int i=0; i<10; ++i)
        {
           System.out.println(myDie.nextRoll());
        }
    }
}
