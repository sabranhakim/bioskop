/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Helper.KoneksiDB;
import Model.Film;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {
    public void addFilm(Film film) throws SQLException {
        String query = "INSERT INTO film (judul, genre, harga,keterangan) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = KoneksiDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, film.getJudul());
            statement.setString(2, film.getGenre());
            statement.setDouble(3, film.getHarga());
            statement.setString(4, film.getKeterangan());
            statement.executeUpdate();
        }
    }

    public void updateFilm(Film film) throws SQLException {
        String query = "UPDATE film SET judul = ?, genre = ?, harga = ? ,keterangan=? WHERE id = ?";
        
        try (Connection connection = KoneksiDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, film.getJudul());
            statement.setString(2, film.getGenre());
            statement.setDouble(3, film.getHarga());
            statement.setString(4, film.getKeterangan());
            statement.setInt(5, film.getId());
            statement.executeUpdate();
        }
    }

    public void deleteFilm(int id) throws SQLException {
        String query = "DELETE FROM film WHERE id = ?";
        
        try (Connection connection = KoneksiDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public List<Film> getAllFilms() throws SQLException {
        List<Film> films = new ArrayList<>();
        String query = "SELECT * FROM film";
        
        try (Connection connection = KoneksiDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String judul = resultSet.getString("judul");
                String genre = resultSet.getString("genre");
                double harga = resultSet.getDouble("harga");
                String keterangan =resultSet.getString("keterangan");
                films.add(new Film(id, judul, genre, harga,keterangan));
            }
        }
        
        return films;
    }
}


