package com.example.practicat3semana11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.practicat3semana11.Adaptador.LibroAdapter;
import com.example.practicat3semana11.Clase.Libro;
import com.example.practicat3semana11.Factories.RetroFactori;
import com.example.practicat3semana11.Servicios.LibroService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    List<Libro>libros=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit= RetroFactori.build();
        LibroService service = retrofit.create(LibroService.class);
        Call<List<Libro>> call=service.GetLibro();
        call.enqueue(new Callback<List<Libro>>() {
            @Override
            public void onResponse(Call<List<Libro>> call, Response<List<Libro>> response) {
                //si hay conectividad
                if(!response.isSuccessful()){
                    Log.e("APP_VJ20202","Error de aplicacion");
                }else{
                    Log.i("APP_VJ20202","Respuesta correcta");
                    Log.i("APP_VJ20202",new Gson().toJson(response.body()));
                    libros=response.body();
                    LibroAdapter adapter = new LibroAdapter(libros);
                }
            }
            @Override
            public void onFailure(Call<List<Libro>> call, Throwable t) {
                //no hay conectividad
                Log.e("APP_VJ20202","No hubo conectividad con el servicio web");
            }
        });
        Button btnRegistrar=findViewById(R.id.btnCrear);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),RegistrarActivity.class);
                startActivity(intent);
            }
        });
        Button btnMostrar=findViewById(R.id.btnMostrar);
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MostrarLibro.class);
                startActivity(intent);
            }
        });
    }
}