/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DAOInterface.TransaksiDAOInterface;
import Helper.KoneksiDB;
import Model.Transaksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransaksiDAO implements TransaksiDAOInterface {
    @Override
    public void saveTransaksi(Transaksi transaksi) throws SQLException {
        String query = "INSERT INTO transaksi (id_tiket, tanggal) VALUES (?, ?)";
        
        try (Connection connection = KoneksiDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, transaksi.getTiketId());
            statement.setDate(2, new java.sql.Date(transaksi.getTanggal().getTime()));
            statement.executeUpdate();
        }
    }

    @Override
    public List<Transaksi> getAllTransaksi() throws SQLException {
        List<Transaksi> transaksis = new ArrayList<>();
        String query = "SELECT * FROM transaksi";
        
        try (Connection connection = KoneksiDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Transaksi transaksi = new Transaksi(
                    resultSet.getInt("id"),
                    resultSet.getInt("id_tiket"),
                    resultSet.getDate("tanggal")
                );
                transaksis.add(transaksi);
            }
        }
        return transaksis;
    }
}

