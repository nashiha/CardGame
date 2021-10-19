package cardgame;

// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author:
// date:
public class ScoreCard
{
    // properties
    int[] scores;
    
    // constructors
    public ScoreCard( int noOfPlayers)
    {
        scores = new int[noOfPlayers];
        
        // init all scores to zero
        for ( int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }
    
    // methods
    //gets the scores of the input player
    public int getScore( int playerNo)
    {
        return scores[ playerNo];
    }
    
    //updates the players score by input amount
    public void update( int playerNo, int amount)
    {
        scores[playerNo] += amount;
    }
    
    //prints the score card
    public String toString()
    {
        String s;
        s = "\n"
            + "_____________\n"
            + "\nPlayer\tScore\n"
            + "_____________\n";
        
        for ( int playerNo = 0; playerNo < scores.length; playerNo++)
        {
            s = s + playerNo + "\t" + scores[playerNo] + "\n";
        }
        
        s += "_____________\n";
        return s;
    }
    
    //gets winners of the game
    public int[] getWinners()
    {
        int i;
        int max;
        int[] winners;
        max = 0;
        winners = new int[1];
        for( i = 0; i < scores.length; i++)
        {
            if( scores[i] > max)
            {
                winners[1] = i;
                max = scores[i];
            }
        }
        return winners;
    }
    
} // end class ScoreCard
