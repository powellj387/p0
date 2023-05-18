//@author Julian Powell
package pig;

public class HoldAtXPigPlayer
        extends java.lang.Object
        implements PigPlayer
{
    private final int xToHoldAt;
    public HoldAtXPigPlayer(int x)
    {
        xToHoldAt = x;
    }

    public boolean isRolling(int myScore, int otherScore, int turnTotal)
    {
        return (myScore<100 && turnTotal<xToHoldAt && otherScore<100);//returns true if both players have not won yet
                                                                      // and the total rolls in this turn do not
                                                                      //exceed the specified hold value
    }
}
