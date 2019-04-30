package com.example.myapplication21;

/**
 * Class used to define a deck cards. Normally an iteration of 52 standard cards.
 * It's possible to intentionally remove certain cards to study the Effect of Removal.
 * This enables the study of a certain card's relative value anf the implementation of
 * counting systems.
 */
public class Deck {

    /** an Array of cards representing the deck. Normally 52 cards. */
    private Card[] deck;

    /** Number of cards dealt from the top of the deck */
    private int discardTray;

    /** Default constructor. Creates a standard unshuffled 52 card deck */
    public Deck() {
        deck = new Card[52];
        int created = 0;    //Counter for num cards thus far
        for (int suit = 0; suit < 4; suit++) {
            for (int faceValue = 1; faceValue < 14; faceValue++) {
                deck[created] = new Card(suit, faceValue);
                created++;
            }
        }
        discardTray = 0;
    }

    /**
     * Constructor that enables the creation of an unshuffled deck comprised of multiple decks,
     * also known as a shoe. This constructor also allows the removal of specific faceValues, such
     * as removing all aces or sevens from the deck.
     *
     * @param numDecks The number of decks to be played. Must be positive whole int.
     * @param toExclude the coded faceValue to be excluded. See card class to find code key.
     *                  input > 13 or input <= 0 means no removal.
     */
    public Deck(int numDecks, int toExclude) {
        if (toExclude > 13 || toExclude <= 0) {
            deck = new Card[52 * numDecks];
        } else {
            deck = new Card[48 * numDecks];
        }
        int created = 0;
        for (int i = 0; i < numDecks; i++) {
            for (int suit = 0; suit < 4; suit++) {
                for (int faceValue = 1; faceValue < 14; faceValue++) {
                    if (faceValue == toExclude) {
                        continue;
                    }
                    deck[created] = new Card(suit, faceValue);
                    created++;
                }
            }
        }
        discardTray = 0;
    }


    /** Places all from the discard tray back into the shoe && shuffle. */
    public void shuffle() {
        //iterates over entire deck. Ensuring every card has the opportunity to move.
        for (int i = 0; i < deck.length; i++) {
            int random = (int) (Math.random() * deck.length);
            Card tmp = deck[i];
            deck[i] = deck[random];
            deck[random] = tmp;
        }
        discardTray = 0;
    }

    /** Returns the number of cards remaining to be dealt. */
    public int undealtCards() {
        return deck.length - discardTray;
    }

    /** Deals the top card and returns it. Shuffles the deck if necessary. */
    public Card dealTopCard() {
        if (discardTray == deck.length) {
            shuffle();
            discardTray = 0;
        }
        discardTray++;
        return deck[discardTray - 1];
    }
}
