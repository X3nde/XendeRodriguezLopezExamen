package com.xenderodriguezlopez.xenderodriguezlopezexamen;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio3Activity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor acelerometro;
    private TextView textViewMovimiento;
    private static final float UMBRAL_MOVIMIENTO = 15.0f; // Umbral para detectar movimiento brusco

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        // Referencia al TextView
        textViewMovimiento = findViewById(R.id.textViewMovimiento);

        // Inicialización del SensorManager y el acelerómetro
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }

        if (acelerometro == null) {
            textViewMovimiento.setText("No se encontró acelerómetro en este dispositivo.");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Registrar el listener del acelerómetro
        if (acelerometro != null) {
            sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Cancelar el registro del listener para ahorrar batería
        if (acelerometro != null) {
            sensorManager.unregisterListener(this);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // Calcular la magnitud del movimiento
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        float magnitud = (float) Math.sqrt(x * x + y * y + z * z);

        // Si el movimiento supera el umbral, mostrar un mensaje
        if (magnitud > UMBRAL_MOVIMIENTO) {
            textViewMovimiento.setText("¡Movimiento brusco detectado!");
        } else {
            textViewMovimiento.setText("Movimientos suaves...");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
