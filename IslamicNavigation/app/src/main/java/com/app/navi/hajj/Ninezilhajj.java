package com.app.navi.hajj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.app.navi.R;

public class Ninezilhajj extends AppCompatActivity {

    Button prev, next;
    WebView view01,view02;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninezilhajj);

        view01 = (WebView) findViewById(R.id.text1);
        String mydata= "Everyone who intends to make Hajj and has not brought the sacrificial animal (Hady) with him [2] then he should intend to perform Hajj of Tamattu' [see the Glossary] - as the Prophet ordered his companions to do in the end, and as he became angry when some did not immediately carry out this order to change the intention from Hajj to an ‘Umrah and he said: “I have entered the `Umrah into the Hajj until the Day of Resurrection”, and when some of the Companions asked whether he had done that only for that year or forever, the Prophet joined his fingers together and said: “I have entered the ‘Umrah into the Hajj until the Day of Resurrection, not just for a time, rather forever. [3] And because of this he ordered Fatimah and also all his wives - may Allah be pleased with them all - to leave the state of Ihram after finishing the ‘Umrah, and therefore Ibn ‘Abbas used to say: Whomsoever makes tawaf of the House - then he has left Ihram - the Sunnah of your Prophet - even if you are averse to it. [4] So everyone who has not brought the sacrificial animal with him, should call out that he is going to make ‘Umrah - in the three months of Hajj, and he who has declared his intention to do Hajj Mufrid (Hajj on its own) or Hajj Qarin then hears of the Prophet to change it ‘Umrah - then he should quickly obey even after reaching Mecca and Sa'i between Safa and Marwah - then he should leave the state of Ihram - then declare the intention for Hajj on the Day of Tarwiyah - the 8th of Dhul-Hijjah.";
        String text =   "<html><body>"
                + "<p align=\"justify\">"
                + mydata
                + "</p> "
                + "</body></html>";
        view01.loadData(text, "text/html", "utf-8");

        view02 = (WebView) findViewById(R.id.text2);
        String mydata1= " -> you who believe! Give you response to Allah and His Messenger, when He calls you to that which will give you life. [Noble Quran 8:24] ";
        String text1 =   "<html><body>"
                + "<p align=\"justify\">"
                + mydata1
                + "</p> "
                + "</body></html>";
        view02.loadData(text, "text/html", "utf-8");

        prev = (Button)findViewById(R.id.pre002);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ninezilhajj.this, Eightzilhajj.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
                finish();
            }
        });
        next = (Button)findViewById(R.id.next002);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ninezilhajj.this, Tenzilhajj.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);
                finish();
            }
        });

    }
}
