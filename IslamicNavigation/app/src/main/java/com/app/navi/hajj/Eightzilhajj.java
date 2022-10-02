package com.app.navi.hajj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.app.navi.R;

public class Eightzilhajj extends AppCompatActivity {
    Button home, next;
    WebView view01, view02, view03, view04, view05, view06, view07;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eightzilhajj);


        view01 = (WebView) findViewById(R.id.text1);
        String mydata = "The pilgrim must fear his lord by obedience to Him, and must be very careful not to fall into that which Allah has forbidden as Allah says: ";
        String text = "<html><body>"
                + "<p align=\"justify\">"
                + mydata
                + "</p> "
                + "</body></html>";
        view01.loadData(text, "text/html", "utf-8");

        view02 = (WebView) findViewById(R.id.text2);
        String mydata1 = " -> For Hajj are the months well-known. If anyone undertaken that duty therein, let there be no obscenity nor wrangling in the Hajj. [Noble Quran 2:197]  ";
        String text1 = "<html><body>"
                + "<p align=\"justify\">"
                + mydata1
                + "</p> "
                + "</body></html>";
        view02.loadData(text1, "text/html", "utf-8");

        view03 = (WebView) findViewById(R.id.text3);
        String mydata2 = " -> And the prophet said: “He who performs Hajj and does not speak obscenely or commit evil then he returns from his sins just as the day his mother gave birth to him”, and if he did so then his Hajj would be accepted and the prophet of Allah said: “The accepted Hajj - there is no less a reward for it than Paradise. [1] So he must be aware of what many are affected by because of their ignorance or misguidance:  ";
        String text2 = "<html><body>"
                + "<p align=\"justify\">"
                + mydata2
                + "</p> "
                + "</body></html>";
        view03.loadData(text2, "text/html", "utf-8");

        view04 = (WebView) findViewById(R.id.text4);
        String mydata4 = " -> Directing any form of worship to other than Allah (shirk). And we have seen many of the people falling into shirk - like praying fro the removal of distress or aid from the Prophets and the pious instead of from Allah alone, and their taking oath by them in veneration of them - so by their actions they completely nullify their Hajj. As Allah says:  ";
        String text4 = "<html><body>"
                + "<p align=\"justify\">"
                + mydata4
                + "</p> "
                + "</body></html>";
        view04.loadData(text4, "text/html", "utf-8");

        view05 = (WebView) findViewById(R.id.text5);
        String mydata5 = " -> If you were to join gods with Allah, truly fruitless will be you work (in life). [Noble Quran 39:65]  ";
        String text5 = "<html><body>"
                + "<p align=\"justify\">"
                + mydata5
                + "</p> "
                + "</body></html>";
        view05.loadData(text4, "text/html", "utf-8");

        view06 = (WebView) findViewById(R.id.text6);
        String mydata6 = " -> Some men shaving off their beards - as it is a sinful deed - and doing it involves four separate sins - as I have explained in ‘The Original’.   ";
        String text6 = "<html><body>"
                + "<p align=\"justify\">"
                + mydata6
                + "</p> "
                + "</body></html>";
        view06.loadData(text4, "text/html", "utf-8");

        view07 = (WebView) findViewById(R.id.text7);
        String mydata7 = " -> The wearing of gold rings by men - and this is Haram - even more so those which are known as wedding-rings as that includes the further sin of imitating the Christians.  ";
        String text7 = "<html><body>"
                + "<p align=\"justify\">"
                + mydata7
                + "</p> "
                + "</body></html>";
        view07.loadData(text4, "text/html", "utf-8");


        home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Eightzilhajj.this, Ninezilhajj.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
                finish();
            }
        });

    }

}
