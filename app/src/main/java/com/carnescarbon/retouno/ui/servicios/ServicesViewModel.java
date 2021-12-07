package com.carnescarbon.retouno.ui.servicios;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ServicesViewModel extends ViewModel {

    //Atributos
    private MutableLiveData<String> mText;

    //Costructor
    public ServicesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Nuestros Servicios");
    }

    //metods
    public LiveData<String> getText() {

        return mText;
    }


}