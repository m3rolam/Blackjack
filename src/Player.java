import java.util.ArrayList;

/**
 * A Player class for Blackjack.
 *
 * @author Michael Merola
 */
class Player {

    final ArrayList<Card> hand;
    private boolean ace;

    public Player() {
        hand = new ArrayList<>();
        ace = false;
    }

    /**
     * Takes a provided card and adds it to the players hand.
     *
     * @param c a Card to be added to the players hand.
     */
    public void takeCard(Card c) {
        if (c.getValue() == 1) {
            ace = true;
            hand.add(c);
        } else {
            hand.add(c);
        }
    }

    /**
     * Checks if the player has blackjack
     *
     * @return true if the player has and ace and a 10 or higher.
     */
    public boolean hasBlackjack() {
        return ace && (hand.get(0).getValue() >= 10 || hand.get(1).getValue() >= 10);
    }

    /**
     * Checks if the player busted.
     *
     * @return true if the players hand value is greater then 21.
     */
    public boolean hasBust() {
        int total = 0;
        for (Card aHand : hand) {
            if (aHand.getValue() < 11) {
                total += aHand.getValue();
            } else {
                total += 10;
            }
            if (total > 21) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for the players greatest hand value taking in account for Aces. It
     * will return the greatest value less then 21.
     *
     * @return the players greatest hand value.
     */
    public int getHandValue() {
        int total = 0;
        for (Card aHand : hand) {
            if (aHand.getValue() < 11) {
                total += aHand.getValue();
            } else {
                total += 10;
            }
        }
        if (ace) {
            if (!(total + 10 > 21)) {
                return total + 10;
            }
        }
        return total;
    }

    /**
     * Gets the players cards in their hand.
     *
     * @return the plays cards as a string.
     */
    public String getHand() {
        StringBuilder h = new StringBuilder();
        for (Card aHand : hand) {
            h.append(aHand);
        }
        return h.toString();
    }
}
