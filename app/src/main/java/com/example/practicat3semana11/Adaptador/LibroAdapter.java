package com.example.practicat3semana11.Adaptador;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicat3semana11.Clase.Libro;
import com.example.practicat3semana11.LibroActivity;
import com.example.practicat3semana11.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LibroAdapter extends RecyclerView.Adapter<LibroAdapter.LibroViewHolder>{
    List<Libro> libros;
    public static double latitudes;
    public static double longitudes;
    public static double latitudes2;
    public static double longitudes2;
    public static double latitudes3;
    public static double longitudes3;
    public LibroAdapter(List<Libro> libro){this.libros=libro;}

    @NonNull
    @Override
    public LibroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_libro,parent,false);
        return new LibroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibroViewHolder vh, int position) {
        View itemView = vh.itemView;
        Libro libro=libros.get(position);
        TextView tvNombre=itemView.findViewById(R.id.tvNombre);
        ImageView ivLibro = itemView.findViewById(R.id.ivLibro);
        tvNombre.setText(libro.titulo);
        Picasso.get().load("https://i.ibb.co/g3CJRtp/libro.png").into(ivLibro);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), LibroActivity.class);
                String pokemonJSON=new Gson().toJson(libro);
                intent.putExtra("Libro",pokemonJSON);
                latitudes=libro.latitud1;
                longitudes=libro.longitud1;
                latitudes2=libro.latitud2;
                longitudes2=libro.longitud2;
                latitudes3=libro.latitud3;
                longitudes3=libro.longitud3;
                itemView.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return libros.size();
    }
    class LibroViewHolder extends RecyclerView.ViewHolder{

        public LibroViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
