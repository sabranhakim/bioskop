/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DAOInterface.FilmDAOInterface;
import Helper.KoneksiDB;
import Model.Film;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO implements FilmDAOInterface {
    @Override
    public List<Film> getAllFilms() throws SQLException {
        List<Film> films = new ArrayList<>();
        String query = "SELECT * FROM film";
        
        try (Connection connection = KoneksiDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Film film = new Film(
                    resultSet.getInt("id"),
                    resultSet.getString("judul"),
                    resultSet.getString("genre"),
                    resultSet.getDouble("harga")
                );
                films.add(film);
            }
        }
        return films;
    }
}

