

package Lab2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

/**
 *  Purpose: Represents a comptuer player.  This class inherits all the player functionality and 
 *  then implements the "smarts" of the computer player. The computer plays by looking to see if it
 *  has any matches in its hand for the card on the top of the discard pile.  If no match then it takes
 *  a card from the deck.   When removing from its hand it first looks for rank that occurs 4 times, then for 
 *  one that occurs 1 time.   If neither of those cases are found it picks the first card in the hand. 
 * @author CST100
 * @version 1.0
 */

public class ComputerPlayer extends Player
{

    /**
     * Constructor for the ComputerPlayer class.
     * @param name      The computer player's name
     */
    public ComputerPlayer(String name)
    {
        super(name);
    }

    /* (non-Javadoc)
     * @see stackDemo.Player#takeTurn(stackDemo.Deck, stackDemo.DiscardPile)
     */
    /**
     * Purpose:  The computer takes their turn.   First decide if the card on the top of the discard 
     * pile is a good match - if it is then take it, otherwise take from the deck.   Call another
     * method to intelligently remove a card from the hand. 
     * @param deck          Current deck
     * @param discard       Current discard pile
     */
    @Override
    public void takeTurn(Deck deck, DiscardPile discard)
    {
        
        System.out.println("\n" + name + " is playing . . . \n");
;
        int discardCardCount = countRankOccurrences( discard.viewTopCard().getRank() );
        if ( discardCardCount == 1 || discardCardCount == 2 )
        {
            //pick up card on discard pile card
            addCard( discard.takeTopCard() );
        }
        else
        {
            //pick card from the deck
            addCard( deck.getNextCard() );
        }

        Card removed = removeCardFromHand();

        discard.putOnDiscard( removed );
    }

    /**
     * 
     * Purpose:  Intelligently remove a card from computer player's hand.  First look
     * for rank with 4 of a kind - remove one of these.   Next if no 4 of a kind is found 
     * then look for a rank with only 1.  If there is a rank with only 1 then remove it.  Otherwise, 
     * the only possibility is 2,2, 2(2 of each rank three times).  In this just remove any card. 
     * Note: There are no other possibilities at this point without having already won. 
     * @return
     */
    private Card removeCardFromHand()
    {
        HashMap<Character, Integer> cardCounts = countRankOccurrences();
        char rankToDelete = ' ';
        Set<Map.Entry< Character, Integer> > entrySet = cardCounts.entrySet();
        for( Map.Entry<Character, Integer> entry : entrySet )
        {
            //Preference given to 4 of one suit, otherwise take a single
            if ( entry.getValue() == 4 )
            {
                rankToDelete = entry.getKey();
            }
            else if ( entry.getValue() == 1 && rankToDelete == ' ' )
            {
                //Remove this card
                rankToDelete = entry.getKey();
            }      
        }
        
        if ( rankToDelete == ' ' )
        {
            //Not found - must have two pair, three times - just pick any card
            Iterator<Map.Entry<Character, Integer> > iter = (Iterator<Map.Entry<Character, Integer>>)entrySet.iterator();
            
           
            rankToDelete = iter.next().getKey();    
        }
        
        Iterator<Card> iter = cards.iterator();
        
        boolean removed = false;
        Card cardRemoved = null;
        
        while( !removed )
        {
            cardRemoved = iter.next();
            if ( cardRemoved.getRank() == rankToDelete )
            {
                iter.remove();
                removed = true;
            }
        }
        return cardRemoved;
    }
    
    /**
     * 
     * Purpose:  Count how often a specific rank occurs in the computer player's cards. 
     * @param rank          Rank to count.
     * @return  int value containing the number of times that rank occurred in the cards
     */
    private int countRankOccurrences( char rank )
    {
        int count = 0;
        for( Card c : cards )
        {
            if ( c.getRank() == rank )
            {
                count++;
            }
        }
        return count;
    }
}
