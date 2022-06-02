package com.example.practicat3semana11.Servicios;

import com.example.practicat3semana11.Clase.Libro;
import retrofit2.Call;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LibroService {
    @GET("libros")
    Call<List<Libro>> GetLibro();
    @GET("libros/{id}")
    Call<Libro> findLibro(@Path("id") int a);
    @POST("libros")
    Call<Libro>create(@Body Libro libro);
    @PUT("libros/{id}")
    Call<Libro>update(@Path("id") int a,@Body Libro libro);
    @DELETE("libros/{id}")
    Call<Libro>delete(@Path("id") int a);
}
