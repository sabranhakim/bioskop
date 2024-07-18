/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DAOInterface.TiketDAOInterface;
import Helper.KoneksiDB;
import Model.Tiket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TiketDAO implements TiketDAOInterface {
    @Override
    public void saveTiket(Tiket tiket) throws SQLException {
        String query = "INSERT INTO tiket (id_film, jumlah, total_harga) VALUES (?, ?, ?)";
        
        try (Connection connection = KoneksiDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, tiket.getFilmId());
            statement.setInt(2, tiket.getJumlah());
            statement.setDouble(3, tiket.getTotalHarga());
            statement.executeUpdate();
        }
    }

    @Override
    public List<Tiket> getAllTickets() throws SQLException {
        List<Tiket> tikets = new ArrayList<>();
        String query = "SELECT * FROM tiket";
        
        try (Connection connection = KoneksiDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Tiket tiket = new Tiket(
                    resultSet.getInt("id"),
                    resultSet.getInt("id_film"),
                    resultSet.getInt("jumlah"),
                    resultSet.getDouble("total_harga")
                );
                tikets.add(tiket);
            }
        }
        return tikets;
    }
}

