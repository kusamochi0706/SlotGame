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
        final Button retryButton = (Button) this.findViewById(R.id.retrybutton);
        retryButton.setVisibility(View.INVISIBLE);

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
                if(droidSide1 == droidSide2 && droidSide1 == droidSide3) {
                    Toast t = Toast.makeText(getApplicationContext(), "おめでとう！", Toast.LENGTH_SHORT);
                    t.show();
                    retryButton.setVisibility(View.VISIBLE);
                }else if(droidSide1 != -1 && droidSide2 != -1 && droidSide3 != -1){
                    retryButton.setVisibility(View.VISIBLE);
                }

                v.setEnabled(false);
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
                if(droidSide1 == droidSide2 && droidSide1 == droidSide3) {
                    Toast t = Toast.makeText(getApplicationContext(), "おめでとう！", Toast.LENGTH_SHORT);
                    t.show();
                    retryButton.setVisibility(View.VISIBLE);
                }else if(droidSide1 != -1 && droidSide2 != -1 && droidSide3 != -1){
                    retryButton.setVisibility(View.VISIBLE);
                }

                v.setEnabled(false);
            }

        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                droidSide3 = r.nextInt(3);
                if(droidSide3 == 0){
                    droidImage3.setImageResource(R.drawable.chuka);
                }else if(droidSide3 == 1){
                    droidImage3.setImageResource(R.drawable.pakutii);
                }else if(droidSide3 == 2){
                    droidImage3.setImageResource(R.drawable.itarian);
                }
                if(droidSide1 == droidSide2 && droidSide1 == droidSide3) {
                    Toast t = Toast.makeText(getApplicationContext(), "おめでとう！", Toast.LENGTH_SHORT);
                    t.show();
                    retryButton.setVisibility(View.VISIBLE);
                }else if(droidSide1 != -1 && droidSide2 != -1 && droidSide3 != -1){
                    retryButton.setVisibility(View.VISIBLE);
                }

                v.setEnabled(false);
            }

        });
        retryButton.setOnClickListener(new View.OnClickListener(){
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
}
