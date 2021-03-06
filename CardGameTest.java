import java.util.Scanner;
import cardgame.*;

// CardGameTest
// author:
// date:
public class CardGameTest
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        
        System.out.println( "Start of CardGameTest\n");
        
        // CONSTANTS
        
        // VARIABLES
        Card       c;
        Card       n;
        Card       f;
        Cards      cards;
        ScoreCard  scores;
        Player     p1;
        Player     p2;
        Player     p3;
        Player     p4;
        CardGame   game;
        
        // PROGRAM CODE
        
        // test Card class
        c = new Card( 2);
        n = new Card( 6);
        System.out.println( c);
        System.out.println( n);
        System.out.println();
        
        // test Cards class
        cards = new Cards( true);
        cards.addTopCard( c);
        cards.shuffle();
//        cards.testOnlyPrint();  // remove method after testing!
        
        // test ScoreCard class
        scores = new ScoreCard( 4);
        scores.update( 3, 1);
        scores.update( 1, 2);
        System.out.println( "\n" + scores );
        
        // test Player class
        p1 = new Player( "Nashiha");
        p2 = new Player( "Mason");
        p3 = new Player( "Hannah");
        p4 = new Player( "Shayan");
        System.out.println( p1.getName());
        p1.add(c);
        p1.add(n);
        f = p1.playCard();
        System.out.println( f.toString());
        
        // tests card game
        game = new CardGame( p1, p2, p3, p4);
        game.isGameOver();
        game.isTurnOf( p1);
        System.out.println( game.getScore( 4));
        System.out.println( game.getName( 2));
        System.out.println( game.getRoundNo());
        
        // Todo
        
        // Once you have all the bits working, complete the MyCardGame program
        // that provides a menu allowing any of the players to play their card,
        // an option to see the score card, and one to quit the game at any time.
        // When the game is over it should print out the winners.
        
        System.out.println( "\nEnd of CardGameTest\n" );
    }
    
} // end of class CardGameTest
