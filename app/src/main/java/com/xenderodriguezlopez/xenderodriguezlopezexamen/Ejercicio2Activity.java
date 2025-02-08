package com.xenderodriguezlopez.xenderodriguezlopezexamen;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class Ejercicio2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        // Referencias a los elementos del diseño
        EditText editTextCiudad = findViewById(R.id.editTextCiudad);
        Button buttonConsultar = findViewById(R.id.buttonConsultarTemperatura);
        TextView textViewResultado = findViewById(R.id.textViewResultadoTemperatura);

        // Listener para el botón
        buttonConsultar.setOnClickListener(v -> {
            String ciudad = editTextCiudad.getText().toString();
            if (!ciudad.isEmpty()) {
                new ConsultarTemperaturaAsyncTask(textViewResultado).execute(ciudad);
            } else {
                textViewResultado.setText("Por favor, ingresa una ciudad.");
            }
        });
    }

    // Clase interna para la tarea en segundo plano
    private static class ConsultarTemperaturaAsyncTask extends AsyncTask<String, Void, String> {
        private final TextView textView;

        // Constructor para recibir el TextView donde mostrar el resultado
        public ConsultarTemperaturaAsyncTask(TextView textView) {
            this.textView = textView;
        }

        @Override
        protected String doInBackground(String... params) {
            String ciudad = params[0];
            Random random = new Random();
            int temperatura = random.nextInt(61) - 20; // Genera un número entre -20 y 40
            return "Temperatura en " + ciudad + ": " + temperatura + "ºC";
        }

        @Override
        protected void onPostExecute(String resultado) {
            textView.setText(resultado); // Muestra el resultado en el TextView
        }
    }
}
