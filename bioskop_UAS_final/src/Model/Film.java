/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hakim
 */
public class Film {
    private int id;
    private String judul;
    private String genre;
    private double harga;

    public Film(int id, String judul, String genre, double harga) {
        this.id = id;
        this.judul = judul;
        this.genre = genre;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getGenre() {
        return genre;
    }

    public double getHarga() {
        return harga;
    }

    @Override
    public String toString() {
        return judul;
    }
}

