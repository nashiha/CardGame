package cardgame;

import java.util.ArrayList;
// Cardgame
// author: David Davenport, Nashiha Ahmed
// date: 28.02.15
public class CardGame
{
    // properties
    Cards             fullPack;
    ArrayList<Player> players;
    ScoreCard         scoreCard;
    Cards[]           cardsOnTable;
    int               roundNo;
    int               turnOfPlayer;
    
    // constructors
    public CardGame( Player p1, Player p2, Player p3, Player p4)
    {
        //Add players to player ArrayList
        players = new ArrayList<Player>();
        players.add( p1);
        players.add( p2);
        players.add( p3);
        players.add( p4);
        
        //Fill pack of cards
        fullPack = new Cards( true);
        
        //Create score card 
        scoreCard = new ScoreCard( 4);
        
        //Create cards on table array with 4 elements
        cardsOnTable = new Cards[ 4];
        for( int i = 0; i < 4; i++)
        {
            cardsOnTable[i] = new Cards( false);
        }
        
        //Initialize round number and turn of player
        roundNo = 0;
        turnOfPlayer = 0;
        
        //Shuffle cards and distribute to players
        fullPack.shuffle();
        for( int i = 0; i < 4; i++)
        {
            for( int j = 0; (fullPack != null); i++)
            {
                for( int k = 0; k < players.size(); k++)
                {
                    players.get(k).add( fullPack.getTopCard());
                }
            }
        }
    }
    
    // methods
    //play turn method: player plays card, if doesn't returns false
    public boolean playTurn( Player p, Card c)
    {
        int playerNo;
        playerNo = 0;
        //get the number of player whose pile the card will be added to
        for( int i = 0; i < players.size(); i++)
        {
            if( players.get(i) == p)
            {
                playerNo = i;
            }
        }
        //if it is the turn of the player and the game is not over, then add the card to the player's pile
        if( isTurnOf(p) && isGameOver())
        {
            cardsOnTable[playerNo].addTopCard(c);
            turnOfPlayer++;
            return true;
        }
        //if all players have played, increase round no and start from the first player again.
        if( turnOfPlayer == 4)
        {
            roundNo++;
            turnOfPlayer = 0;
        }
        return false;
    }
    
    //is turn of method: returns true if it is the turn of the input player, false otherwise
    public boolean isTurnOf( Player p)
    {
        int playerNo;
        playerNo = -1;
        //get the number of player
        for( int i = 0; i < players.size(); i++)
        {
            if( players.get(i) == p)
            {
                playerNo = i;
            }
        }
        if( playerNo == getTurnOfPlayerNo())
        {
            return true;
        }
        return false;
    }
    
    //is game over method: returns true if all the players have played tehir cards
    public boolean isGameOver()
    {
        for( int i = 0; i < players.size(); i++)
        {
            if( players.get(i).hand != null)
            {
                return false;
            }
        }
        return true;
    }
    
    //gets the score of the player at a the indice of the arraylist
    public int getScore( int playerNumber)
    {
        return scoreCard.getScore( playerNumber);
    }
    
    //gets the name of the input player
    public String getName( int playerNumber)
    {
        String name;
        name = "";
        for( int i = 0; i < players.size(); i++)
        {
            if( i == playerNumber)
            {
                name = players.get(i).getName();
            }
        }
        return name;
    }
    
    //gets the round number
    public int getRoundNo()
    {
        return roundNo;
    }
    
    //gets which players turn it is
    public int getTurnOfPlayerNo()
    {
        return turnOfPlayer;
    }
    
    //gets winners of the game
    public Player[] getWinners()
    {
        Player[] winners;
        int[]    winnersNo;
        int      winner;
        winnersNo = scoreCard.getWinners();
        winner = winnersNo[1];
        winners = new Player[1];
        for( int i = 0; i < players.size(); i++)
        {
            if( i == winner)
            {
                winners[1] = players.get(i);
            }
        }
        return winners;
        
    }
    
    //shows the score card
    public String showScoreCard()  // added 2014, David!
    {
        return scoreCard.toString();
    }   
}
//end of CardGame class