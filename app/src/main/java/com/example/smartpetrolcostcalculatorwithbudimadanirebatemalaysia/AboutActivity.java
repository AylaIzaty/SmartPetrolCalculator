package com.example.smartpetrolcostcalculatorwithbudimadanirebatemalaysia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AboutActivity extends AppCompatActivity {

    TextView tvGithub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = findViewById(R.id.aboutToolbar);
        setSupportActionBar(toolbar);

        tvGithub = findViewById(R.id.tvGithub);

        tvGithub.setOnClickListener(v -> {

            Intent intent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/AylaIzaty/SmartPetrolCalculator.git"));

            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.nav_home){

            Intent intent =
                    new Intent(
                            AboutActivity.this,
                            MainActivity.class);

            startActivity(intent);
            finish();

            return true;
        }

        if(id == R.id.nav_about){

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
