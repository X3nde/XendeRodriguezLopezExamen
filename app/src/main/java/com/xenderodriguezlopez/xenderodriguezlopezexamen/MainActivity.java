package com.xenderodriguezlopez.xenderodriguezlopezexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los botones
        Button botonEj1 = findViewById(R.id.botonEj1);
        Button botonEj2 = findViewById(R.id.botonEj2);
        Button botonEj3 = findViewById(R.id.botonEj3);

        // Listener para el botón Ej1
        botonEj1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio1Activity.class);
            startActivity(intent);
        });

        // Listener para el botón Ej2
        botonEj2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio2Activity.class);
            startActivity(intent);
        });

        // Listener para el botón Ej3
        botonEj3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio3Activity.class);
            startActivity(intent);
        });
    }
}