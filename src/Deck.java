import java.util.LinkedList;
import java.util.Random;

/**
 * A generic Deck class for card games.
 *
 * @author Michael Merola
 */
class Deck {

    private final LinkedList<Card> deck;
    private static final String SPADES = "Spade";
    private static final String CLUB = "Club";
    private static final String DIAMOND = "Diamond";
    private static final String HEART = "Heart";
    private static final int TOTAL_NUMBER_OF_CARDS = 52;
    private static final int FACE_VALUES = 13;

    /**
     * Default constructor. Creates a deck consisting of cards ranging from card
     * values of 1-13. Provides the following suits for each cards: Spade, Club,
     * Diamond, and Heart This creates a total of 52 cards.
     */

    public Deck() {
        deck = new LinkedList();
        for (int i = 1; i < FACE_VALUES + 1; i++) {
            deck.add(new Card(i, SPADES));
            deck.add(new Card(i, CLUB));
            deck.add(new Card(i, DIAMOND));
            deck.add(new Card(i, HEART));
        }
    }

    /**
     * Randomly shuffles all 52 cards in the deck
     */
    public void shuffleDeck() {
        for (int i = 0; i < TOTAL_NUMBER_OF_CARDS - 1; i++) {
            Random r = new Random();
            int x = r.nextInt(TOTAL_NUMBER_OF_CARDS);
            Card y = deck.get(x);
            deck.set(x, deck.get(i));
            deck.set(i, y);
        }
    }

    /**
     * Draws the top most card in the deck.
     *
     * @return a Card from the deck
     */
    public Card drawCard() {
        return deck.pop();
    }
}
