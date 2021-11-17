package com.example.calculadoradegorjetas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.Touch;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textGorjeta;
    private TextView textTotal;
    private SeekBar seekBarGorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValorConta);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textGorjeta = findViewById(R.id.textValor_gorjeta);
        textTotal = findViewById(R.id.textValor_Total);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);



        // Adicionar Listener SeeBar

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                porcentagem = i;
                textPorcentagem.setText( Math.round( porcentagem )  + " %");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){

        String recuperarValor = editValor.getText().toString();
        if(recuperarValor == null || recuperarValor.equals("")){
            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor!!!",
                    Toast.LENGTH_SHORT
            ).show();

        }else{

            //converter a String para double

            double valorDigitado  = Double.parseDouble(recuperarValor);

            //caucular a gorjeta total

            double gorjeta = valorDigitado * (porcentagem/100 );

            //exibe a gorjeta e total

            textGorjeta.setText("R$ " + Math.round(gorjeta));
            textTotal.setText("R$ " + Math.round(gorjeta+valorDigitado));

        }

    }
.
}