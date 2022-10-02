package com.app.navi.hajj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.app.navi.R;

public class Tenzilhajj extends AppCompatActivity {

    Button prev, next;
    WebView web01;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenzilhajj);

        web01 = (WebView) findViewById(R.id.text1);
        String mydata="You must not leave off staying the night at Mina on the night before ‘Arafah as it is obligatory (wajib) - the Prophet did it and ordered it with his saying: “Take from me your rites of pilgrimage.” And you must also stay the night at Muzdalifah until you pray Fajr prayer, and if you miss this staying then you must at least pray Fajr there - as that is even more obligatory - rather it is one of the rukn (pillar) of Hajj according to the most correct saying according to the scholars - except upon the woman and the weak - for it has been allowed for them to leave after half of the night has passed.";
        String text =   "<html><body>"
                + "<p align=\"justify\">"
                + mydata
                + "</p> "
                + "</body></html>";
        web01.loadData(text, "text/html", "utf-8");

        prev = (Button)findViewById(R.id.pre003);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tenzilhajj.this, Ninezilhajj.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
                finish();
            }
        });
        next = (Button)findViewById(R.id.next003);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tenzilhajj.this, Elevenzilhajj.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
                finish();
            }
        });

    }
}
