/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hakim
 */
public class Tiket {
    private int id;
    private int filmId;
    private int jumlah;
    private double totalHarga;

    public Tiket(int id, int filmId, int jumlah, double totalHarga) {
        this.id = id;
        this.filmId = filmId;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
    }

    public int getId() {
        return id;
    }

    public int getFilmId() {
        return filmId;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getTotalHarga() {
        return totalHarga;
    }
}

