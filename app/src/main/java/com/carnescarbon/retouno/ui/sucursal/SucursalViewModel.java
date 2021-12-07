package com.carnescarbon.retouno.ui.sucursal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SucursalViewModel extends ViewModel {


    //Atributos
    private MutableLiveData<String> mText;

    //Costructor
    public SucursalViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Nuestras Sucursales");
    }

    //metods
    public LiveData<String> getText() {

        return mText;
    }



}