package com.alyndroid.architecturepatternstutorialshomework.ui;

import android.content.Context;
import android.view.View;

import com.alyndroid.architecturepatternstutorialshomework.model.NumberModel;

public class Presenter {

    private Context context;

    public Presenter(Context context) {
        this.context = context;
    }

    NumberModel getNumbersFromDB(){
        return new NumberModel(4,2);
    }

      public int divMath() {
        return getNumbersFromDB().getFirstNum() / getNumbersFromDB().getFirstNum();
    }
}
