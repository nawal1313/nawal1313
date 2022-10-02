package com.app.navi.fragments;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.app.navi.FindPathActivity;
import com.app.navi.MapSearchActivity;
import com.app.navi.R;
import com.app.navi.SavedPathsActivity;
import com.app.navi.databinding.FragmentMapBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private FragmentMapBinding binding;
    private GoogleMap mMap;
    double sourceLatitude;
    double sourceLongitude;
    double destinationLatitude;
    double destinationLongitude;
    LocationManager locationManager;
    LocationListener locationListener;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initComponent();

    }

    private void initComponent() {
        initMapInfo();
        initClicks();
        initLocationInfo();
    }

    private void initLocationInfo() {
        locationManager = (LocationManager) requireActivity().getSystemService(Context.LOCATION_SERVICE);
        locationListener =new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                sourceLatitude = location.getLatitude();
                sourceLongitude = location.getLongitude();
            }

            @Override
            public void onProviderDisabled(String provider) {

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {}

            @Override
            public void onProviderEnabled(String provider) { }

        };

        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 10, locationListener);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        }
    }

    private void initClicks() {
        binding.cardSearchActivity.setOnClickListener(v -> startActivity(new Intent(requireContext(), MapSearchActivity.class)));
        binding.cardFastestPath.setOnClickListener(v -> startActivity(new Intent(requireContext(), FindPathActivity.class)));
        binding.cardRecordPath.setOnClickListener(v -> startActivity(new Intent(requireContext(), SavedPathsActivity.class)));
        binding.cardNavigation.setOnClickListener(v -> {
            destinationLatitude = 21.3891;
            destinationLongitude = 39.8579;
            String uri = "http://maps.google.com/maps?saddr=" + sourceLatitude + "," + sourceLongitude + "&daddr=" + destinationLatitude + "," + destinationLongitude;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(intent);
        });
    }

    private void initMapInfo() {
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMapBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        LatLng makkah = new LatLng(21.3891, 39.8579);
        mMap.addMarker(new MarkerOptions().position(makkah).title("Makkah"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(makkah));

        LatLng masjidharam = new LatLng(21.3879533, 39.9004594);
        mMap.addMarker(new MarkerOptions().position(masjidharam).title("Masjid e Haram"));


        LatLng medanarafat = new LatLng(21.3547, 39.984);
        mMap.addMarker(new MarkerOptions().position(medanarafat).title("Arafat"));


        LatLng minah = new LatLng(21.4133, 39.8933);
        mMap.addMarker(new MarkerOptions().position(minah).title("Mina"));

        LatLng mudalfa = new LatLng(21.3878, 39.9145);
        mMap.addMarker(new MarkerOptions().position(mudalfa).title("Muzdalifah"));

        LatLng ramijamrat = new LatLng(21.4224, 39.8696);
        mMap.addMarker(new MarkerOptions().position(ramijamrat).title("Rami Jamarat"));


        if (ActivityCompat.checkSelfPermission(requireContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(requireContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }

        try {
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setZoomControlsEnabled(true);
            mMap.getUiSettings().setAllGesturesEnabled(true);
            mMap.getUiSettings().setMapToolbarEnabled(true);
            mMap.getUiSettings().setCompassEnabled(true);
            mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
            mMap.isTrafficEnabled();
        } catch (Exception ex) {
            Log.d("XYZ", "onMapReady: " + ex.getMessage());
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
            }
        }

    }
}


