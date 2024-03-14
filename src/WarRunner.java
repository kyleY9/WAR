import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class WarRunner{

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
            {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS =
            {"♠", "♥", "♦", "♣"};

    /**
     * The values of the cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES =
            {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};


    public static void main(String[] args)
    {
        //beginningDeck is the Deck we start with.  When we deal, it gets split into two
        //Decks for each player
        Deck beginningDeck = new Deck(RANKS,SUITS,POINT_VALUES);
        beginningDeck.shuffle();
        //System.out.println(beginningDeck);

        Deck playerDeck = new Deck();
        Deck computerDeck = new Deck();

        while (!(beginningDeck.isEmpty())) {
            playerDeck.addToTop(beginningDeck.deal());
            computerDeck.addToTop(beginningDeck.deal());
        }
        // bug fixing code
        //System.out.println("Computer Deck:");
        //System.out.println(computerDeck);
        //System.out.println("Player Deck:");
        //System.out.println(playerDeck);

        String quit = "n";
        int numPlays = 0;
        Deck fieldCards = new Deck();
        Scanner scan = new Scanner(System.in);
        while (!(quit.equals("y"))) {
            Card computerCard = computerDeck.deal();
            System.out.println("The bot has played a " + computerCard);
            fieldCards.addToTop(computerCard);
            System.out.println("Press the enter button to play a card");
            scan.nextLine();
            Card playerCard = playerDeck.deal();
            System.out.println("You played " + playerCard);
            fieldCards.addToTop(playerCard);
            numPlays++;

            // comparison time
            if (computerCard.pointValue() > playerCard.pointValue())
            {
                System.out.println("The bot wins! " + computerCard.rank() + " beats " + playerCard.rank());
                while (!(fieldCards.isEmpty())) {
                    computerDeck.addToBottom(fieldCards.deal());
                }
                System.out.println("You currently have " + playerDeck.size() + " cards while the bot has " + computerDeck.size());
            }
            else if (playerCard.pointValue() > computerCard.pointValue())
            {
                System.out.println("You win! " + playerCard.rank() + " beats " + computerCard.rank());
                while (!(fieldCards.isEmpty())) {
                    playerDeck.addToBottom(fieldCards.deal());
                }
                System.out.println("You currently have " + playerDeck.size() + " cards while the bot has " + computerDeck.size());
            }
            else // WAR!!! Both people place down 3 cards (occurs during a tie)
            {
                for (int i = 0; i < 3; i++) {
                    fieldCards.addToTop(computerDeck.deal());
                    fieldCards.addToTop(playerDeck.deal());
                    System.out.println(fieldCards);
                }
                System.out.println("WAR!!! Whoever wins next will take home 10 cards!");
            }
            if (numPlays % 20 == 0)
            {
                System.out.println("You have played " + numPlays + " times");
                System.out.println("Do you want to quit? (y/n)");
                quit = scan.nextLine();
            }
        }
        System.out.println("The game is now over, let's compare ... ");
        if (playerDeck.size() > computerDeck.size()) {
            System.out.println("You win! You had " + playerDeck.size() + " cards while the bot had " + computerDeck.size() + " cards!");
        } else if (computerDeck.size() > playerDeck.size()) {
            System.out.println("You lose! You had " + playerDeck.size() + " cards while the bot had " + computerDeck.size() + " cards");
        } else {
            System.out.println("What the heck? A tie? Wow, nice, I guess . . . ?");
        }
    }
}
