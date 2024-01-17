package Lab2;


/**
 *  Purpose: This class represents a single card.   It has a rank, two through
 *  ace, and a suit.  A Card is cloneable and comparable.  For comparison purposes
 *  cards are consider the same as long as the rank is the same, otherwise sorted from 
 *  two to ace.
 * @author CST100
 * @version 1.0
 */

public class Card implements Comparable<Card>, Cloneable
{
    private char suit;
    private char rank;
    
    /**
     * Four possible characters for suits
     */
    public static final String SUITS = "cdhs";

    /**
     * Each possible character value for rank, two through ace
     */
//    public static final String RANKS = "23456789tjqka";
    public static final String RANKS = "2345";

    /**
     * Suit in words.  Each element in this array  should be in 
     * corresponding position to match the single character
     * in SUITS constant. 
     */
    public static final String[] SUIT_NAMES = 
        { "Clubs", "Diamonds", "Hearts", "Spades" };
    
    /**
     * Rank in words.  Each element in this array should be in the 
     * corresponding position to match the single rank character in the 
     * RANKS constant. 
     */
    public static final String[] RANK_NAMES = 
        { "Two", "Three", "Four", "Five", "Six",
        "Seven", "Eight", "Nine", "Ten", "Jack",
        "Queen","King", "Ace" };
    
    /**
     * 
     * Constructor for the Card class.
     * @param suit
     * @param rank
     */
    public Card( char suit, char rank )
    {
        this.suit = suit;
        this.rank = rank;
    }


    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    /**
     * Purpose:  Compare two Card instances.   These are sorted by
     * rank only with two being lowest and ace highest. 
     * @param arg0
     * @return
     */
    @Override
    public int compareTo(Card other)
    {
        //Compare solely on rank - in order from two to ace
        
        return RANKS.indexOf( rank ) - RANKS.indexOf( other.rank );
        
    }
    
    /**
     * 
     * Purpose:  Create a clone of this object. 
     * @return
     */
    public Card clone()
    {
        Card copy = null;
        try
        {
            copy = (Card) super.clone();
        }
        catch( CloneNotSupportedException ex )
        {
            System.out.println("Clone Broke");
        }
        return copy;
    }
    
    /**
     * 
     * Purpose: Create a String with the card represented in words.  The
     * format should be of rank of suit.  For example: Two of Hearts.
     * @return String containing this card represented in words
     */
    public String cardWords()
    {
        StringBuffer sb = new StringBuffer();
        sb.append( RANK_NAMES[ RANKS.indexOf( rank ) ] );
        sb.append( " of " );
        sb.append( SUIT_NAMES[ SUITS.indexOf( suit ) ] );
        
        return  sb.toString();
    }
    
    /**
     * 
     * Purpose:  Get the rank of the card
     * @return rank as a character
     */
    public Character getRank()
    {
        return rank;
    }

}
