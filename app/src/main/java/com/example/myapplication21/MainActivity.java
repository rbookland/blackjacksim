package com.example.myapplication21;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    Hand player = new Hand(0, true);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Hit button. Changes TextView of card drawn
        Button hit = findViewById(R.id.hitButton);
        Button restart = findViewById(R.id.restartButton);
        // Text display of card drawn.
        final TextView cardTextView = findViewById(R.id.CardToDisplay);

        final ImageView cardImageView = findViewById(R.id. firstCardView);

        final Deck deckToUse = new Deck();
        LinkedList<Card> player;

        // final Hand player = new Hand(0, true);
        final Hand dealer = new Hand(0, true);
        deckToUse.shuffle();



        hit.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                Card dealt = deckToUse.dealTopCard();
                cardTextView.setText(dealt.toString());
                cardImageView.setImageResource(dealt.getImageSource());
            }
        });

//        restart.setOnClickListener(new View.OnClickListener() {
 //           public void onClick(final View v) {
   //             dealer = new Hand(0, true);

   //             player = new Hand(0, true);
        //        cardView.setText(deckToUse.dealTopCard().toString());
     //       }
     //   }
    }
}
