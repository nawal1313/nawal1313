package com.app.navi;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.app.navi.databinding.ActivitySearchMapBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import java.util.List;

public class MapSearchActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivitySearchMapBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySearchMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapActivity);
        mapFragment.getMapAsync(this);

        binding.btnShow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onSearch();
            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng makkah = new LatLng(21.3891, 39.8579);
        mMap.addMarker(new MarkerOptions().position(makkah).title("Makkah"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(makkah));

        LatLng masjidharam = new LatLng(21.3879533, 39.9004594);
        mMap.addMarker(new MarkerOptions().position(masjidharam).title("Masjid e Haram"));
        //  mMap.moveCamera(CameraUpdateFactory.newLatLng(masjidharam));

        LatLng medanarafat = new LatLng(21.3547, 39.984);
        mMap.addMarker(new MarkerOptions().position(medanarafat).title("Arafat"));
        //  mMap.moveCamera(CameraUpdateFactory.newLatLng(medanarafat));

        LatLng minah = new LatLng(21.4133, 39.8933);
        mMap.addMarker(new MarkerOptions().position(minah).title("Mina"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(minah));

        LatLng mudalfa = new LatLng(21.3878, 39.9145);
        mMap.addMarker(new MarkerOptions().position(mudalfa).title("Muzdalifah"));
        //  mMap.moveCamera(CameraUpdateFactory.newLatLng(mudalfa));

        LatLng ramijamrat = new LatLng(21.4224, 39.8696);
        mMap.addMarker(new MarkerOptions().position(ramijamrat).title("Rami Jamarat"));
        //  mMap.moveCamera(CameraUpdateFactory.newLatLng(ramijamrat));


        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        try {
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setZoomControlsEnabled(true);
            mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
            mMap.isTrafficEnabled();
            mMap.setBuildingsEnabled(true);
        }
        catch (Exception ex){

        }
    }

    public void onSearch(){
        EditText edt = (EditText) findViewById(R.id.et_place);
        String location = edt.getText().toString();
        List<Address> addresslist = null;
        Geocoder gcdr = new Geocoder(this);
        try{
            addresslist = gcdr.getFromLocationName(location,1);
        }
        catch (Exception ex){

        }

        Address address;
        if (addresslist != null){
            if (addresslist.size() == 0) {
                Toast.makeText(this, "Address Not Found", Toast.LENGTH_SHORT).show();
            }else{
                address = addresslist.get(0);
                LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            }


        }



    }
}