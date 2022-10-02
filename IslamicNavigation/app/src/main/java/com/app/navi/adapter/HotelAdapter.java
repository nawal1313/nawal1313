package com.app.navi.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.navi.R;


public abstract class HotelAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;
    private final String[] hoteladdress;
    private final String[] hotelnumbers;

    protected abstract void showLocation(int position);
    public HotelAdapter(Activity context, String[] itemname, Integer[] imgid, String[] hoteladdress, String[] hotelnumbers) {
        super(context, R.layout.item_hotels, itemname);


        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
        this.hoteladdress=hoteladdress;
        this.hotelnumbers=hotelnumbers;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_hotels, null, true);

        TextView txtTitle = rowView.findViewById(R.id.tvTitle);
        ImageView imageView = rowView.findViewById(R.id.ivHotelPic);
        TextView extratxt = rowView.findViewById(R.id.tvPlace);
        TextView phonenumber = rowView.findViewById(R.id.tvNumber);
        ImageView call =   rowView.findViewById(R.id.ivDelete);
        ImageView route =   rowView.findViewById(R.id.tvRoute);


        call.setOnClickListener(v->{
            if (position < hotelnumbers.length){
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + hotelnumbers[position]));
                context.startActivity(intent);
            }else{
                Toast.makeText(context, "Ops Number Not Exist", Toast.LENGTH_SHORT).show();
            }

        });
        route.setOnClickListener(v->{
            showLocation(position);
        });



        if (position < imgid.length){
            imageView.setImageResource(imgid[position]);
        }
        if (position < hoteladdress.length){
            extratxt.setText(hoteladdress[position]);
        }
        if (position < hotelnumbers.length){
            phonenumber.setText(hotelnumbers[position]);
        }
        if (position < itemname.length){
            txtTitle.setText(itemname[position]);

        }

        return rowView;


    }
}
