
/**
 * A generic Card class.
 *
 * @author Michael Merola
 */
public class Card {

    private final int value;
    private final String suit;

    /**
     *
     * @param value The cards value ranging from 1-13. Where Ace = 1, King = 12,
     * Queen = 11, Jack = 10
     * @param suit the card suit. Spade, Club, Diamond, and Heart
     */
    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    /**
     * Overrides the toString method. Allowing the user to print out a card as a
     * string
     *
     * @return Card as a string
     */
    @Override
    public String toString() {
        if (value == 11) {
            return "(J," + suit + ")";
        } else if (value == 12) {
            return "(Q," + suit + ")";
        } else if (value == 13) {
            return "(K," + suit + ")";
        } else if (value == 1) {
            return "(A," + suit + ")";
        } else {
            return "(" + (value) + "," + suit + ")";
        }
    }

    /**
     * gets the suit of the card
     *
     * @return the cards suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * gets the value of the card
     *
     * @return the value of the card
     */
    public int getValue() {
        return value;
    }
}
