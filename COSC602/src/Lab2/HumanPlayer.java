
package Lab2;

import java.util.Scanner;

/**
 *  Purpose: This class implements human player functionality.   The human player gets to select whether
 *  the top card on the discard pile is selected or a new card from the deck. The human player must also 
 *  select which card to remove. 
 *
 * @author CST100
 * @version 1.0
 */

public class HumanPlayer extends Player
{
    private Scanner input = new Scanner( System.in );
   
    /**
     * Constructor for the HumanPlayer class.
     * @param name      Human player's name
     */
    public HumanPlayer(String name)
    {
        super(name);
    }

    /* (non-Javadoc)
     * @see stackDemo.Player#takeTurn(stackDemo.Deck, stackDemo.DiscardPile)
     */
    /**
     * Purpose:  Take turn.  Display current cards to human player.  Then allow human to 
     * select card from discard or new card from deck.  
     * @param deck          Current deck
     * @param discard       Current discard pile
     */
    @Override
    public void takeTurn(Deck deck, DiscardPile discard)
    {
        displayHand();
        Card topOfDiscard = discard.viewTopCard();
        System.out.println("Take top card from discard: "  + topOfDiscard.cardWords() + 
                " or draw from deck? (t- top card, n - new card)");
        char choice = input.next().toLowerCase().charAt( 0 );
        while( choice != 'n' && choice != 't' )
        {
            System.out.println("Invalid choice.  Please enter t or n");
            choice = input.next().toLowerCase().charAt( 0 );
        }
        
        if ( choice == 't' )
        {
            addCard( discard.takeTopCard() );
        }
        else
        {
            addCard( deck.getNextCard() );
        }
        
        discard.putOnDiscard( removeCardFromHand() );
    }
    
    /**
     * 
     * Purpose:  Ask the human player to remove one of the cards from their hand.  All the cards
     * are displayed with a numeric index in front.  The human player selects the index of the card 
     * to be deleted. 
     * @return  Card that was removed from the hand.
     */
    private Card removeCardFromHand()
    {
        System.out.println("\n" + name + " please select a card to remove from hand" );
        
        int count = 1;
        for( Card c : cards )
        {
            System.out.println( "\t" + count++ + " " + c.cardWords() );
        }
        System.out.println("Please enter the number beside the card you wish to remove: ");
        
        int index = 0;
        boolean inputValid = false;
        while( !inputValid  )
        {
            if ( !input.hasNextInt() )
            {
                System.out.println("Please enter valid numeric value between 1 and " + count );
                input.nextLine();
            }
            else
            {
                index = input.nextInt();
                if ( index >= 1 && index <= count )
                {
                    inputValid = true;
                }
                else
                {
                    System.out.println("Value must be in the range between 1 and " + count );
                }
            }
        }
        
        index--; //account for zero based lists
        return cards.remove( index );

    }
    
    

}
