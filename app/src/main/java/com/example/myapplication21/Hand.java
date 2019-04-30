package com.example.myapplication21;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/**
 * A class representing a hand.
 */
public class Hand {

    private LinkedList<Card> hand;
    private int bet;
    private int handTotal = 0;
    private boolean gameOver = false;
    boolean firstHand = false;

    public Hand(int toBet, boolean isFirstHand) {
        bet = toBet;
        firstHand = isFirstHand;
    }

    public void addCard(Card aCard) {
        hand.addLast(aCard);
        handTotal = getHandSum();
        if (handTotal > 21) {
            bet = 0;
        }
        gameOver = (handTotal >= 21);
    }

    /**
     * Get the sum of the cards in the player's hand
     *
     * @return the sum
     */
    public int getHandSum() {
        int handSum = 0;
        int numAces = 0;

        for (Card temp : hand) {
            handSum += temp.getBlackJackValue();
            if (temp.getBlackJackValue() == 11) {
                numAces++;
            }
        }
        while (handSum > 21 && numAces > 0) {
            handSum -= 10;
            numAces--;
        }
        return handSum;
    }

}
