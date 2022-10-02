package com.app.navi;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.app.navi.adapter.HotelAdapter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;

public class AllHotelsActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleMap mMap;
    protected GoogleApiClient mGoogleApiClient;
    protected Location mLastLocation;
    double a, b;
    ListView list;

    private double latitude;
    private double longitude;
    LocationManager locationManager;
    LocationListener locationListener;

    String strCountaryReturnedAddress = null;
    Double[] destlongitude = {
            39.8579,
            39.8203111,
            39.8226063,
            39.8247371,
            39.8217267,
            39.8235715,
            39.8236142,
            39.8222308,
            39.8206611,
            39.8230293,
            39.8178216,
            39.8168753,
            39.8221968,
            39.8226977,
            39.8242807,
            39.8241569,
            39.8241569,
            39.8286303,
            39.8467612,
            39.8257881,
            39.8221507,
            39.8265423,
            39.8265423,
            39.8265423,
            39.8265423,
            39.8265423,

    };
    Double[] destlatitudes = {
            21.3891,
            21.4206149,
            21.419198,
            21.4186451,
            21.4204507,
            21.4185001,
            21.4185001,
            21.4180175,
            21.4191798,
            21.4209732,
            21.4179663,
            21.4179663,
            21.4243911,
            21.4243911,
            21.423697,
            21.4188082,
            21.4182178,
            21.4194985,
            21.4203081,
            21.4197578,
            21.402561,
            21.4224473,
            21.4147966,
            21.3866761,
            21.418114,
            21.4132806,

    };
    String[] itemname = {
            "Hyatt Regency Makkah",
            "Raffles Makkah Palace",
            "Dar Al Ghufran",
            "Makkah Hilton Towers",
            "Moevenpick Hotel & Residences Hajar Tower Makkah",
            "Swissotel Makkah",
            "ZamZam Pullman Makkah",
            "InterContinental Dar Al Tawhid",
            "Makkah Clock Royal Tower, A Fairmont Hotel",
            "Anjum Hotel Makkah",
            "Makkah Marriott Hotel",
            "Elaf Kinda Hotel",
            "Al Marwa Rayhaan by Rotana-Makkah",
            "Royal Dar Al Eiman",
            "Le Meridien Makkah",
            "Al Safwah Royale Orchid",
            "Makarem Umm Alqura Hotel",
            "Elaf Bakkah Hotel",
            "Hotel Al Shohada",
            "Drnef Hotel Makkah",
            "Elaf Almashaer",
            "Infinity Hotel Makkah",
            "Makarem Al-Bait Hotel",
            "Sheraton Makkah Hotel and Towers",
            "Golden Manafea Hotel",
            "Mohammad Faleh Aljabri Hotel"

    };

    String[] hoteladdress = {
            "Ash Shubaikah, Ibrahim Al Khalil Street, Mecca 24231, Saudi Arabia",
            "King Abdul Aziz Endowment، Mecca Saudi Arabia",
            "Ajyad, Safwa Towers, St, Mecca 24231, Saudi Arabia",
            "Ibrahim Al Khalil, Mecca 21955, Saudi Arabia",
            "Mecca Saudi Arabia",
            "Ajyad, King Abdul Aziz Endowment, Street, Mecca 24231, Saudi Arabia",
            "Abraj Al Bait Complex, Mecca Saudi Arabia",
            "Ibrahim Al Khalil Rd, Al Hajlah, Mecca 24231, Saudi Arabia",
            "Oum Al Qura Street, King Abdul Aziz Endowment, Abraj Al Bait Complex, Mecca Saudi Arabia",
            "Mecca 24231, Saudi Arabia",
            "3414 Umm Al Qura Rd, Mecca 21955, Saudi Arabia",
            "Mecca Saudi Arabia",
            "Abraj Al Bait Ajyad Street King Abdul Aziz Gate 9601, Mecca Saudi Arabia",
            "Ajyad St, Ajyad, Mecca Saudi Arabia",
            "Le Meridien Makkah, King Abdul Aziz Road, Mecca, Saudi Arabia، Mecca 13700, Saudi Arabia",
            "Ajyad St, Ajyad, Mecca Saudi Arabia",
            "Ajyad Street,P.O. Box 7020 Makkah, Mecca 21955, Saudi Arabia",
            "Al Rahmah St, Al Aziziyah, Mecca 24236, Saudi Arabia",
            "Ajyad St, Mecca 24231, Saudi Arabia",
            "3rd Ring Rd, At Taqwa, Mecca Saudi Arabia",
            "Mecca 24231, Saudi Arabia",
            "Al Hajlah, 4417,, Mecca 24231, Saudi Arabia",
            "Makarim AlBait Hotel Mecca 24236, Saudi Arabia",
            "Umm Al Qura Rd, Mecca 24231, Saudi Arabia",
            "Prince Majid Ibn Abdulaziz, Al Maabdah, Mecca 24236, Saudi Arabia",
            "Al Khalidiyyah, Mansur Street, Jarham District, Meccca 24232,, Mecca 24232, Saudi Arabia"

    };
    String[] hotelnumbers = {
            "+966 12 577 1234",
            "+966 12 571 7888",
            "+966 12 577 7773",
            "+966 12 534 0000",
            "+966 12 571 7171",
            "+966 12 571 8000",
            "+91 99209 74825",
            "+966 12 529 5000",
            "+966 12 571 7777",
            "+966 12 562 9999",
            "+966 12 529 6666",
            "+966 59 434 0154",
            "+966 12 571 4444",
            "+966 9920975825",
            "+966 12 575 1111",
            "+966 12 576 8888",
            "+966 12 535 6100",
            "+966 12 529 8822",
            "+966 12 574 4401",
            "+966 12 533 7134",
            "+91 99209 75825",
            "+966 9200 33003",
            "+966 12 566 9292"
    };
    Integer[] imgid = {
            R.drawable.hyattregencymakkah,
            R.drawable.rafflesmakkahpalace,
            R.drawable.daralghufran,
            R.drawable.hiltonmakkah,
            R.drawable.moevenpickhotel,
            R.drawable.swissotelmakkah,
            R.drawable.zamzam,
            R.drawable.intercontinentaldaraltawhid,
            R.drawable.clocktower,
            R.drawable.anjumhotelmakkah,
            R.drawable.makkahmarriotthotel,
            R.drawable.elafkindahotel,
            R.drawable.almarwarayhaanbyrotana,
            R.drawable.royaldaraleiman,
            R.drawable.lemeridienmakkahhotel,
            R.drawable.alsafwahhotel,
            R.drawable.makarimummalqurahotel,
            R.drawable.elafbakkahhotel,
            R.drawable.hotelalshohada,
            R.drawable.drnefhotelmakkah,
            R.drawable.elafalmashaer,
            R.drawable.infinityhotelmakkah,
            R.drawable.makaremalbaithotel,
            R.drawable.sheratonmakkah,
            R.drawable.goldenmanafea,
            R.drawable.mohammadfaleh,

    };
    HotelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_hotels);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        try {
            adapter = new HotelAdapter(this, itemname, imgid, hoteladdress, hotelnumbers) {
                @Override
                public void showLocation(int position) {
                    String uri = "http://maps.google.com/maps?saddr=" + latitude + "," + longitude + "&daddr=" + destlatitudes[position] + "," + destlongitude[position];
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    startActivity(intent);
                }
            };
            list = findViewById(R.id.listView2);
            list.setAdapter(adapter);
        } catch (Exception ex) {
        }

        list.setOnItemClickListener((parent, view, position, id) -> {

            String Slecteditem = itemname[+position];

        });
        buildGoogleApiClient();
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
    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
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
        } catch (Exception ex) {

        }


        LatLng makkah = new LatLng(21.3891, 39.8579);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(makkah));

        LatLng Hyatt = new LatLng(21.4206149, 39.8203111);
        mMap.addMarker(new MarkerOptions().position(Hyatt).title("Hyatt Regency Makkah").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Raffles = new LatLng(21.419198, 39.8226063);
        mMap.addMarker(new MarkerOptions().position(Raffles).title("Raffles Makkah Palace").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Dar = new LatLng(21.4186451, 39.8247371);
        mMap.addMarker(new MarkerOptions().position(Dar).title("Dar Al Ghufran").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Hilton = new LatLng(21.4204507, 39.8217267);
        mMap.addMarker(new MarkerOptions().position(Hilton).title("Makkah Hilton Towers").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Hajar = new LatLng(21.4185001, 39.8235715);
        mMap.addMarker(new MarkerOptions().position(Hajar).title("Moevenpick Hotel & Residences Hajar Tower Makkah").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Swisstole = new LatLng(21.4180175, 39.8236142);
        mMap.addMarker(new MarkerOptions().position(Swisstole).title("Swissotel Makkah").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng ZamZam = new LatLng(21.4191798, 39.8222308);
        mMap.addMarker(new MarkerOptions().position(ZamZam).title("ZamZam Pullman Makkah").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Tawhid = new LatLng(21.4209732, 39.8206611);
        mMap.addMarker(new MarkerOptions().position(Tawhid).title("InterContinental Dar Al Tawhid ").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Fairmont = new LatLng(21.4179663, 39.8230293);
        mMap.addMarker(new MarkerOptions().position(Fairmont).title("Makkah Clock Royal Tower, A Fairmont Hotel").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Anjum = new LatLng(21.4243911, 39.8178216);
        mMap.addMarker(new MarkerOptions().position(Anjum).title("Anjum Hotel Makkah").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Marriott = new LatLng(21.423697, 39.8168753);
        mMap.addMarker(new MarkerOptions().position(Marriott).title("Makkah Marriott Hotel").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Kinda = new LatLng(21.4188082, 39.8221968);
        mMap.addMarker(new MarkerOptions().position(Kinda).title("Elaf Kinda Hotel").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Rayhaan = new LatLng(21.4182178, 39.8226977);
        mMap.addMarker(new MarkerOptions().position(Rayhaan).title("Al Marwa Rayhaan by Rotana-Makkah").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Eiman = new LatLng(21.4194985, 39.8242807);
        mMap.addMarker(new MarkerOptions().position(Eiman).title("Royal Dar Al Eiman").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Meridien = new LatLng(21.4203081, 39.8241569);
        mMap.addMarker(new MarkerOptions().position(Meridien).title("Le Meridien Makkah").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Orchid = new LatLng(21.4197578, 39.8241569);
        mMap.addMarker(new MarkerOptions().position(Orchid).title("Al Safwah Royale Orchid").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Makarem = new LatLng(21.402561, 39.8286303);
        mMap.addMarker(new MarkerOptions().position(Makarem).title("Makarem Umm Alqura Hotel").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Bakkah = new LatLng(21.4224473, 39.8467612);
        mMap.addMarker(new MarkerOptions().position(Bakkah).title("Elaf Bakkah Hotel").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Shohada = new LatLng(21.4147966, 39.8257881);
        mMap.addMarker(new MarkerOptions().position(Shohada).title("Hotel Al Shohada").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Drnef = new LatLng(21.3866761, 39.8221507);
        mMap.addMarker(new MarkerOptions().position(Drnef).title("Drnef Hotel Makkah").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Almashaer = new LatLng(21.418114, 39.8265423);
        mMap.addMarker(new MarkerOptions().position(Almashaer).title("Elaf Almashaer").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

        LatLng Infinity = new LatLng(21.4132806, 39.8256862);
        mMap.addMarker(new MarkerOptions().position(Infinity).title("Infinity Hotel Makkah").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_mark)));

    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }
    @Override
    public void onConnectionSuspended(int cause) {


        mGoogleApiClient.connect();
    }

    public void onConnected(Bundle connectionHint) {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation != null) {

            a = mLastLocation.getLatitude();
            b = mLastLocation.getLongitude();
            sendMessage();

        } else {
        }
    }

    public void sendMessage() {
        String strAdd = "";
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(a, b, 1);
            if (addresses != null) {
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");
                int k=0;
                for (int i = 0; i < returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
                   k++;
                }
                strAdd = strReturnedAddress.toString();
                strCountaryReturnedAddress = returnedAddress.getAddressLine(k).toString();
            }
        } catch (Exception ex) {

        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
