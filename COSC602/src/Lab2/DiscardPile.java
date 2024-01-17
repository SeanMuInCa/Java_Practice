package Lab2;
import java.util.Stack;

import java.util.Iterator;

/**
 *  Purpose: This class maintains the discard pile.  Players are allowed to view the top
 *  card on the discard pile, take off the top card from the discard pile or add a card 
 *  to the discard pile.
 *
 * @author CST100
 * @version 1.0
 */

public class DiscardPile
{
    /**
     * Create an instance variable to hold the cards.  Use a Stack!
     */
    //TODO add instance variable
    private Stack<Card> cards;
    /**
     * 
     * Constructor for the DiscardPile class.
     * Instantiate the instance variable for the pile here. 
     */
    public DiscardPile()
    {
        //TODO instantiate instance variable
        cards = new Stack<>();
    }

    /**
     * 
     * Purpose: Given an deck instance take ALL cards BUT the top card on the discard pile and move to 
     * the deck.  This method will be used when the deck is empty and the cards in the discard pile need to
     * placed back in the deck. (But keeping the top card in the discard)
     * @param deck      The deck to add the cards to. 
     */
    public void moveToDeck( Deck deck )
    {
        //TODO
        /**
         * Remove top card from discard pile and save
         * Get all other cards from discard pile and put in an array.(Check out methods you can use!)
         * Add the array of cards to the deck
         * Clear the discard pile
         * Put the saved top card back in the discard pile
         */
        Card c= cards.pop();
        Card[] temp = new Card[cards.size()];
        Iterator<Card> it = cards.iterator();
        int index = 0;
        while (it.hasNext()){
            temp[index] = it.next();
            index++;
        }
        deck.addAll(temp);//i have another way for this. deck.addAll(cards.toArray(new Card[0])),but i saw
        cards.clear();    // the iterator is already import, so i changed it to iterator.
        cards.push(c);
    }

    /**
     * 
     * Purpose:  Get the top card from the discard pile. The card is removed from the discard pile.
     * Return a copy so that no privacy leak can occur. 
     * @return  Card  The card that was on the top of the discard pile.
     */
    public Card takeTopCard()
    {
        //TODO remove top card from discard pile and return a copy
        Card c = cards.pop().clone();
        return c;
    }

    /**
     * 
     * Purpose: Look at the top card on the discard pile but do not remove it.   Return a copy of 
     * the card so no privacy leak can occur.
     * @return  The card at the top of the discard pile. 
     */
    public Card viewTopCard()
    {
        //TODO Return a copy of the top card from discard pile - do  not remove from discard pile!
        Card c = cards.peek().clone();
        return c;
    }
    
    /**
     * 
     * Purpose:  Take the given card and add to the discard pile.  This card should now be on the TOP of the 
     * discard pile. Make sure to take a copy so no privacy leak can occur. 
     * @param c         Card to be added. 
     */

    public void putOnDiscard(Card c)
    {
        //TODO Take a copy of the provided card and add to the discard pile.   This card should now be 
        //on the top of the discard pile.
        Card copy_c = c.clone();
        cards.push(copy_c);
    }
}
