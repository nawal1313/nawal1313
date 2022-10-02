package com.app.navi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private double latitude;
    private double longitude;
    LocationManager locationManager;
    LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();

    }

    private void initComponent() {
        Log.d("XYZ", " initComponent: ");
        initLocationInfo();
        initSlider();

       /* R.drawable.splash0, R.drawable.splash1, R.drawable.splash2,
                R.drawable.splash3, R.drawable.splash4, R.drawable.splash5,
                R.drawable.splash6, R.drawable.splash7, R.drawable.splash8,
                R.drawable.splash9, R.drawable.splash10, R.drawable.splash11,
                R.drawable.splash12*/


    }

    private void initSlider() {

        ImageCarousel carousel = findViewById(R.id.carousel);
        carousel.registerLifecycle(getLifecycle());
        List<CarouselItem> list = new ArrayList<>();
        list.add(
                new CarouselItem(
                        R.drawable.splash0,
                        ""
                )
        );

        list.add(
                new CarouselItem(
                        R.drawable.splash1,
                        ""
                )
        );
        list.add(
                new CarouselItem(
                        R.drawable.splash2,
                        ""
                )
        );
        list.add(
                new CarouselItem(
                        R.drawable.splash3,
                        ""
                )
        );
        list.add(
                new CarouselItem(
                        R.drawable.splash4,
                        ""
                )
        );
        list.add(
                new CarouselItem(
                        R.drawable.splash5,
                        ""
                )
        );
        list.add(
                new CarouselItem(
                        R.drawable.splash6,
                        ""
                )
        );
        list.add(
                new CarouselItem(
                        R.drawable.splash7,
                        ""
                )
        );

        carousel.setData(list);
    }

    private void initLocationInfo() {
        Log.d("XYZ", "initLocationInfo: ");
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        locationListener =new LocationListener() {
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

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.SEND_SMS,
                            Manifest.permission.CALL_PHONE},
                    1);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.SEND_SMS,
                            Manifest.permission.CALL_PHONE},
                    1);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.SEND_SMS,
                    Manifest.permission.CALL_PHONE},
                    1);
        } else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 10, locationListener);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
            }
        }

    }
}