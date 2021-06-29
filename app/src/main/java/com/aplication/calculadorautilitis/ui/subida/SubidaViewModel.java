package com.aplication.calculadorautilitis.ui.subida;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SubidaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SubidaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is subida fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}