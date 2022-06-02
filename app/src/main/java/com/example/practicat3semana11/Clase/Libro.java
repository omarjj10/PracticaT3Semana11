package com.example.practicat3semana11.Clase;

public class Libro {
    public int id;
    public String titulo;
    public String resumen;
    public String autor;
    public String fechaPublicacion;
    public double latitud1;
    public double longitud1;
    public double latitud2;
    public double longitud2;
    public double latitud3;
    public double longitud3;
    public String imagen;

    public Libro() {
    }

    public Libro(int id, String titulo, String resumen, String autor, String fechaPublicacion, double latitud1, double longitud1, double latitud2, double longitud2, double latitud3, double longitud3, String imagen) {
        this.id = id;
        this.titulo = titulo;
        this.resumen = resumen;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.latitud1 = latitud1;
        this.longitud1 = longitud1;
        this.latitud2 = latitud2;
        this.longitud2 = longitud2;
        this.latitud3 = latitud3;
        this.longitud3 = longitud3;
        this.imagen = imagen;
    }
}
