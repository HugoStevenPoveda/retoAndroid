package com.carnescarbon.retouno.ui.productos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProductosViewModel extends ViewModel {

    //Atributos
    private MutableLiveData<String> mText;

    //Costructor
    public ProductosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Nuestros Productos");
    }

    //metods
    public LiveData<String> getText() {

        return mText;
    }

}