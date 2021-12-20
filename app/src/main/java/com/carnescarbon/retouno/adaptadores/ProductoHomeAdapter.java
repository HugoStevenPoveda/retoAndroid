package com.carnescarbon.retouno.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.carnescarbon.retouno.R;
import com.carnescarbon.retouno.ShowMapsActivity;
import com.carnescarbon.retouno.entidades.ProductosHome;

import java.util.ArrayList;

public class ProductoHomeAdapter extends BaseAdapter {

    Context context;
    ArrayList<ProductosHome> productosHomes;
    LayoutInflater inflater;

    public ProductoHomeAdapter(Context context, ArrayList<ProductosHome> productosHomes) {
        this.context = context;
        this.productosHomes = productosHomes;
    }

    @Override
    public int getCount() {
        return productosHomes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView = inflater.inflate(R.layout.grid_item, null);
        }

        ImageView imageView = convertView.findViewById(R.id.imgItem);
        TextView campo1 = convertView.findViewById(R.id.tvCampo1);
        TextView campo2 = convertView.findViewById(R.id.tvCampo2);
        TextView campo3 = convertView.findViewById(R.id.tvCampo3);
        TextView campoId = convertView.findViewById(R.id.tvId);

        ProductosHome productosHome = productosHomes.get(position);
        byte[] image = productosHome.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);


        campoId.setText("ID :"+ productosHome.getId());
        campo1.setText(productosHome.getName());
        campo2.setText(productosHome.getDescription());
        campo3.setText(productosHome.getLocation());
        imageView.setImageBitmap(bitmap);

        imageView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(), "selecionado: " + productosHome.getName().toString(), Toast.LENGTH_LONG).show();


            }
        });



        return convertView;
    }



}
