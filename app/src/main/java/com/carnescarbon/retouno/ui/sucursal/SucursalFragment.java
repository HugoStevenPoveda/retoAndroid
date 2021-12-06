package com.carnescarbon.retouno.ui.sucursal;

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

public class SucursalFragment extends Fragment {

    //Atributo
    private SucursalViewModel mViewModel;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //INTANCIA EL MODEL
        mViewModel = new ViewModelProvider(this).get(SucursalViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sucursal, container, false);
        final TextView textView = root.findViewById(R.id.text_sucursal);

        mViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;



    }



}