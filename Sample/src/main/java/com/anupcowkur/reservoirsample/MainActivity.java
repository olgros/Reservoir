package com.anupcowkur.reservoirsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.anupcowkur.reservoir.Reservoir;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private String KEY = "key-data";

    Button btnGuardar;
    Button btnObtener;
    TextView txtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnObtener = (Button) findViewById(R.id.btnObtener);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
        btnGuardar.setOnClickListener(onClickListener);
        btnObtener.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnGuardar:

                    Data da = new Data();
                    da.setNumero(11);
                    da.setNombre("Olger con tiempo");

                    try {
                        Reservoir.put(KEY, da,4000);
                    }catch (IOException e) {
                        Log.e(KEY,e.toString());
                    }

                    break;
                case R.id.btnObtener:
                    try {
                        Data res = Reservoir.get(KEY, Data.class);
                        if (res == null){
                            txtResultado.setText("Ya expiro");
                            Log.e(KEY,"Ya expiro");
                        }else {
                            Log.d(KEY, res.getNombre() + " " + res.getNumero());
                            txtResultado.setText(res.getNombre() + " " + res.getNumero());
                        }
                    }catch (IOException e) {
                        Log.e(KEY,e.toString());
                    }


                    break;
            }
        }
    };
}
