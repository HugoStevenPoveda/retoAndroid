package com.carnescarbon.retouno;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.carnescarbon.retouno.databinding.ActivityShowMapsBinding;
import com.carnescarbon.retouno.entidades.ProductosHome;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ShowMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityShowMapsBinding binding;
    private ProductosHome productosHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityShowMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        String name = intent.getStringExtra("name");

        productosHome = new ProductosHome (name, location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney and move the camera
        LatLng init = productosHome.locationToCoord();
        googleMap.addMarker(new MarkerOptions().position(init).title(productosHome.getName()));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(init,7));
    }
}