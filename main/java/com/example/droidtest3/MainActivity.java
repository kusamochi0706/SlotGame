package com.example.droidtest3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

// MsinActivity クラス
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView droidImage1 = (ImageView) this.findViewById(R.id.droidimageid1);
        final Random r = new Random();
        final Button b1 = (Button) this.findViewById(R.id.slotbutton1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int droidSide1;
                droidSide1 = r.nextInt(3);
                if(droidSide1 == 0){
                    droidImage1.setImageResource(R.drawable.chuka);
                }else if(droidSide1 == 1){
                    droidImage1.setImageResource(R.drawable.pakutii);
                }else if(droidSide1 == 2){
                    droidImage1.setImageResource(R.drawable.itarian);
                }
                v.setEnabled(true);
            }

        });

    }
}
