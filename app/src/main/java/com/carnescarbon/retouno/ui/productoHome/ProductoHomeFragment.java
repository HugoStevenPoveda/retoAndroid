package com.carnescarbon.retouno.ui.productoHome;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.carnescarbon.retouno.R;
import com.carnescarbon.retouno.casos_uso.CasoUsoProductoHome;
import com.carnescarbon.retouno.databinding.FragmentProductoHomeBinding;
import com.carnescarbon.retouno.datos.ApiOracle;
import com.carnescarbon.retouno.datos.DBHelper;
import com.carnescarbon.retouno.entidades.ProductosHome;

import java.util.ArrayList;


public class ProductoHomeFragment extends Fragment {

    private FragmentProductoHomeBinding binding;

    private String TABLE_NAME = "SUCURSALES";
    private CasoUsoProductoHome casoUsoProductoHome;
    private GridView gridView;
    private ProgressBar progressBar;
    private DBHelper dbHelper;
    private ApiOracle apiOracle;
    private ArrayList<ProductosHome> productosHomes;

    public ProductoHomeFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_producto_home, container,false);
        try{
           casoUsoProductoHome = new CasoUsoProductoHome();
            apiOracle = new ApiOracle(root.getContext());
            gridView = (GridView) root.findViewById(R.id.gridSucursal);
            progressBar = (ProgressBar) root.findViewById(R.id.progressBarSuc);
            apiOracle.getAllProductoHome(gridView, progressBar);

            // ****** SQLITE ******
            //dbHelper = new DBHelper(getContext());
            //Cursor cursor = dbHelper.getData(TABLE_NAME);
            //sucursales = casoUsoSucursal.llenarListaSucursales(cursor);
            //SucursalAdapter sucursalAdapter = new SucursalAdapter(root.getContext(), sucursales);
            //gridView.setAdapter(sucursalAdapter);
            // ****** ****** ******


        }catch (Exception e){
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
            Log.w("Error ->>>", e.toString());
        }

        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

}