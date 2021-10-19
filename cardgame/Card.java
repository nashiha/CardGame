package cardgame;

/**
 * Card - a single playing card
 * @author: David Davenport, Nashiha Ahmed
 * @version: 1/ 28.02.15
 */

public class Card
{
    //constants
    final String[] SUITS = { "Hearts", "Diamonds", "Spades", "Clubs"};
    final String[] FACES = { "A", "2", "3", "4", "5",
        "6", "7", "8", "9", "10",
        "J", "Q", "K"};
    
    // properties
    int  cardNo;
    
    // constructors
    public Card( int faceValue, int suit )
    {
        cardNo = faceValue + suit * 13;
    }
    
    public Card( int cardNumber)
    {
        cardNo = cardNumber;
    }
    
    //methods
    //get face value method
    public int getFaceValue()
    {
        return cardNo % 13;
    }
    
    //get suit method
    public int getSuit()
    {
        return cardNo / 13;
    }
    
    //toString method
    public String toString()
    {
        return FACES[ getFaceValue() ] + " of " + SUITS[ getSuit() ];
    }
    
    //equals method
    public boolean equals( Card c)
    {
        if( c != null)
        {
            return this.getFaceValue() == c.getFaceValue() && this.getSuit() == c.getSuit();
        }
        return false; 
    }
    
    //compare method
    public int compareTo( Card c)
    {
        if( c != null)
        {
            if( this.cardNo == c.cardNo)
            {
                return 0;
            }
            else if( this.cardNo > c.cardNo)
            {
                return 1;
            }
            else if( this.cardNo < c.cardNo)
            {
                return 2;
            }
        }
        return -1;
    }
}
//end of Card class