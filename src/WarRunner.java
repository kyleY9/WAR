import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class WarRunner{

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
            {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS =
            {"♠", "♥", "♦", "♣"};

    /**
     * The values of the cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES =
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};


    public static void main(String[] args)
    {
        //beginningDeck is the Deck we start with.  When we deal, it gets split into two
        //Decks for each player
        Deck beginningDeck = new Deck(RANKS,SUITS,POINT_VALUES);
        beginningDeck.shuffle();
        //System.out.println(beginningDeck);

    }
}
