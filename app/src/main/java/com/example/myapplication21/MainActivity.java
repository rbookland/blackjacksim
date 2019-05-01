package com.example.myapplication21;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    //Hand player = new Hand(0, true);

    private LinkedList<Integer> playerCount = new LinkedList<>();
/**
    public void setPlayerCount(int setCount) {
        playerCount = setCount;
    }
    */
    public void addPlayerCount(int addCount) {
        playerCount.add(addCount);
    }

    public int getPlayerTotal() {
        int sum = 0;
        int numAces = 0;

        for (int toAdd : playerCount) {
            sum += toAdd;
            if (toAdd == 11) {
                numAces++;
            }
        }
        while (sum > 21 && numAces > 0) {
            sum-= 10;
            numAces--;
        }
        return sum;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Hit button. Changes TextView of card drawn
        Button hit = findViewById(R.id.hitButton);
        Button restart = findViewById(R.id.restartButton);
        Button stay = findViewById(R.id.stayButton);
        // Text display of card drawn.
        final TextView cardTextView = findViewById(R.id.CardToDisplay);
        final TextView playerS = findViewById(R.id.playerScore);
        final TextView deallerS = findViewById(R.id.deallerScore);
        //Immage View creates immage view
        final ImageView cardImageView = findViewById(R.id. firstCardView);
        final ImageView cardImageView1 = findViewById(R.id. secondCardView);
        final ImageView cardImageView2 = findViewById(R.id. thirdCardView);
        final Deck deckToUse = new Deck();


        // final Hand player = new Hand(0, true);
        //final Hand dealer = new Hand(0, true);
        deckToUse.shuffle();



        hit.setOnClickListener(new View.OnClickListener() {

            public void onClick(final View v) {
                if (cardImageView.getVisibility() == View.GONE) {
                    Card dealt = deckToUse.dealTopCard();
                    cardTextView.setText(dealt.toString());
                    cardImageView.setImageResource(dealt.getImageSource());
                    cardImageView.setVisibility(View.VISIBLE);
                    cardTextView.setVisibility(View.VISIBLE);
                    playerS.setVisibility(View.VISIBLE);
                    addPlayerCount(dealt.getBlackJackValue());
                    String score = ((Integer) getPlayerTotal()).toString();
                    playerS.setText(score);

                } else if (cardImageView1.getVisibility() == View.GONE) {
                    Card dealt = deckToUse.dealTopCard();
                    cardTextView.setText(dealt.toString());
                    cardImageView1.setImageResource(dealt.getImageSource());
                    cardImageView1.setVisibility(View.VISIBLE);
                    addPlayerCount(dealt.getBlackJackValue());
                    String score = ((Integer) getPlayerTotal()).toString();
                    playerS.setText(score);
                } else if (cardImageView2.getVisibility() == View.GONE){
                    Card dealt = deckToUse.dealTopCard();
                    cardTextView.setText(dealt.toString());
                    cardImageView2.setImageResource(dealt.getImageSource());
                    cardImageView2.setVisibility(View.VISIBLE);
                    addPlayerCount(dealt.getBlackJackValue());
                    String score = ((Integer) getPlayerTotal()).toString();
                    playerS.setText(score);
                }
                if (getPlayerTotal() > 21) {
                    Toast.makeText(getApplicationContext(),"Hey you Lost", Toast.LENGTH_SHORT).show();
                } else if (getPlayerTotal() == 21) {
                    Toast.makeText(getApplicationContext(),"Hey you Won", Toast.LENGTH_SHORT).show();
                }
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                cardImageView.setVisibility(View.GONE);
                cardImageView1.setVisibility(View.GONE);
                cardImageView2.setVisibility(View.GONE);
                cardTextView.setVisibility(View.GONE);
                deallerS.setVisibility(View.GONE);
                playerS.setVisibility(View.GONE);
                playerCount = new LinkedList<>();
                //Hand player = new Hand(0, true);
                //cardView.setText(deckToUse.dealTopCard().toString());
            }
        });

        stay.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                double random = Math.random();
                String dealerScrore = "";
                if (random <= 0.153225) {
                    dealerScrore = "17";
                } else if (random <= 0.29829) {
                    dealerScrore = "18";
                } else if (random <= 0.439947) {
                    dealerScrore = "19";
                } else if (random <= 0.624669) {
                    dealerScrore = "20";
                } else if (random <= 0.702033) {
                    dealerScrore = "21";
                } else if (random < 1) {
                    dealerScrore = "0";
                }
                deallerS.setText(dealerScrore);
                deallerS.setVisibility(View.VISIBLE);

                if (getPlayerTotal() > Integer.valueOf(dealerScrore) && getPlayerTotal() <= 21) {
                    Toast.makeText(getApplicationContext(),"Hey you Won", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Hey you Lost", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
