package com.carnescarbon.retouno.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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
       View view = inflater.from(parent.getContext()).inflate(R.layout.lista_servicios,parent,false);
       view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cv.setAnimation(AnimationUtils.loadAnimation(inflater.getContext(), R.anim.fade_transition));
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
        CardView cv;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.titulo_servicio);
            descripcion = itemView.findViewById(R.id.descripcion_service);
            imagen = itemView.findViewById(R.id.image_servicio);
            cv = itemView.findViewById(R.id.cv);


        }
    }


}
