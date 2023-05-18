//@author Julian Powell
package pig;

public class PigGame
{
    public static int GOAL_SCORE;
    public static int PIG_DIE_SCORE;
    private PigPlayer player1;
    private PigPlayer player2;
    private int player1Score;
    private int player2Score;
    private int playerTurn;
    private PigUI gameUI;
    private Die gameDie;

    public PigGame(PigPlayer playerOne, PigPlayer playerTwo, int seed, PigUI ui)
    {
        //initializing variables to be used within the play() function
        GOAL_SCORE = 100;
        PIG_DIE_SCORE = 1;
        player1Score = 0;
        player2Score = 0;
        player1 = playerOne;
        player2 = playerTwo;
        playerTurn = 1;
        gameUI= ui;
        gameDie = new Die(seed);
    }
    public void play() {

        int possibleNewScore=0;
        //This outermost while-loop ensures that the game ends when either of the players hit the target score
        while (player1Score < GOAL_SCORE && player2Score < GOAL_SCORE) {
            gameUI.displayCurrentScores(player1Score, player2Score);
            gameUI.displayPlayersTurn(playerTurn);

            int roll = gameDie.nextRoll();
            gameUI.displayRollResult(roll);
            boolean keepRolling = player1.isRolling(player1Score, player2Score, roll);
            int total = roll;
            //Loop for the player 1 roll actions which will continue as long as the player wants to, they haven't
            // won yet, and they have not rolled a "pig"
            while (possibleNewScore<GOAL_SCORE && keepRolling && roll != PIG_DIE_SCORE) {
                roll = gameDie.nextRoll();
                total += roll;

                //the "if" portion is checking to make sure that the user did not roll a "pig", and if they did
                // their total for this turn gets set to 0
                if (roll == PIG_DIE_SCORE) {
                    total = 0;
                    gameUI.displayRollResult(roll);
                }
                //the else portion simply allows the player to continue their turn if they wish
                else
                {
                    gameUI.displayRollResult(roll);
                    possibleNewScore = player1Score+total;
                    keepRolling = player1.isRolling(player1Score, player2Score, total);
                }
            }
            player1Score += total;

            //displaying game information following player1's turn
            gameUI.displayTurnResults(playerTurn, total, player1Score);
            total = 0;
            gameUI.displayCurrentScores(player1Score, player2Score);
            playerTurn = 2;
            gameUI.displayPlayersTurn(playerTurn);

            keepRolling = true;
            roll = 0;
            possibleNewScore = 0;
            //similar to the player 1 while loop this one checks to make sure the player has not won yet, they
            // haven't rolled a pig, and the requirements are met for the CPU to continue rolling
            while(possibleNewScore<GOAL_SCORE && keepRolling && roll != PIG_DIE_SCORE) {
                roll = gameDie.nextRoll();
                total += roll;

                gameUI.displayRollResult(roll);

                //checking to make sure that the user did not roll a "pig", and if they did
                // their total for this turn gets set to 0
                if (roll == PIG_DIE_SCORE)
                {
                    total = 0;
                }
                possibleNewScore = player2Score+total;
                keepRolling = player2.isRolling(player2Score, player1Score, total);
            }
            player2Score+=total;


            gameUI.displayTurnResults(playerTurn, total, player2Score);
            total = 0;
            playerTurn = 1;
        }
        gameUI.displayGameOver(player1Score,player2Score);
    }
}
