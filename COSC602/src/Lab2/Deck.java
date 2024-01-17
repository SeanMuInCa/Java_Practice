package Lab2;
import java.util.Collections;
import java.util.Stack;


/**
 *  Purpose: This class represents a stack of standard playing cards.  When an instance is created
 *  of this class it creates a standard deck of 52 cards. 
 *
 * @author CST100
 * @version 1.0
 */

public class Deck
{
    private Stack<Card> cards;
    
    /**
     * 
     * Constructor for the Deck class.
     */
    public Deck()
    {
        //Create deck
        cards = new Stack<Card>();
        
        for( int i = 0; i < Card.SUITS.length(); i++ )
        {

            for( int j = 0; j < Card.RANKS.length(); j++ )
            {
                Card c = new Card( Card.SUITS.charAt( i ), Card.RANKS.charAt( j ) );
                cards.add( c );
            }
        }
        
        Collections.shuffle( cards );
    }
    
    /**
     * 
     * Purpose:  Check if the deck is currently empty
     * @return true if deck is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return cards.isEmpty();
    }
    
    /**
     * 
     * Purpose:Add the list of cards specified to this deck. 
     * @param cardList          Array of Card instances to be added to the deck.
     */
    public void addAll( Card[] cardList )
    {
        for( Card c : cardList )
        {
            cards.add( c );
        }
        
        Collections.shuffle( cards );
    }
    /**
     * 
     * Purpose:  Take top card off the top of the deck.
     * @return Card instance that was on the top of the deck. 
     */
    public Card getNextCard()
    {
        return cards.pop();
    }
    

}
