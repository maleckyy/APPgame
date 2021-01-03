package com.example.app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
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

import java.net.Inet4Address;
import java.text.DecimalFormat;
import java.util.concurrent.Delayed;

public class MainActivity extends AppCompatActivity {


    int pkt=1;//ilosc za klikniecie
    int cenamoneyclick=10;
    int cenamoneypersec=30;

    double mnoznik=1;//dodatkowa procentowość klikniecia
    double wynik;

    String blad="Nie masz wystarczająco punktów";
    String akcept="Kupiłeś ulepszenie";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.wyniki);

        String wyn = Double.toString(wynik);

        textView.setText(wyn);

        Button button1 = (Button) findViewById(R.id.button4);
        Button button2 = (Button) findViewById(R.id.button2);


        String cenamoneystart = Integer.toString(cenamoneyclick);
        String cenamoneystart1 = Integer.toString(cenamoneypersec);
        button1.setTextSize(12);
        button2.setTextSize(12);
        if (wynik < cenamoneyclick) {
            button1.setText("Dodatkowe punkty kliknięcia za " + cenamoneystart);
            button2.setText("Dodatkowe punkty kliknięcia za " + cenamoneystart1);


        }


    }

    public void addpointclick(View first) {//glowny przycisk kasa za pojedynczy klik

        Button button=(Button) findViewById(R.id.button7);
        button.setBackgroundColor(Color.TRANSPARENT);

        TextView textView=(TextView) findViewById(R.id.wyniki);

        DecimalFormat df = new DecimalFormat("###.#");
        String wyn=df.format(wynik);
        textView.setText(wyn);
        wynik+=(pkt*mnoznik);

    }
    public void moreMoneyClick(View view){//dodatkowe pkt za klikniecie

     Button button1=(Button) findViewById(R.id.button4);
       String cenamoneystring= Integer.toString(cenamoneyclick*2);
       button1.setTextSize(12);
        if(wynik<cenamoneyclick){
            button1.setText("Dodatkowe punkty kliknięcia za "+cenamoneyclick);

        }else{
            button1.setText("Dodatkowe punkty kliknięcia za "+ cenamoneystring);
        }


        if(wynik>cenamoneyclick){
            wynik-=cenamoneyclick;

            cenamoneyclick*=2;
            Toast.makeText(this,akcept,Toast.LENGTH_SHORT).show();
            pkt++;
        }else{
            Toast.makeText(this,blad,Toast.LENGTH_SHORT).show();
        }
        TextView textView=(TextView) findViewById(R.id.wyniki);
        DecimalFormat df = new DecimalFormat("###.#");
        String wyn=df.format(wynik);
        textView.setText(wyn);

    }
    public void moneyMnoznik(View view){//pkt na sekunde


        Button button2=(Button) findViewById(R.id.button2);


        String cenamoneystring1= Integer.toString(cenamoneypersec*2);
        button2.setTextSize(12);
        if(wynik<cenamoneyclick){
            button2.setText("Dodatkowe punkty kliknięcia za "+cenamoneypersec);

        }else{
            button2.setText("Dodatkowe punkty kliknięcia za "+ cenamoneystring1);
        }
        if(wynik>cenamoneypersec){
            wynik-=cenamoneypersec;
            cenamoneypersec*=2;

            Toast.makeText(this,akcept,Toast.LENGTH_SHORT).show();
            mnoznik+=0.2;


        }else{
            Toast.makeText(this,blad,Toast.LENGTH_SHORT).show();
        }
        TextView textView=(TextView) findViewById(R.id.wyniki);
        DecimalFormat df = new DecimalFormat("###.#");
        String wyn=df.format(wynik);
        textView.setText(wyn);

    }

}