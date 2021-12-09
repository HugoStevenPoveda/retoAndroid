package com.carnescarbon.retouno.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carnescarbon.retouno.R;
import com.carnescarbon.retouno.entidades.Servicio;

import java.util.ArrayList;

public class AdapterServicio extends RecyclerView.Adapter<AdapterServicio.ViewHolder> implements View.OnClickListener {

//ATRIBUTOS
    LayoutInflater inflater;
    //lista pra los serviciso
    ArrayList<Servicio> model;

    //listener
    private View.OnClickListener listener;

    //COSTRUCTOR
    public AdapterServicio(Context context, ArrayList<Servicio> model) {
        this.inflater = LayoutInflater.from(context);
        this.model = model;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = inflater.inflate(R.layout.lista_servicios,parent,false);
       view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre = model.get(position).getNombre();
        String descripcion = model.get(position).getDescripciom();
        int imagen = model.get(position).getImageId();

        holder.nombre.setText(nombre);
        holder.descripcion.setText(descripcion);
        holder.imagen.setImageResource(imagen);



    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View view) {
        if(listener != null){
            listener.onClick(view);
        }


    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        //Atributos para realcionar con el layout

        TextView nombre, descripcion;
        ImageView imagen;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.titulo_servicio);
            descripcion = itemView.findViewById(R.id.descripcion_service);
            imagen = itemView.findViewById(R.id.image_servicio);


        }
    }


}
