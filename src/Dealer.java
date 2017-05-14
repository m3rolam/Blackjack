
/**
 * A Dealer class that extends the player class for Blackjack. This allows the
 * dealer to protect his face down card during the beginning phases of blackjack.
 *
 * @author Michael Merola
 */
public class Dealer extends Player {

    /**
     * Overrides the getHand method in the Player class to allows the user to
     * print only the face up card during the beginning phases of blackjack
     *
     * @return the dealers top card as a string
     */
    @Override
    public String getHand() {
        StringBuilder h = new StringBuilder();
        for (int i = 1; i < hand.size(); i++) {
            h.append(hand.get(i));
        }
        return h.toString();
    }

    /**
     * Returns the dealers full hand, even his face down card.
     *
     * @return all the dealers cards
     */
    public String getFullHand() {
        StringBuilder h = new StringBuilder();
        for (Card aHand : hand) {
            h.append(aHand);
        }
        return h.toString();
    }
}
