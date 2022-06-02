package com.example.practicat3semana11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practicat3semana11.Clase.Libro;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class LibroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro);
        String pokemonJSON=getIntent().getStringExtra("Libro");
        Libro libros= new Gson().fromJson(pokemonJSON,Libro.class);
        ImageView ivLibro = findViewById(R.id.ivLibro);
        TextView tvTitulo = findViewById(R.id.tvNombre);
        TextView tvResumen = findViewById(R.id.tvResumen);
        TextView tvAutor = findViewById(R.id.tvAutor);
        TextView tvFecha = findViewById(R.id.tvFecha);
        String tienda1 = String.valueOf(libros.latitud1)+","+String.valueOf(libros.longitud1);
        String tienda2 = String.valueOf(libros.latitud2)+","+String.valueOf(libros.longitud2);
        String tienda3 = String.valueOf(libros.latitud3)+","+String.valueOf(libros.longitud3);
        TextView tvTienda1=findViewById(R.id.tvTienda1);
        TextView tvTienda2=findViewById(R.id.tvTienda2);
        TextView tvTienda3=findViewById(R.id.tvTienda3);
        Picasso.get().load("https://i.ibb.co/g3CJRtp/libro.png").into(ivLibro);
        tvTitulo.setText(libros.titulo);
        tvResumen.setText(libros.resumen);
        tvAutor.setText(libros.autor);
        tvFecha.setText(libros.fechaPublicacion);
        tvTienda1.setText(tienda1);
        tvTienda2.setText(tienda2);
        tvTienda3.setText(tienda3);
        Button btnTienda1 = findViewById(R.id.btnTienda1);
        Button btnTienda2=findViewById(R.id.btnTiend2);
        Button btnTienda3=findViewById(R.id.btnTienda3);
        btnTienda1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });
        btnTienda2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MapsActivity2.class);
                startActivity(intent);
            }
        });
        btnTienda3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MapsActivity3.class);
                startActivity(intent);
            }
        });
    }
}