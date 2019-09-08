package com.example.slotgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int slotnum1 = -1;
    int slotnum2 = -1;
    int slotnum3 = -1;
    Button retryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView slotImage1 = (ImageView) this.findViewById(R.id.slotimageid1);
        final ImageView slotImage2 = (ImageView) this.findViewById(R.id.slotimageid2);
        final ImageView slotImage3 = (ImageView) this.findViewById(R.id.slotimageid3);

        final Button b1 = (Button) this.findViewById(R.id.slotbutton1);
        final Button b2 = (Button) this.findViewById(R.id.slotbutton2);
        final Button b3 = (Button) this.findViewById(R.id.slotbutton3);

        retryButton = (Button) this.findViewById(R.id.retrybutton);

        retryButton.setVisibility(View.INVISIBLE);

        final Random r = new Random();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                slotnum1 = r.nextInt(3);
                slotImage1.setImageResource(getDrawableId(slotnum1));
                checkSlot();
                b1.setEnabled(false);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                slotnum2 = r.nextInt(3);
                slotImage2.setImageResource(getDrawableId(slotnum2));
                checkSlot();
                b2.setEnabled(false);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                slotnum3 = r.nextInt(3);
                slotImage3.setImageResource(getDrawableId(slotnum3));
                checkSlot();
                b3.setEnabled(false);
            }
        });
        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slotImage1.setImageResource(R.drawable.start1);
                slotImage2.setImageResource(R.drawable.start1);
                slotImage3.setImageResource(R.drawable.start1);
                b1.setEnabled(true);
                b2.setEnabled(true);
                b3.setEnabled(true);
                retryButton.setVisibility(View.INVISIBLE);
                slotnum1 = slotnum2 = slotnum3 = -1;
            }
        });
    }

    private int getDrawableId(int num) {
        int drawableId = -2;
        if (num == 0) {
            drawableId = R.drawable.chuka;
        } else if (num == 1) {
            drawableId = R.drawable.pakutii;
        } else if (num == 2) {
            drawableId = R.drawable.itarian;
        }
        return drawableId;
    }

    private void checkSlot() {
        if (slotnum1 == slotnum2 && slotnum1 == slotnum3) {
            Toast t = Toast.makeText(getApplicationContext(), "おめでとう！", Toast.LENGTH_SHORT);
            t.show();
            retryButton.setVisibility(View.VISIBLE);
        } else if (slotnum1 != -1 && slotnum2 != -1 && slotnum3 != -1) {
            retryButton.setVisibility(View.VISIBLE);
        }
    }
}







