package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private TextView txtContador;
    private Switch sContrador;
    public static int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        txtContador = findViewById(R.id.txtContador);
        sContrador = findViewById(R.id.sTexto);
        if(sContrador.isChecked()){
            txtContador.setText("Contador :"+contador);
        }else{
            txtContador.setText(""+contador);
        }

        contador=0;
    }

    public void sumar(View vista){
        contador++;
        contador();
    }

    private void contador() {
        if(sContrador.isChecked()){
            txtContador.setText("Contador :"+contador);
        }else{
            txtContador.setText(""+contador);
        }
    }

    public void resetear(View vista){
        contador =0;
        contador();
    }

    public void restar(View vista){
        contador--;
        contador();

    }
}