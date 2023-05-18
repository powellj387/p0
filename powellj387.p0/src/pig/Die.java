//@author Julian Powell
package pig;

import java.util.Random;


public class Die
{
    private final int sides;
    int[] possOutcomes;
    Random random = new Random();

    public Die(long Seed)
    {
        sides = 6;
        possOutcomes = new int[sides];
        random.setSeed(Seed);

        for(int i=0;i<6;++i)    //makes the outcome array of an ordinary die ie.{1,2,3,4,5,6}
        {
            possOutcomes[i]=i+1;
        }
    }
    public Die(long Seed, int[] outcomes)
    {
        sides = outcomes.length;
        possOutcomes = new int[sides];
        random.setSeed(Seed);

        for(int i=0;i<sides;++i)    //makes each index of the outcome array of the die equal to the
                                    // corresponding index of the array passed in
        {
            possOutcomes[i]=outcomes[i];
        }
    }

    public int nextRoll()
    {
        int index = random.nextInt(sides);
        return possOutcomes[index];
    }
}

