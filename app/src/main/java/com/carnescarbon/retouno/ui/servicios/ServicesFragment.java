package com.carnescarbon.retouno.ui.servicios;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.carnescarbon.retouno.R;
import com.carnescarbon.retouno.adaptadores.AdapterServicio;
import com.carnescarbon.retouno.entidades.Servicio;

import java.util.ArrayList;


public class ServicesFragment extends Fragment {

    //Atributo
     private AdapterServicio adapterServicio;
     private RecyclerView recyclerViewServicio;
     private ArrayList<Servicio> listaServicios;

     //referecnia para comunicar fragments
    Activity actividad;
    IComunicaFragments interfaceComunicaFragments;





    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_services, container, false);
        recyclerViewServicio = view.findViewById(R.id.recyclerView);
        listaServicios = new ArrayList<>();
        //cargar lista
        cargarLista();

        //mostrar datos
        mostrarData();



        return view;
    }

    private void mostrarData() {
        recyclerViewServicio.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterServicio = new AdapterServicio(getContext(),listaServicios);
        recyclerViewServicio.setAdapter(adapterServicio);
        adapterServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = listaServicios.get(recyclerViewServicio.getChildAdapterPosition(view)).getNombre();
                String descripcion = listaServicios.get(recyclerViewServicio.getChildAdapterPosition(view)).getDescripciom();
                Toast.makeText(getContext(),"selecionado: "+ nombre, Toast.LENGTH_LONG).show();
                Toast.makeText(getContext(),"descripcion: "+ descripcion, Toast.LENGTH_SHORT).show();

                interfaceComunicaFragments.enviarServicio(listaServicios.get(recyclerViewServicio.getChildAdapterPosition(view)));
            }
        });
    }

    private void cargarLista() {
        listaServicios.add(new Servicio("hanburguesas","se realizan al por mayor", R.drawable.prodc_hamburguesa));
        listaServicios.add(new Servicio("hanburguesas","se realizan al por mayor", R.drawable.prodc_perrito));
        listaServicios.add(new Servicio("hanburguesas","se realizan al por mayor", R.drawable.prodc_pollo));
        listaServicios.add(new Servicio("hanburguesas","se realizan al por mayor", R.drawable.prodc_pollo));
        listaServicios.add(new Servicio("hanburguesas","se realizan al por mayor", R.drawable.prodc_pollo));
        listaServicios.add(new Servicio("hanburguesas","se realizan al por mayor", R.drawable.prodc_pollo));
        listaServicios.add(new Servicio("hanburguesas","se realizan al por mayor", R.drawable.prodc_pollo));
        listaServicios.add(new Servicio("hanburguesas","se realizan al por mayor", R.drawable.prodc_pollo));
        listaServicios.add(new Servicio("hanburguesas","se realizan al por mayor", R.drawable.prodc_pollo));
        listaServicios.add(new Servicio("hanburguesas","se realizan al por mayor", R.drawable.prodc_pollo));
        listaServicios.add(new Servicio("hanburguesas","se realizan al por mayor", R.drawable.prodc_pollo));
        listaServicios.add(new Servicio("hanburguesas","se realizan al por mayor", R.drawable.prodc_pollo));
        listaServicios.add(new Servicio("hanburguesas","se realizan al por mayor", R.drawable.prodc_pollo));
    }

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        if(context instanceof  Activity){
            this.actividad = (Activity) context;
                interfaceComunicaFragments = (IComunicaFragments)this.actividad;
        }



    }
    @Override
    public void onDetach(){
        super.onDetach();


    }


}