package com.example.slotgame;

import android.location.Location;
import android.location.LocationListener;
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

    // GPS用
    static private android.location.LocationManager locationManager=null;
    static private LocationListener locationListener=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(null==locationListener) {
            locationManager = (android.location.LocationManager) getSystemService(android.content.Context.LOCATION_SERVICE);
            locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {

                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            };
        }
        //位置情報取得開始ボタン
        ((android.widget.Button) findViewById(R.id.locationButton_1))
                .setOnClickListener(new android.view.View.OnClickListener() {
                    public void onClick(android.view.View view) {
                        if(locationManager.isProviderEnabled(android.location.LocationManager.GPS_PROVIDER)){
                            //requestLocationUpdates(プロバイダー,通知の最小時間間隔(ms),通知の最小距離間隔(m),リスナー);
                            locationManager.requestLocationUpdates(android.location.LocationManager.GPS_PROVIDER,0,10,locationListener);
                        }
                    }
                });
        //位置情報取得停止ボタン
        ((android.widget.Button) findViewById(R.id.locationButton_2))
                .setOnClickListener(new android.view.View.OnClickListener() {
                    public void onClick(android.view.View view) {
                        locationManager.removeUpdates(locationListener);
                    }
                });


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

    class _LocationListener implements android.location.LocationListener {
        @Override
        public void onLocationChanged(android.location.Location location) {
            //位置情報を文字列に変換
            String str=location.getLatitude() + " " + location.getLongitude();
            android.widget.TextView t=(android.widget.TextView)findViewById(R.id.locationTextView);
            t.setText(str);
        }

        @Override
        public void onProviderDisabled(String provider) {}
        @Override
        public void onProviderEnabled(String provider) {}
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {}
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







