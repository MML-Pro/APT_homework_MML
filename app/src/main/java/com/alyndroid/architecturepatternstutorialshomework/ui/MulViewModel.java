package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.model.NumberModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MulViewModel extends ViewModel {
   public MutableLiveData<Integer> result = new MutableLiveData<>();

    public int mul() {
        result.setValue(getNumFromDB().getFirstNum() * getNumFromDB().getSecondNum());
        return (getNumFromDB().getFirstNum() * getNumFromDB().getSecondNum());

    }

    public NumberModel getNumFromDB() {
        return new NumberModel(4, 2);
    }
}
