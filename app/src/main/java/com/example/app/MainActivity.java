package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        ImageView nazwa=(ImageView) findViewById(R.id.imageView5);
//        AlphaAnimation rot= new AlphaAnimation(0,100);
//        rot.setDuration(1000);
//        nazwa.startAnimation(rot);
    }
    int pkt=1;//ilosc za klikniecie
    int cenamoneyclick=10;
    private Handler handler = new Handler();
    int dodatek=0;//ilosc na sekunde
    double mnoznik=1;//dodatkowa procentowość klikniecia
    double wynik;

String blad="Nie masz wystarczająco punktów";
String akcept="Kupiłeś ulepszenie";



    public void pokazwynik(View view){//ekran pokazujacy pkt
        TextView textView=(TextView) findViewById(R.id.wyniki);

        String wyn=Double.toString(wynik);

        textView.setText(wyn);

    }


    public void addpointclick(View first) {//glowny przycisk kasa za pojedynczy klik

        Button button=(Button) findViewById(R.id.button7);
        button.setBackgroundColor(Color.TRANSPARENT);

        TextView textView=(TextView) findViewById(R.id.wyniki);

        String wyn=Double.toString(wynik);

        textView.setText(wyn);
        wynik+=(pkt*mnoznik);



    }
    public void moreMoneyClick(View view){//dodatkowe pkt za klikniecie

        if(wynik>cenamoneyclick){
            wynik-=cenamoneyclick;
            pkt++;
            cenamoneyclick*=2;
            Toast.makeText(this,akcept,Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,blad,Toast.LENGTH_LONG).show();
        }

        TextView textView=(TextView) findViewById(R.id.wyniki);

        String wyn=Double.toString(wynik);

        textView.setText(wyn);



    }
    public void moneyPerSec(View view){//pkt na sekunde
        int cenamoneypersec=20;
        if(wynik>cenamoneypersec){
            wynik-=cenamoneypersec;

        }else{

        }


    }
    public void boost(View view){//boost na 15 sekund, zwieksza 2 razy zarobek z klikniecia
        int cenaZaturbo=100;
        if(wynik>cenaZaturbo){
            wynik-=cenaZaturbo ;

        }else{

        }
        TextView textView=(TextView) findViewById(R.id.wyniki);

        String wyn=Double.toString(wynik);

        textView.setText(wyn);
    }




}