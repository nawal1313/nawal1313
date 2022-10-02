package com.app.navi;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.app.navi.adapter.RestaurantAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class RestaurantsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ListView list;

    Double[] destlongitude = {
            21.4133618 ,
            21.4351237 ,
            21.5465804 ,
            21.541845 ,
            21.541845 ,
            21.4055634 ,
            21.5727607 ,
            21.419907 ,
            21.4869649 ,
            21.4867168 ,
    };
    Double[] destlatitudes = {
            39.7928552 ,
            39.8019529 ,
            39.1328561 ,
            39.1120234 ,
            39.7484913 ,
            39.7676957 ,
            39.1113549 ,
            39.8229673 ,
            39.9285748 ,
            39.7184036 ,
    };
    Integer[] imgid={
            R.drawable.albaik,
            R.drawable.talahfordates,
            R.drawable.saadeddinpastry,
            R.drawable.charlotte,
            R.drawable.atyaf,
            R.drawable.baharat,
            R.drawable.narjestealounge,
            R.drawable.mazaq,
            R.drawable.ajwaa,
            R.drawable.thegrill
    };
    String[] itemname ={
            "Al Baik",
            "Talah For Dates",
            "Saadeddin",
            "Charlotte",
            "Atyaf",
            "Baharat",
            "Narjes Tea Lounge",
            "Mazaq",
            "Ajwaa",
            "The Grill"
    };
    String[] description ={
            "Quick Service Fast Food, Local Food Restaurant",
            "Quick Service Middle Eastern Bakery",
            "Middle Eastern Shop",
            "Quick Service European  Bakery",
            "Fine Dining Asian Restaurant",
            "Casual Dining South Asian Restaurant",
            "Casual Dining Coffee Shop, Fresh Juices Cafe",
            "Casual Dining European  Restaurant",
            "Casual Dining Middle Eastern Restaurant",
            "Fine Dining American Restaurant"

    };

    String[] branchinfo = {
            "5 Branches",
            "2 Branches",
            "2 Branches",
            "4 Branches",
            "1 Branche",
            "1 Branche",
            "1 Branche",
            "1 Branche",
            "1 Branche",
            "1 Branche"
    };

    String[] phonenumber={
            "6466546",
            "920008252",
            "920017070",
            "012-6622391",
            "012- 5717777",
            "012- 5717777",
            "012- 5717888",
            "012- 5717888",
            "012- 5717888",
            "012- 5717777",
    };
    private double latitude;
    private double longitude;
    LocationManager locationManager;
    LocationListener locationListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        RestaurantAdapter adapter= new RestaurantAdapter(this, itemname, imgid, description, phonenumber) {
            @Override
            protected void showLocation(int position) {
                String uri = "http://maps.google.com/maps?saddr=" + latitude + "," + longitude + "&daddr=" + destlatitudes[position] + "," + destlongitude[position];
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        };
        list= findViewById(R.id.listView2);
        list.setAdapter(adapter);

        list.setOnItemClickListener((parent, view, position, id) -> {

            String Slecteditem = itemname[+position];
            Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

        });
        initLocationInfo();
    }
    private void initLocationInfo() {
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                latitude = location.getLatitude();
               longitude = location.getLongitude();
            }

            @Override
            public void onProviderDisabled(String provider) { }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {}

            @Override
            public void onProviderEnabled(String provider) { }

        };

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 10, locationListener);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        try {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                 
                return;
            }
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setZoomControlsEnabled(true);
            mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
            mMap.isTrafficEnabled();
            mMap.setBuildingsEnabled(true);
        }
        catch (Exception ex){

        }


        LatLng makkah = new LatLng(21.3891, 39.8579);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(makkah));

        // Add a marker in Sydney and move the camera
        LatLng AlBaik = new LatLng(21.4133618,39.7928552);
        mMap.addMarker(new MarkerOptions().position(AlBaik).title("Al Baik").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sleep)));

        LatLng AlBaik1 = new LatLng(21.4351237,39.8019529);
        mMap.addMarker(new MarkerOptions().position(AlBaik1).title("Al Baik").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sleep)));

        LatLng Talah = new LatLng(21.5465804,39.1328561);
        mMap.addMarker(new MarkerOptions().position(Talah).title("Talah For Dates").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sleep)));

        LatLng Talah1 = new LatLng(21.541845,39.1120234);
        mMap.addMarker(new MarkerOptions().position(Talah1).title("Talah For Dates").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sleep)));

        LatLng Charlotte = new LatLng(21.4219752,39.7484913);
        mMap.addMarker(new MarkerOptions().position(Charlotte).title("Charlotte").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sleep)));

        LatLng Atyaf = new LatLng(21.4055634,39.7676957);
        mMap.addMarker(new MarkerOptions().position(Atyaf).title("Atyaf").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sleep)));

        LatLng Baharat = new LatLng(21.5727607,39.1113549);
        mMap.addMarker(new MarkerOptions().position(Baharat).title("Baharat").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sleep)));

        LatLng Narjese = new LatLng(21.419907,39.8229673);
        mMap.addMarker(new MarkerOptions().position(Narjese).title("Narjes Tea Lounge").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sleep)));

        LatLng Mazaq = new LatLng(21.4869649,39.9285748);
        mMap.addMarker(new MarkerOptions().position(Mazaq).title("Mazaq").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sleep)));

        LatLng Ajwaa = new LatLng(21.4867168,39.7184036);
        mMap.addMarker(new MarkerOptions().position(Ajwaa).title("Ajwaa").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sleep)));


    }
}
