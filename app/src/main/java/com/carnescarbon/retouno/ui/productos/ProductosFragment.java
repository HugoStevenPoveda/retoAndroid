package com.carnescarbon.retouno.ui.productos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carnescarbon.retouno.R;
import com.carnescarbon.retouno.ui.sucursal.SucursalViewModel;

public class ProductosFragment extends Fragment {

    private ProductosViewModel mViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        //INTANCIA EL MODEL
        mViewModel = new ViewModelProvider(this).get(ProductosViewModel.class);

        View root = inflater.inflate(R.layout.fragment_productos, container, false);
        final TextView textView = root.findViewById(R.id.text_producto);

        mViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }


}