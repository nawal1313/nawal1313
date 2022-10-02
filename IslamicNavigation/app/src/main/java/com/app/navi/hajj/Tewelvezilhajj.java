package com.app.navi.hajj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.app.navi.HajjGuidelineActivity;
import com.app.navi.R;

public class Tewelvezilhajj extends AppCompatActivity {

    Button prev, next;
    WebView view01,view02,view03,view04;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tewelvezilhajj);

        view01 = (WebView) findViewById(R.id.text1);
        String mydata="he people of knowledge should teach the pilgrims the rites of Hajj and its commands according to the Book and the Sunnah whenever meeting with them, and that should not stop them from calling to Tawhid which is the essence of Islam and was the reason for sending of the Prophets, and the sending down of revealed books, as most of the people whom we have met - even some of those who are supposed to be seeking knowledge - we have found to be in complete ignorance of the real meaning of oblivious to the necessity of the return of the Muslims - upon their differing madhabs (schools of thoughts) and various parties - to unification and joining ranks upon the basis of the Book and the Sunnah, - in belief (Aqidah) and Regulations (Ahkam) and transactions, and behaviour, and politics and economic affairs and all other aspects of life. And they must remember that any voice raised or any movement made to reform which is based upon any foundation other than this firm splitting and weakening of the Muslims - and will increase their shamefulness and humiliation - and the present state of affairs is the greatest proof of that - and Allah is the One Whose help is sought. ";
        String text =   "<html><body>"
                + "<p align=\"justify\">"
                + mydata
                + "</p> "
                + "</body></html>";
        view01.loadData(text, "text/html", "utf-8");

        view02 = (WebView) findViewById(R.id.text1);
        String mydata1="And there is nothing wrong with debating in the best way - when required, as the kind of argumentation that is forbidden in Hajj is useless argument which is also forbidden outside Hajj, just like the evil-doing that is forbidden in Hajj - for that is not the debating which is commanded in Allah's Quran: ";
        String text1 =   "<html><body>"
                + "<p align=\"justify\">"
                + mydata1
                + "</p> "
                + "</body></html>";
        view02.loadData(text, "text/html", "utf-8");

        view03 = (WebView) findViewById(R.id.text1);
        String mydata2="Invite (all) to the way of your Lord with wisdom and beautiful preaching, and argue with them in ways that are best and most gracious. [Noble Quran 16:125]";
        String text2 =   "<html><body>"
                + "<p align=\"justify\">"
                + mydata2
                + "</p> "
                + "</body></html>";
        view03.loadData(text, "text/html", "utf-8");

        view04 = (WebView) findViewById(R.id.text1);
        String mydata3="However, it should be noticed that if it appears that there is no benefit in the discussion because of the other persons blindly sticking to his madhab or own opinion - and if he were to continue then there is fear of going into that which is not permissible - then it is better to leave that argument with him as the Prophet said: “I am a claimant for a house in the outskirts of Paradise for one who leaves off arguing even if he is in the righ";
        String text3 =   "<html><body>"
                + "<p align=\"justify\">"
                + mydata3
                + "</p> "
                + "</body></html>";
        view04.loadData(text, "text/html", "utf-8");


        prev = (Button)findViewById(R.id.pre005);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tewelvezilhajj.this, Elevenzilhajj.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
                finish();
            }
        });
        next = (Button)findViewById(R.id.next005);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tewelvezilhajj.this, HajjGuidelineActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
                finish();
            }
        });

    }
}
