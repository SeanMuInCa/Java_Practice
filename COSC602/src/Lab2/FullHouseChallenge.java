
package Lab2;

import java.util.Scanner;
import java.util.Vector;

/**
 *  Purpose: The class is the main entry point for the full house challenge game. 
 *  The game allows a human player and a computer player to play a round of full
 *  house challenge.
 *
 * @author CST100
 * @version 1.0
 */

public class FullHouseChallenge
{
    private Vector<Player> players;
    private Scanner input = new Scanner( System.in );
    private Deck deck;
    private DiscardPile discard;
    
    /**
     * 
     * Constructor for the FullHouseChallenge class.
     */
    public FullHouseChallenge()
    {
        System.out.println("\nWelcome CST Full House Challenge!");
        System.out.println("\n\n\tThe object of this game is get a full house.");
        System.out.println("\tIf you get a one pair and three of kind in your hand you win!");
        System.out.println("\tYou must always have five cards in your hand at the end of your turn.");
        System.out.println("\tOn each turn you can take the top card off the discard pile or");
        System.out.println("\t    take a card from the deck.");
        System.out.println("\tAfter adding a card you will be required to remove a card from your hand.");
        System.out.println("\tAll players get the same number of turns so more than one player winning is possible.");
        System.out.println("\tLet's play!\n");
        deck = new Deck();
        discard = new DiscardPile();
        //Just two human players for now
        players = new Vector<Player>();
        
        System.out.println("Enter your name: " );
        HumanPlayer hm = new HumanPlayer( input.nextLine() );

        ComputerPlayer cp = new ComputerPlayer("Big Brain");
        players.add(  hm );
        players.add( cp );
        
        //Add one card to discard pile
        discard.putOnDiscard( deck.getNextCard() );
        playGame();
    }
    
    /**
     * 
     * Purpose:  Goes through all the players to determine if any player has won yet.  It
     * is possible for more than one player to win since all players get the same number
     * of turns.   This method displays a message for all players that win.
     * @return  true if any player has won, false otherwise
     */
    public boolean isThereAWinner()
    {
        boolean result = false;
        /*for( Player p : players )
        {
            if ( p.isWinner() )
            {
                result = true;
                System.out.println("Congratulations! " + p.getName() + " you win!!!!");
            }
        }*/
        return result;
    }
    
    /**
     * 
     * Purpose:  Takes care of controlling the play of the game.  Deal 5 cards to each player
     * initially.  Then players take turns until we have a winner. 
     */
    public void playGame()
    {
        //Deal 5 cards to each player
        for( int i = 0; i< 5; i++ )
        {
            for( Player p : players )
            {
                p.addCard( deck.getNextCard() );
            }
        }
        while( !isThereAWinner() )
        {
            for( Player p : players )
            {
                p.takeTurn(deck, discard );
                if ( deck.isEmpty() )
                {
                    discard.moveToDeck( deck );
                }
            }
        }
        
        
    }
    

    /**
     * Purpose:  Main entry point.   Command line arguments ignored. 
     * @param args      Command line arguments
     */
    public static void main(String[] args)
    {
        new FullHouseChallenge();

    }

}
