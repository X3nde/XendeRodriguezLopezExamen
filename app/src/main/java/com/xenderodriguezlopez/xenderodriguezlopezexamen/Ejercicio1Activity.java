package com.xenderodriguezlopez.xenderodriguezlopezexamen;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio1Activity extends AppCompatActivity {
    private int contador = 0; // Variable para el contador

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        // Referencias a los elementos del diseño
        TextView textViewContador = findViewById(R.id.textViewContador);
        Button buttonIncrementar = findViewById(R.id.buttonIncrementar);

        // Listener para el botón
        buttonIncrementar.setOnClickListener(v -> {
            contador++; // Incrementar el contador
            textViewContador.setText("Contador: " + contador); // Actualizar el TextView
        });
    }
}
