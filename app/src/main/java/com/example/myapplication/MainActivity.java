package com.example.myapplication;

import android.accessibilityservice.AccessibilityService;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.KeyEvent;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private TextView txtContador;
    private Switch sContrador;
    private CheckBox cbPositivos;
    private EditText txtDefault;
    public static int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        txtContador = findViewById(R.id.txtContador);
        sContrador = findViewById(R.id.sTexto);
        txtDefault = findViewById(R.id.txtDefault);
        cbPositivos = findViewById(R.id.cbPositivos);
        contador=0;
        contador(null);

        EventoTeclado miEvento = new EventoTeclado();
        txtDefault.setOnEditorActionListener(miEvento);

    }

    class EventoTeclado implements TextView.OnEditorActionListener {

        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if(i == EditorInfo.IME_ACTION_DONE){
                if(!sContrador.isChecked()){
                    resetear(null);
                    return true;
                }
            }
            txtDefault.setText("");
            return false;
        }
    }

    public void sumar(View vista){
        contador++;
        contador(vista);
    }

    public void contador(View vista) {
        if(sContrador.isChecked()){
            txtContador.setText("Contador :"+contador);
        }else{
            txtContador.setText(""+contador);
        }
    }

    public void resetear(View vista){
        try{
            contador = Integer.parseInt(txtDefault.getText().toString());
        }catch (java.lang.NumberFormatException ex){
            contador =0;
        };

        if(cbPositivos.isChecked() && contador < 0){
            contador = 0;
        }

        contador(vista);
        txtDefault.setText("");

        InputMethodManager miTeclado = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        miTeclado.hideSoftInputFromWindow(txtDefault.getWindowToken(),0);
    }

    public void restar(View vista){
        contador--;
        if(cbPositivos.isChecked() && contador < 0){
            contador=0;
        }
        contador(vista);

    }
}