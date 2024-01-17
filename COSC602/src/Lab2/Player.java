

package Lab2;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

/**
 *  Purpose: Abstract player class.  This class implements all the functionality that
 *  is common between the human and computer players. 
 *
 * @author CST100
 * @version 1.0
 */

public abstract class Player
{
    protected Vector<Card> cards;
    protected String name;
    
    /**
     * 
     * Constructor for the Player class.
     * @param name      Name of the player
     */
    public Player( String name)
    {
        this.name = name;
        cards = new Vector<Card>();
    }
    
    /**
     * 
     * Purpose: Add a card to the players hand
     * @param c     Card to be added.
     */
    public void addCard( Card c )
    {
        cards.add( c.clone() );
        Collections.sort( cards );
    }
    
    /**
     * 
     * Purpose:  Get the player's name
     * @return  player name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * 
     * Purpose:  This method counts the occurrences of each rank in the player's hand.   This method returns
     * a list of pairs which contain the rank and the number of times that rank occurred in the hand.
     * @return  a HashMap of each  rank that occurs in the hand and a count of the number times it occurred
     */
    protected HashMap<Character, Integer> countRankOccurrences()
    {
        HashMap<Character, Integer> cardCounts = new HashMap<Character, Integer>();
        
        for( Card c : cards )
        {
            if ( cardCounts.containsKey( c.getRank() ) )
            {
                Integer currCount =  cardCounts.get( c.getRank() );
                currCount++;
                
                cardCounts.put( c.getRank(), currCount );
            }
            else
            {
                cardCounts.put( c.getRank(), 1 );
            }
        }
        return cardCounts;
    }
    
    /**
     * 
     * Purpose: Determine if this player has a winning hand.
     * @return  true if the player's hand contains a pair and three of a kind, false otherwise
     */
    public boolean isWinner()
    {
        boolean winner = false;
        
        HashMap<Character, Integer> cardCounts = countRankOccurrences();
        
        if ( cardCounts.size() == 2 )
        {
            Collection<Integer> counts = (Collection<Integer>) cardCounts.values();
          
             Integer[] countArray = counts.toArray(  new Integer[2] );
            
            if ( countArray[0] == 2 && countArray[1] == 3 ||
                    countArray[0]== 3 && countArray[1] == 2 )
            {
                winner = true;
            }
        }
        
        return winner;
    }

    
    /**
     * 
     * Purpose:  Display the cards in the player's hand
     */
    public void displayHand()
    {
        System.out.println( "\n" + name + " has the following cards: " );
        
        for( Card c : cards )
        {
            System.out.println("\t" + c.cardWords() );
        }
        System.out.println();
    }
    
    /**
     * 
     * Purpose:  Take player's turn. 
     * @param deck          Current deck
     * @param discard       Current discard pile
     */
    public abstract void takeTurn( Deck deck, DiscardPile discard );
    
}
