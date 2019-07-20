package com.example.slotgame;

import android.inputmethodservice.KeyboardView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int droidSide1 = -1;
    int droidSide2 = -1;
    int droidSide3 = -1;
    Button retryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView droidImage1 = (ImageView) this.findViewById(R.id.droidimageid1);
        final ImageView droidImage2 = (ImageView) this.findViewById(R.id.droidimageid2);
        final ImageView droidImage3 = (ImageView) this.findViewById(R.id.droidimageid3);
        final Random r = new Random();
        final Button b1 = (Button) this.findViewById(R.id.slotbutton1);
        final Button b2 = (Button) this.findViewById(R.id.slotbutton2);
        final Button b3 = (Button) this.findViewById(R.id.slotbutton3);
        retryButton = (Button) this.findViewById(R.id.retrybutton);
        retryButton.setVisibility(View.INVISIBLE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                droidSide1 = r.nextInt(3);
                droidImage1.setImageResource(getDrawableId(droidSide1));
                checkSlot();
                b1.setEnabled(false);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                droidSide2 = r.nextInt(3);
                droidImage2.setImageResource(getDrawableId(droidSide2));
                checkSlot();
                b2.setEnabled(false);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                droidSide3 = r.nextInt(3);
                droidImage3.setImageResource(getDrawableId(droidSide3));
                checkSlot();
                b3.setEnabled(false);
            }
        });
        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                droidImage1.setImageResource(R.drawable.start1);
                droidImage2.setImageResource(R.drawable.start1);
                droidImage3.setImageResource(R.drawable.start1);
                b1.setEnabled(true);
                b2.setEnabled(true);
                b3.setEnabled(true);
                retryButton.setVisibility(View.INVISIBLE);
                droidSide1 = droidSide2 = droidSide3 = -1;
            }
        });
    }

    private int getDrawableId(int side) {
        int drawableId = -2;
        if (side == 0) {
            drawableId = R.drawable.chuka;
        } else if (side == 1) {
            drawableId = R.drawable.pakutii;
        } else if (side == 2) {
            drawableId = R.drawable.itarian;
        }
        return drawableId;
    }

    private void checkSlot() {
        if (droidSide1 == droidSide2 && droidSide1 == droidSide3) {
            Toast t = Toast.makeText(getApplicationContext(), "おめでとう！", Toast.LENGTH_SHORT);
            t.show();
            retryButton.setVisibility(View.VISIBLE);
        } else if (droidSide1 != -1 && droidSide2 != -1 && droidSide3 != -1) {
            retryButton.setVisibility(View.VISIBLE);
        }
    }
}







