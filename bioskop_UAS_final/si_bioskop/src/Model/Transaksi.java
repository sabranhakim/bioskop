/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hakim
 */
import java.util.Date;

public class Transaksi {
    private int id;
    private int tiketId;
    private Date tanggal;

    public Transaksi(int id, int tiketId, Date tanggal) {
        this.id = id;
        this.tiketId = tiketId;
        this.tanggal = tanggal;
    }

    public int getId() {
        return id;
    }

    public int getTiketId() {
        return tiketId;
    }

    public Date getTanggal() {
        return tanggal;
    }
}

