/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
public class Film {
    private int id;
    private String judul;
    private String genre;
    private double harga;
    private String keterangan;

    public Film(int id, String judul, String genre, double harga,String keterangan) {
        this.id = id;
        this.judul = judul;
        this.genre = genre;
        this.harga = harga;
        this.keterangan=keterangan;
    }

    public Film(String judul, String genre, double harga,String keterangan) {
        this.judul = judul;
        this.genre = genre;
        this.harga = harga;
        this.keterangan=keterangan;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    
    
    
    
     @Override
    public String toString() {
        return judul;
    }
}


