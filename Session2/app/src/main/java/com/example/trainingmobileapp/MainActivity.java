package com.example.trainingmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvHello = findViewById(R.id.tv_hello);
        Button btnClick = findViewById(R.id.btn_clickHere);

        ConstraintLayout constraintLayout = findViewById(R.id.layout_constraint);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Clicked!", Toast.LENGTH_SHORT).show();
                Snackbar.make(constraintLayout, "Snackbar!", Snackbar.LENGTH_SHORT)
                        .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE)
                        .show();
            }
        });

        Button btnClickMe = findViewById(R.id.btn_clickMe);
        btnClickMe.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Clicked!", Toast.LENGTH_SHORT).show();
        });

        Spinner spinner = findViewById(R.id.spinner_number);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter
                        .createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}