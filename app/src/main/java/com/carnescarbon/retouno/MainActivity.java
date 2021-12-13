package com.carnescarbon.retouno;

import android.os.Bundle;


import android.view.Menu;


import com.carnescarbon.retouno.entidades.Servicio;

import com.carnescarbon.retouno.ui.servicios.DetalleServicioFragment;
import com.carnescarbon.retouno.ui.servicios.IComunicaFragments;

import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.carnescarbon.retouno.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements IComunicaFragments {

    //ATRIBUTOS
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;


    //para cargar fragmet
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    ///atributos de fragment detalleservico
    DetalleServicioFragment detalleServicioFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_service, R.id.nav_producto,R.id.nav_sucursal)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void enviarServicio(Servicio servicio) {
        ///logica para poder realizar el envio de fragmet a fragmert

        detalleServicioFragment = new DetalleServicioFragment();
        //objeto bundle para trasportar info

        Bundle bundleEnvio = new Bundle();
        //enviar el obejto
        bundleEnvio.putSerializable("objeto",servicio);

        detalleServicioFragment.setArguments(bundleEnvio);

        //abrir  fragment
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_content_main,detalleServicioFragment);
        fragmentManager.popBackStack();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();







    }
}