package com.example.myapplication21;

/**
 * A class used to define the attributes of 52 cards.
 */
public class Card {
    /** Integer coded to suit.
     * 0 = Clubs
     * 1 = Diamonds
     * 2 = Hearts
     * 3 = Spades
     */
    private int suit = -1;

    /**
     * Int coded to "Face-value"
     * Ace = 1
     * Num = num
     * J = 11
     * Q = 12
     * K = 13
     */
    private int faceValue = -1;

    /**
     * Value in terms of 21.
     * A = 11 || 1. Need to implement optimal for player.
     * num = num
     * J-K =10
     */
    private int BlackJackValue = -1;

    /** Constructor for cards. First arg: coded suit. 2nd arg: coded FaceValue. */
    public Card(int setSuit, int setFaceValue) {
        if (setSuit > -1 && setSuit < 4 && setFaceValue > 0 && setFaceValue < 14) {
            suit = setSuit;
            faceValue = setFaceValue;
            if (setFaceValue == 1) {
                BlackJackValue = 11;
            } else if (setFaceValue > 9) {
                BlackJackValue = 10;
            } else {
                BlackJackValue = setFaceValue;
            }
        }
    }

    /** Getter for suit (as int). */
    public int getSuit() {
        return suit;
    }

    /** Getter for faceValue (as int). */
    public int getFaceValue() {
        return faceValue;
    }

    /** Getter for BlackJackValue. */
    public int getBlackJackValue() {
        return BlackJackValue;
    }

    /** Getter for suit as String */
    public String getSuitAsString() {
        switch ( suit ) {
            case 0: return "clubs";
            case 1: return "diamonds";
            case 2: return "hearts";
            case 3: return "spades";
            default: return "??";
        }
    }

    /** Getter for faceValue as String */
    public String getFaceValueAsString() {
        switch ( faceValue ) {
            case 1: return "Ace";
            case 2: return "2";
            case 3: return "3";
            case 4: return "4";
            case 5: return "5";
            case 6: return "6";
            case 7: return "7";
            case 8: return "8";
            case 9: return "9";
            case 10: return "10";
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
            default: return "??";
        }
    }

    public int getImageSource() {
        switch ( suit ) {
            case 0: return clubsImgSrc();
            case 1: return diamondsImgSrc();
            case 2: return heartsImgSrc();
            case 3: return spadesImgSrc();
            default: return 0;
        }
    }

    private int clubsImgSrc() {
        switch ( faceValue ) {
            case 1: return R.drawable.clubs_ace;
            case 2: return R.drawable.clubs_2;
            case 3: return R.drawable.clubs_3;
            case 4: return R.drawable.clubs_4;
            case 5: return R.drawable.clubs_5;
            case 6: return R.drawable.clubs_6;
            case 7: return R.drawable.clubs_7;
            case 8: return R.drawable.clubs_8;
            case 9: return R.drawable.clubs_9;
            case 10: return R.drawable.clubs_10;
            case 11: return R.drawable.clubs_jack;
            case 12: return R.drawable.clubs_queen;
            case 13: return R.drawable.clubs_king;
            default: return 0;
        }
    }

    private int diamondsImgSrc() {
        switch ( faceValue ) {
            case 1: return R.drawable.diamonds_ace;
            case 2: return R.drawable.diamonds_2;
            case 3: return R.drawable.diamonds_3;
            case 4: return R.drawable.diamonds_4;
            case 5: return R.drawable.diamonds_5;
            case 6: return R.drawable.diamonds_6;
            case 7: return R.drawable.diamonds_7;
            case 8: return R.drawable.diamonds_8;
            case 9: return R.drawable.diamonds_9;
            case 10: return R.drawable.diamonds_10;
            case 11: return R.drawable.diamonds_jack;
            case 12: return R.drawable.diamonds_queen;
            case 13: return R.drawable.diamonds_king;
            default: return 0;
        }
    }

    private int heartsImgSrc() {
        switch ( faceValue ) {
            case 1: return R.drawable.hearts_ace;
            case 2: return R.drawable.hearts_2;
            case 3: return R.drawable.hearts_3;
            case 4: return R.drawable.hearts_4;
            case 5: return R.drawable.hearts_5;
            case 6: return R.drawable.hearts_6;
            case 7: return R.drawable.hearts_7;
            case 8: return R.drawable.hearts_8;
            case 9: return R.drawable.hearts_9;
            case 10: return R.drawable.hearts_10;
            case 11: return R.drawable.hearts_jack;
            case 12: return R.drawable.hearts_queen;
            case 13: return R.drawable.hearts_king;
            default: return 0;
        }
    }

    private int spadesImgSrc() {
        switch ( faceValue ) {
            case 1: return R.drawable.spades_ace;
            case 2: return R.drawable.spades_2;
            case 3: return R.drawable.spades_3;
            case 4: return R.drawable.spades_4;
            case 5: return R.drawable.spades_5;
            case 6: return R.drawable.spades_6;
            case 7: return R.drawable.spades_7;
            case 8: return R.drawable.spades_8;
            case 9: return R.drawable.spades_9;
            case 10: return R.drawable.spades_10;
            case 11: return R.drawable.spades_jack;
            case 12: return R.drawable.spades_queen;
            case 13: return R.drawable.spades_king;
            default: return 0;
        }
    }

    /** Return a String representation of a card... i.e. "Ace of Spades" or "2 of Hearts" */
    public String toString() {
        return getFaceValueAsString() + " of " + getSuitAsString();
    }
}


