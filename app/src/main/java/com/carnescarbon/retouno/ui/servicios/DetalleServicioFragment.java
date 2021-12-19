package com.carnescarbon.retouno.ui.servicios;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.carnescarbon.retouno.R;
import com.carnescarbon.retouno.entidades.Servicio;



public class DetalleServicioFragment extends Fragment {

    TextView nombreDetalle;
    TextView descriptionDetalle;
    ImageView imagenDetalle;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detalles_servicio_fragment, container, false);

        nombreDetalle = view.findViewById(R.id.nombre_detalle);
        descriptionDetalle = view.findViewById(R.id.descripcion_detalle);
        imagenDetalle = view.findViewById(R.id.image_detalle);
         //crear objeto bundlepara recibir el objeto creado
        Bundle objetoServicio = getArguments();
        Servicio servicio = null;
        //validar argumetnos

        if(objetoServicio!=null){
            servicio = (Servicio) objetoServicio.getSerializable("objeto");
            //establecer los datos en las vistas
            nombreDetalle.setText(servicio.getNombre());
            descriptionDetalle.setText(servicio.getDescripcion());
            imagenDetalle.setImageResource(servicio.getImage());

        }




        return view;
    }


}
