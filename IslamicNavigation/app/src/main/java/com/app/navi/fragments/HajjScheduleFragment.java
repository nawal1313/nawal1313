package com.app.navi.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.navi.R;
import com.app.navi.databinding.FragmentSlideshowBinding;
import com.app.navi.hajj.Eightzilhajj;
import com.app.navi.hajj.Elevenzilhajj;
import com.app.navi.hajj.Ninezilhajj;
import com.app.navi.hajj.Tenzilhajj;
import com.app.navi.hajj.Tewelvezilhajj;

import java.util.ArrayList;

public class HajjScheduleFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    WebView tev,tev2;
    ListView list;
    public ArrayAdapter<String> listAdapter;
    ArrayList<String> values = new ArrayList<String>();
    ImageView one, two, three, four, five;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tev = binding.hajjtext1;
        String mydata="Hajj is one of the five pillars of Islam.  Hajj represents one of the peak experiences in the life of a Muslim. The Hajj or Pilgrimage is made to the sacred places of Islam in and around Mecca. Once in a lifetime every Muslim, man or woman, is expected, unless it is impossible, to make a pilgrimage (a hajj) to Mecca. The pilgrim should perform the duties of Hajj during the sacred month Dhul-Hijjah so as to enter with thousands of others into the annual mass observance of the circumambulation of the Kaa'ba. The Hajj formally begins on the eighth day of Zul-Hijjah - the 12th month of the Muslim lunar calendar. ";
        String text =   "<html><body>"
                + "<p align=\"justify\">"
                + mydata
                + "</p> "
                + "</body></html>";
        tev.loadData(text, "text/html", "utf-8");

        tev2 = binding.hajjtext2;
        String mydata1="These are some pieces of advice and useful points which I offer to our brothers about to make Hajj.";
        String text1 =   "<html><body>"
                + "<p align=\"justify\">"
                + mydata1
                + "</p> "
                + "</body></html>";
        tev2.loadData(text, "text/html", "utf-8");


        list = binding.list1;
        values.add("First  (8 Zill-Hajj)");
        values.add("Second (9 Zill-Hajj)");
        values.add("Third  (10 Zill-Hajj)");
        values.add("Fourth (11 Zill-Hajj)");
        values.add("Fifth  (12 Zill-Hajj)");
        final ArrayAdapter<String> stlist = new ArrayAdapter<String>(requireContext(), R.layout.item_hajj, R.id.tvTitle, values);
        list.setAdapter(stlist);

        list.setOnItemClickListener((arg0, arg1, arg2, arg3) -> {
            String str = ((TextView) arg1).getText().toString();
            if(str.equals("Fisrt  (8 Zill-Hajj)")){
                Intent intent = new Intent(requireContext(), Eightzilhajj.class);
                startActivity(intent);

            }

            else if(str.equals("Second (9 Zill-Hajj)")){
                Intent intent = new Intent(requireContext(), Ninezilhajj.class);
                startActivity(intent);

            }
            else if(str.equals("Third  (10 Zill-Hajj)")){
                Intent intent = new Intent(requireContext(), Tenzilhajj.class);
                startActivity(intent);

            }
            else if(str.equals("Fourth (11 Zill-Hajj)")){
                Intent intent = new Intent(requireContext(), Elevenzilhajj.class);
                startActivity(intent);


            }
            else{
                Intent intent = new Intent(requireContext(), Tewelvezilhajj.class);
                startActivity(intent);

            }

        });

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;
    }


}