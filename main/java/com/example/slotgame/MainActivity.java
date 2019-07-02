package com.example.slotgame;

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
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                droidSide1 = r.nextInt(3);
                if(droidSide1 == 0){
                    droidImage1.setImageResource(R.drawable.chuka);
                }else if(droidSide1 == 1){
                    droidImage1.setImageResource(R.drawable.pakutii);
                }else if(droidSide1 == 2){
                    droidImage1.setImageResource(R.drawable.itarian);
                }
                Toast t = Toast.makeText(getApplicationContext(),Integer.toString(droidSide1),Toast.LENGTH_SHORT);
                t.show();

                v.setEnabled(true);
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                droidSide2 = r.nextInt(3);
                if(droidSide2 == 0){
                    droidImage2.setImageResource(R.drawable.chuka);
                }else if(droidSide2 == 1){
                    droidImage2.setImageResource(R.drawable.pakutii);
                }else if(droidSide2 == 2){
                    droidImage2.setImageResource(R.drawable.itarian);
                }
                Toast t = Toast.makeText(getApplicationContext(),Integer.toString(droidSide2),Toast.LENGTH_SHORT);
                t.show();

                v.setEnabled(true);
            }

        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                droidSide3 = r.nextInt(3);
                if(droidSide3 == 0){
                    droidImage3.setImageResource(R.drawable.chuka);
                }else if(droidSide3 == 1){
                    droidImage2.setImageResource(R.drawable.pakutii);
                }else if(droidSide3 == 2){
                    droidImage3.setImageResource(R.drawable.itarian);
                }
                Toast t = Toast.makeText(getApplicationContext(),Integer.toString(droidSide3),Toast.LENGTH_SHORT);
                t.show();

                v.setEnabled(true);
            }

        });

    }
}
