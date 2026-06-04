package com.example.smartpetrolcostcalculatorwithbudimadanirebatemalaysia;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Spinner spPetrol;
    EditText etPrice, etUsage;
    RadioButton rbYes;
    Button btnCalculate;
    TextView tvCost, tvRebate, tvSaving;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spPetrol = findViewById(R.id.spPetrol);
        etPrice = findViewById(R.id.etPrice);
        etUsage = findViewById(R.id.etUsage);
        rbYes = findViewById(R.id.rbYes);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvCost = findViewById(R.id.tvCost);
        tvRebate = findViewById(R.id.tvRebate);
        tvSaving = findViewById(R.id.tvSaving);

        String[] petrolTypes = {"RON95", "RON97", "Diesel"};

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,
                        petrolTypes);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spPetrol.setAdapter(adapter);

        btnCalculate.setOnClickListener(v -> {

            String petrol = spPetrol.getSelectedItem().toString();

            double price =
                    Double.parseDouble(etPrice.getText().toString());

            double usage =
                    Double.parseDouble(etUsage.getText().toString());

            double totalCost = usage * price;

            double rebate = 0;

            if (petrol.equals("RON95") && rbYes.isChecked()) {
                rebate = usage * 1.99;
            }

            double saving = totalCost - rebate;

            tvCost.setText("Total Petrol Cost : RM " + String.format("%.2f", totalCost));
            tvRebate.setText("BUDI Rebate : RM " + String.format("%.2f", rebate));
            tvSaving.setText("Total Saving : RM " + String.format("%.2f", saving));
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.nav_about){

            startActivity(
                    new Intent(
                            MainActivity.this,
                            AboutActivity.class));

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}