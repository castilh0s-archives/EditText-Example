package com.example.edittextexample;

import android.support.design.widget.MathUtils;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroupMarcas;
    private CheckBox checkBoxQuatroPortas, checkBoxTocaFitas, checkBoxXenon;
    private Button buttonCalculate;
    private TextView resultado;
    private Double valorMarca;
    private Double valorOpcionais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupMarcas = findViewById(R.id.RadioGroupMarcas);
        checkBoxQuatroPortas = findViewById(R.id.CheckBoxPortas);
        checkBoxTocaFitas = findViewById(R.id.checkBoxTocaFitas);
        checkBoxXenon = findViewById(R.id.checkBoxXenon);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        resultado = findViewById(R.id.textViewResultado);

        radioGroupMarcas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButtonBMW:
                        valorMarca = 40000.00;
                        break;
                    case R.id.radioButtonPorsche:
                        valorMarca = 200000.00;
                        break;
                    case R.id.radioButtonFord:
                        valorMarca = 40000.00;
                        break;
                    case R.id.radioButtonFiat:
                        valorMarca = 30000.00;
                        break;
                    default:
                        resultado.setText("");
                }
            }
        });
    }

    public void onCalculateClick(View view) {
        valorOpcionais = 0.00;

        if (checkBoxQuatroPortas.isChecked()) {
            valorOpcionais += 2000.00;
        }

        if (checkBoxTocaFitas.isChecked()) {
            valorOpcionais += 500.00;
        }

        if (checkBoxXenon.isChecked()) {
            valorOpcionais += 3000.00;
        }

        resultado.setText("R$ " + (valorMarca + valorOpcionais));
    }
}
