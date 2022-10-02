package com.app.navi.hajj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.app.navi.R;

public class Elevenzilhajj extends AppCompatActivity {

    Button prev, next;
    WebView view004;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_eleven);

        view004 = (WebView) findViewById(R.id.text1);
        String mydata="And be very careful not to walk directly in front of anyone praying in the Haram mosque, not to speak of other mosques and prying places as the Prophet said: “If the one walking between the hands of one praying knew what were upon him then it would be better for him to stand still for forty (…) than that he should walk between his hands. [Malik, al-Bukhari, Muslim, the 4 Sunan of Abu Juhaim]. And this is a general text covering everyone walking in front, and everyone praying - and there is no authentic Hadith to make any exception for the one doing so in the Haram Masjid - and you should pray therein like any other place towards a sutrah - according to the general nature of the Hadith regarding that - and there are also some narrations from the Companions particularly about the Masjid-ul-Haram - which I have mentioned in ‘The Original'.";
        String text =   "<html><body>"
                + "<p align=\"justify\">"
                + mydata
                + "</p> "
                + "</body></html>";
        view004.loadData(text, "text/html", "utf-8");

        prev = (Button)findViewById(R.id.pre004);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Elevenzilhajj.this, Tenzilhajj.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
                finish();
            }
        });
        next = (Button)findViewById(R.id.next004);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Elevenzilhajj.this, Tewelvezilhajj.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
                finish();
            }
        });

    }

}
