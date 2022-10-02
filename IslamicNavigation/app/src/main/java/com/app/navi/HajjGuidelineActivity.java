package com.app.navi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.navi.hajj.Eightzilhajj;
import com.app.navi.hajj.Elevenzilhajj;
import com.app.navi.hajj.Ninezilhajj;
import com.app.navi.hajj.Tenzilhajj;
import com.app.navi.hajj.Tewelvezilhajj;

import java.util.ArrayList;

public class HajjGuidelineActivity extends AppCompatActivity {
    WebView tev,tev2;
    ListView list;
    public ArrayAdapter<String> listAdapter;
    ArrayList<String> values = new ArrayList<String>();
    //String[] listitems;
    //  ArrayAdapter<String> adapter;
    ImageView one, two, three, four, five;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hajj_guideline);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);





        tev = (WebView) findViewById(R.id.hajjtext1);
        String mydata="Hajj is one of the five pillars of Islam.  Hajj represents one of the peak experiences in the life of a Muslim. The Hajj or Pilgrimage is made to the sacred places of Islam in and around Mecca. Once in a lifetime every Muslim, man or woman, is expected, unless it is impossible, to make a pilgrimage (a hajj) to Mecca. The pilgrim should perform the duties of Hajj during the sacred month Dhul-Hijjah so as to enter with thousands of others into the annual mass observance of the circumambulation of the Kaa'ba. The Hajj formally begins on the eighth day of Zul-Hijjah - the 12th month of the Muslim lunar calendar. ";
        String text =   "<html><body>"
                + "<p align=\"justify\">"
                + mydata
                + "</p> "
                + "</body></html>";
        tev.loadData(text, "text/html", "utf-8");

        tev2 = (WebView) findViewById(R.id.hajjtext2);
        String mydata1="These are some pieces of advice and useful points which I offer to our brothers about to make Hajj.";
        String text1 =   "<html><body>"
                + "<p align=\"justify\">"
                + mydata1
                + "</p> "
                + "</body></html>";
        tev2.loadData(text, "text/html", "utf-8");


        list = (ListView) findViewById(R.id.list1);
        values.add("First  (8 Zill-Hajj)");
        values.add("Second (9 Zill-Hajj)");
        values.add("Third  (10 Zill-Hajj)");
        values.add("Fourth (11 Zill-Hajj)");
        values.add("Fifth  (12 Zill-Hajj)");
        final ArrayAdapter<String> stlist = new ArrayAdapter<String>(this,
               R.layout.item_hajj, R.id.tvTitle, values);
        list.setAdapter(stlist);

        list.setOnItemClickListener((arg0, arg1, arg2, arg3) -> {
            String str = ((TextView) arg1).getText().toString();
            if(str.equals("Fisrt  (8 Zill-Hajj)")){
                Intent intent = new Intent(this, Eightzilhajj.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);

            }
         
            else if(str.equals("Second (9 Zill-Hajj)")){
                Intent intent = new Intent(this, Ninezilhajj.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);

            }
            else if(str.equals("Third  (10 Zill-Hajj)")){
                Intent intent = new Intent(this, Tenzilhajj.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);

            }
            else if(str.equals("Fourth (11 Zill-Hajj)")){
                Intent intent = new Intent(this, Elevenzilhajj.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);


            }
            else{
                Intent intent = new Intent(this, Tewelvezilhajj.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);
                finish();
            }

        });

/*
        one = (ImageView)findViewById(R.id.zill1);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this,Guideline001.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);
                finish();
            }
        });
        two = (ImageView)findViewById(R.id.zill2);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this,Guideline002.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);
                finish();
            }
        });
        three = (ImageView)findViewById(R.id.zill3);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this,GuideLine003.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);
                finish();
            }
        });
        four = (ImageView)findViewById(R.id.zill4);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this,GuideLine004.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);
                finish();
            }
        });
        five = (ImageView)findViewById(R.id.zill5);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this,GuideLine005.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);
                finish();
            }
        });

       /* try {
            list = (ListView) findViewById(R.id.list1);
            String[] listitems = new String[]{"8 Zil-Hajj", "9 Zil-Hajj", "10 Zil-Hajj", "11 Zil-Hajj", "12 Zil-Hajj"};
          //  ArrayList<String> myStringArray1 = new ArrayList<String>();
          //  myStringArray1.add("Hellow");
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_hajj_guideline, listitems);
            list.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } catch (Exception ex) {
        }*/

    }
}
