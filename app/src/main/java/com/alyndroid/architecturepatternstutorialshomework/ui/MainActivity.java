package com.alyndroid.architecturepatternstutorialshomework.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.model.NumberModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.plus_button)
    Button plusButton;
    @BindView(R.id.mul_button)
    Button mulButton;
    @BindView(R.id.div_button)
    Button divButton;
    @BindView(R.id.mul_result_textView)
    TextView mulResultTextView;
    @BindView(R.id.plus_result_textView)
    TextView plusResultTextView;
    @BindView(R.id.div_result_textView)
    TextView divResultTextView;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.textView5)
    TextView textView5;
    NumberModel numberModel;

    Presenter presenter = new Presenter(MainActivity.this);
    MulViewModel mulViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        numberModel = new NumberModel(4, 2);
        plusButton.setOnClickListener(view -> plusResultTextView.setText(sum() + ""));
        divButton.setOnClickListener(view -> divResultTextView.setText(presenter.divMath() + ""));
        mulViewModel = new ViewModelProvider(this).get(MulViewModel.class);
        mulViewModel.result.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mulResultTextView.setText(integer + "");
            }
        });
        mulButton.setOnClickListener((view -> mulResultTextView.setText(mulViewModel.mul()+ "")));
    }

    private int sum() {
        return numberModel.getFirstNum() + numberModel.getSecondNum();
    }


}
