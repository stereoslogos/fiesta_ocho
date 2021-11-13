package com.example.fiesta_ocho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton jrbVIP, jrbPalco, jrbLateral, jrbGeneral, jrbWiskey, jrbRon, jrbAgua;
    TextView jtvPropina, jtvTotBoletas, jtvTotBotellas, jtvTotal;
    EditText jetBoleta, jetLicor;
    CheckBox jcbPropina;
    Button jbtCalc, jbtLimp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        jrbVIP = findViewById(R.id.rbVIP);
        jrbPalco = findViewById(R.id.rbPalco);
        jrbLateral = findViewById(R.id.rbLateral);
        jrbGeneral = findViewById(R.id.rbGeneral);
        jrbWiskey = findViewById(R.id.rbWiskey);
        jrbRon = findViewById(R.id.rbRon);
        jrbAgua = findViewById(R.id.rbAgua);
        jtvPropina = findViewById(R.id.tvPropina);
        jtvTotBoletas = findViewById(R.id.tvTotBoletas);
        jtvTotBotellas = findViewById(R.id.tvTotBotellas);
        jtvTotal = findViewById(R.id.tvTotal);
        jetBoleta = findViewById(R.id.etBoleta);
        jetLicor = findViewById(R.id.etLicor);
        jcbPropina = findViewById(R.id.cbPropina);
        jbtCalc = findViewById(R.id.btCalc);
        jbtLimp = findViewById(R.id.btLimp);

        jrbVIP.setChecked(true);
        jrbWiskey.setChecked(true);
        jcbPropina.setChecked(false);
        jetBoleta.requestFocus();
    }

    public void calc_tot(){
        String boletas, botellas;
        boletas = jetBoleta.getText().toString();
        botellas = jetLicor.getText().toString();

        if(boletas.isEmpty() || botellas.isEmpty()){
            Toast.makeText(this,"Número de personas y botellas reuqerido.",Toast.LENGTH_LONG).show();
            jetBoleta.requestFocus();
        }else{
            int can_bol, can_bot, val_bol, val_bot, tot_bol, tot_bot;
            double prop, total, val_total;

            can_bol = Integer.parseInt(boletas);
            can_bot = Integer.parseInt(botellas);
            val_bol = Integer.parseInt(jtvTotBoletas.getText().toString());
            val_bot = Integer.parseInt(jtvTotBotellas.getText().toString());
            tot_bol = val_bol * can_bol;
            tot_bot = val_bot * can_bot;


            total = tot_bol + tot_bot;

            if(jcbPropina.isChecked()){
                prop = total * 0.10;
            }else{
                prop = 0;
            }

            val_total = total + prop;

            jtvTotal.setText(String.valueOf(val_total));

        }
    }

    public void calc (View view){
        calc_tot();
    }

    public void vip(View view){
        jtvTotBoletas.setText("50000");
        calc_tot();
    }

    public void palco(View view){
        jtvTotBoletas.setText("35000");
        calc_tot();
    }

    public void laterales(View view){
        jtvTotBoletas.setText("20000");
        calc_tot();
    }

    public void general(View view){
        jtvTotBoletas.setText("25000");
        calc_tot();
    }

    public void wiskey(View view){
        jtvTotBotellas.setText("250000");
        calc_tot();
    }

    public void ron(View view){
        jtvTotBotellas.setText("180000");
        calc_tot();
    }

    public void agua(View view){
        jtvTotBotellas.setText("150000");
        calc_tot();
    }

    public void propina(View view){
        calc_tot();
    }

    public void Limpiar(View view){
        jrbVIP.setChecked(true);
        jrbWiskey.setChecked(true);
        jetBoleta.setText("");
        jetLicor.setText("");
        jcbPropina.setChecked(false);
        jtvTotBoletas.setText("50000");
        jtvTotBotellas.setText("150000");
        jtvPropina.setText("0");
        jtvTotal.setText("0");
        jetBoleta.requestFocus();
    }
}