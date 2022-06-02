package com.example.practicat3semana11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.practicat3semana11.Clase.Libro;
import com.example.practicat3semana11.Factories.RetroFactori;
import com.example.practicat3semana11.Servicios.LibroService;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegistrarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        Button btnRegistrar = findViewById(R.id.btnAgregar);
        EditText etTitulo = findViewById(R.id.edNombre);
        EditText etResumen = findViewById(R.id.edResumen);
        EditText etAutor = findViewById(R.id.edAutor);
        EditText etFecha = findViewById(R.id.edFecha);
        EditText edLatitud1=findViewById(R.id.edLatitud1);
        EditText edLongitud1=findViewById(R.id.edLongitud1);
        EditText edLatitud2=findViewById(R.id.edLatitud2);
        EditText edLongitud2=findViewById(R.id.edLongitud2);
        EditText edLatitud3=findViewById(R.id.edLatitud3);
        EditText edLongitud3=findViewById(R.id.edLongitud3);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit= RetroFactori.build();
                LibroService service = retrofit.create(LibroService.class);
                Libro libros = new Libro();
                libros.titulo=String.valueOf(etTitulo.getText());
                libros.resumen=String.valueOf(etResumen.getText());
                libros.autor=String.valueOf(etAutor.getText());
                libros.fechaPublicacion=String.valueOf(etFecha.getText());
                String lati1=String.valueOf(edLatitud1.getText());
                libros.latitud1=Double.parseDouble(lati1);
                String longi1=String.valueOf(edLongitud1.getText());
                libros.longitud1=Double.parseDouble(longi1);
                String lati2=String.valueOf(edLatitud2.getText());
                libros.latitud2=Double.parseDouble(lati2);
                String longi2=String.valueOf(edLongitud2.getText());
                libros.longitud2=Double.parseDouble(longi2);
                String lati3=String.valueOf(edLatitud3.getText());
                libros.latitud3=Double.parseDouble(lati3);
                String longi3=String.valueOf(edLongitud3.getText());
                libros.longitud3=Double.parseDouble(longi3);
                Call<Libro> call=service.create(libros);
                call.enqueue(new Callback<Libro>() {
                    @Override
                    public void onResponse(Call<Libro> call, Response<Libro> response) {
                        if(response.isSuccessful()){
                            Log.i("APP_VJ20202", new Gson().toJson(response.body()));
                        }
                    }

                    @Override
                    public void onFailure(Call<Libro> call, Throwable t) {
                        Log.e("APP_VJ20202","No nos podemos conectar al servicio web");
                    }
                });
            }
        });
    }
}