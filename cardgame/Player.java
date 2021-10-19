package cardgame;

// Player - Simple card game player with name and hand of cards
// author:
// date:
public class Player
{
    // properties
    String name;
    Cards hand;
    
    // constructors
    public Player( String name)
    {
        this.name = name;
        hand = new Cards( false);
    }
    
    // methods
    //gets name of player
    public String getName()
    {
        return name;
    }
    
    //adds card to players hand
    public void add( Card c)
    {
        hand.addTopCard( c);
    }
    
    //returns top card in players hand to play
    public Card playCard()
    {
        return hand.getTopCard();
    }
    
} // end class Player
