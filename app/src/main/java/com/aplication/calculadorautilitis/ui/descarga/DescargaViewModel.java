package com.aplication.calculadorautilitis.ui.descarga;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DescargaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DescargaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is descarga fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}