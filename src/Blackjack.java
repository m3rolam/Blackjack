
/*
 * A simple Blackjack class that creates a new instance of blackjack and plays a
 * single game.

 *@author Michael Merola
 */

import java.util.Scanner;

class Blackjack {

    private Deck deck;
    private Player player;
    private Dealer dealer;

    /**
     * Default constructor
     */
    public Blackjack() {
        deck = new Deck();
        deck.shuffleDeck();
        player = new Player();
        dealer = new Dealer();
    }

    /**
     * Plays an instance of BlackJack
     */
    public void playBlackjack() {
        Scanner in = new Scanner(System.in);
        String input; //Stores users input
        boolean firstGame = true;
        System.out.println("Welcome to Blackjack!");
        System.out.print("Would you like to play Blackjack?(yes or no):");
        input = in.nextLine();
        while (!input.toLowerCase().equals("yes")) {//Prevents user from entering anything other then yes or no
            if (input.toLowerCase().equals("no")) {
                break;
            }
            System.out.print("Please enter yes or no:");
            input = in.nextLine();
        }
        if (input.toLowerCase().equals("no")) {
            System.out.println("Maybe Next Time!");
            return;
        }
        System.out.print("Do you want to know the rules?(yes or no):");
        input = in.nextLine();
        while (!input.toLowerCase().equals("yes")) {//Prevents user from entering anything other then yes or no
            if (input.toLowerCase().equals("no")) {
                break;
            }
            System.out.print("Please enter yes or no:");
            input = in.nextLine();
        }
        if (input.equals("yes")) {
            System.out.println("You are playing against the dealer!");
            System.out.println("You and the dealer are dealt two cards at the start of the game.");
            System.out.println("The goal is to get a total card value of 21 or closer to 21 then the dealer.");
            System.out.println("All cards count as their face value, except A which can be 1 or 11 and J, Q, K all count as 10.");
            System.out.println("If you get 21 on the first two cards dealt, you hit Blackjack.");
            System.out.println("If you don't, you will then be able to 'hit' or 'stand'.");
            System.out.println("Hitting will give you another random card while standing will end your turn.");
            System.out.println("If you or the dealer get over 21 you will bust and the other player will win!");
            System.out.println("Have fun and good luck!");
        }

        while (true) {
            if (!firstGame) {
                System.out.print("Would you like to play another game?(yes or no)");
                input = in.nextLine();
                while (!input.toLowerCase().equals("yes")) {//Prevents user from entering anything other then yes or no
                    if (input.toLowerCase().equals("no")) {
                        System.out.println("Thanks for playing!");
                        return;
                    }
                    System.out.print("Please enter yes or no:");
                    input = in.nextLine();
                }
                deck = new Deck();
                deck.shuffleDeck();
                player = new Player();
                dealer = new Dealer();
            }
            firstGame = false;
            System.out.println();
            System.out.println("THE GAME HAS STARTED!");
            System.out.println("Dealing cards....");
            player.takeCard(deck.drawCard());
            System.out.println("Your first card: " + player.getHand() + " Total value: " + player.getHandValue());
            dealer.takeCard(deck.drawCard());
            System.out.println("The dealer's first card is face down!");
            player.takeCard(deck.drawCard());
            System.out.println("Your cards: " + player.getHand() + " Total value: " + player.getHandValue());
            dealer.takeCard(deck.drawCard());
            System.out.println("The dealer's face up card is: " + dealer.getHand());

            if (dealer.hasBlackjack() && player.hasBlackjack()) {
                System.out.println("YOU BOTH HAVE BLACKJACK!!! It's a Tie! Game over!");
                continue;
            } else if (dealer.hasBlackjack()) {
                System.out.println("The Dealer has blackjack! Game over!");
                continue;
            } else if (player.hasBlackjack()) {
                System.out.println("You have blackjack! YOU WIN!!! Game over!");
                continue;
            }

            System.out.print("Your turn, would you like to hit or stand?");
            input = in.nextLine();
            while (!input.toLowerCase().equals("hit")) {//Prevents user from entering anything other then hit or stand
                if (input.toLowerCase().equals("stand")) {
                    break;
                }
                System.out.print("Please enter hit or stand:");
                input = in.nextLine();
            }
            while (input.toLowerCase().equals("hit")) {
                player.takeCard(deck.drawCard());
                System.out.println("Your cards: " + player.getHand() + " Total value :" + player.getHandValue());
                if (!player.hasBust()) {
                    System.out.print("Your turn, would you like to hit or stand?");
                    input = in.nextLine();
                    while (!input.toLowerCase().equals("hit")) {//Prevents user from entering anything other then hit or stand
                        if (input.toLowerCase().equals("stand")) {
                            break;
                        }
                        System.out.print("Please enter hit or stand:");
                        input = in.nextLine();
                    }
                } else {
                    System.out.println("BUST!Game Over! You lose! =(");
                    break;
                }
            }
            if (player.hasBust()) {
                continue;
            }

            System.out.println();
            System.out.println("Dealers Turn!");
            System.out.println("The dealer flips over his face down card!");
            System.out.println("The dealer's cards are: " + dealer.getFullHand());
            while (dealer.getHandValue() < 17) {
                System.out.println("The dealer Hits!");
                dealer.takeCard(deck.drawCard());
                System.out.println("Dealer's cards: " + dealer.getFullHand() + " Total value: " + dealer.getHandValue());
            }
            if (dealer.hasBust()) {
                System.out.println("THE DEALER BUSTED! YOU WIN!");
            } else if (dealer.getHandValue() < player.getHandValue()) {
                System.out.println("Your hand value was greater than the dealers! YOU WIN!");
            } else if (dealer.getHandValue() > player.getHandValue()) {
                System.out.println("The dealer's hand value was greater than yours! YOU LOSE!!!");
            } else {
                System.out.println("IT'S A TIE!!!");
            }
        }
    }

}
