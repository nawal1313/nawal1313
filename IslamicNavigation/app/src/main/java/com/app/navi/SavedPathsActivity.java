package com.app.navi;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.app.navi.models.Path;
import com.app.navi.databinding.ActivitySavedPathsBinding;
import com.app.navi.databinding.DialogSavePathBinding;
import com.app.navi.dialogs.DialogSavePath;
import com.app.navi.viewmodels.PathViewModel;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class SavedPathsActivity extends FragmentActivity implements OnMapReadyCallback {

    private ActivitySavedPathsBinding binding;
    private PathViewModel viewModel;
    private double latitude;
    private double longitude;
    LocationManager locationManager;
    LocationListener locationListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySavedPathsBinding.inflate(getLayoutInflater());
        initComponent();
    }

    private void initComponent() {
        viewModel = new ViewModelProvider(this).get(PathViewModel.class);
        initMapData();
        initClicks();
        initLocationInfo();
    }

    private void initClicks() {
        binding.cardSavePath.setOnClickListener(v -> {
            showSaveDataDialog();
        });

        binding.cardRecordPaths.setOnClickListener(v -> {
            startActivity(new Intent(this,PathListActivity.class));
        });
    }

    private void showSaveDataDialog() {
        DialogSavePath dialogSavePath = new DialogSavePath(this) {
            @Override
            public void onBind(DialogSavePathBinding dialogBinding) {


                dialogBinding.btnSave.setOnClickListener(v -> {
                    Editable title;
                    Editable placeName;
                    Editable destination;
                    Editable date;
                    title = dialogBinding.etTitle.getText();
                    placeName = dialogBinding.etPlaceName.getText();
                    destination = dialogBinding.etDestination.getText();
                    date = dialogBinding.etDate.getText();

                    if (title != null && title.length() <= 0 && placeName != null && placeName.length() <= 0 && destination != null && destination.length() <= 0 && date != null && date.length() <= 0) {
                        Toast.makeText(SavedPathsActivity.this, "Please Fill Information Correctly", Toast.LENGTH_SHORT).show();
                    } else {
                        Path path = new Path(title.toString(), placeName.toString(), destination.toString(), date.toString(),latitude,longitude);
                        viewModel.insert(path);
                        Toast.makeText(SavedPathsActivity.this, "Path Save Successfully", Toast.LENGTH_SHORT).show();
                        dismiss();
                    }


                });
                dialogBinding.btnCancel.setOnClickListener(v -> {
                    dismiss();
                });


            }
        };

        dialogSavePath.show();
    }

    private void initMapData() {
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapSavedPaths);
        mapFragment.getMapAsync(this);
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

    }
}