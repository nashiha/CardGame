package cardgame;
import java.util.*;
// Cards - Maintains a collection of zero or more playing cards.
//         Provides facilities to create a full pack of 52 cards
//         and to shuffle the cards.
// author: David Davenport, Nashiha Ahmed
// date: 28.02.15
public class Cards
{
    final int NOOFCARDSINFULLPACK = 52;
    
    // properties
    Card[] cards;
    int    valid;
    
    // constructors
    public Cards( boolean fullPack)
    {
        cards = new Card[ NOOFCARDSINFULLPACK ];
        valid = 0;
        
        if ( fullPack)
            createFullPackOfCards();
    }
    
    // methods
    //gets Top Card from deck
    public Card getTopCard()
    {
        Card tmp;
        
        if ( valid <= 0)
            return null;
        else
        {
            valid--;
            tmp = cards[valid];
            cards[valid] = null;
            return tmp;
        }
    }
    
    //adds card to top in deck
    public boolean addTopCard( Card c)
    {
        if ( valid < cards.length)
        {
            cards[valid] = c;   // should this be cloned? //no
            valid++;
            return true;
        }
        return false;
    }
    
    //creates a full pack of cards
    private void createFullPackOfCards()
    {
        for( int i = 0; i < NOOFCARDSINFULLPACK; i++)
        {
            addTopCard( new Card(i));
        }
    }
    
    //shuffles the cards in the deck
    public void shuffle()
    {
        Card temp;
        int position;
        for ( int i = 0; i < valid; i++) 
        {      
            position = (int) (Math.random() * NOOFCARDSINFULLPACK);
            temp = cards[i];
            cards[i] = cards[position];
            cards[position] = temp; 
        }
    }
//    // For testOnly... remove from production version!
//    public void testOnlyPrint()
//    {
//        for ( int i =0; i < valid; i++)
//        {
//            System.out.println( cards[i] );
//        }
//    }
    
} // end class Cards
