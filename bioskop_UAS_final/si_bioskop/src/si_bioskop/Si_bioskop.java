/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package si_bioskop;
import Controller.TiketController;
import DAO.FilmDAO;
import DAO.TiketDAO;
import DAO.TransaksiDAO;
import View.TiketView;
import java.sql.SQLException;

public class Si_bioskop {
    public static void main(String[] args) {
        try {
            FilmDAO filmDAO = new FilmDAO();
            TiketDAO tiketDAO = new TiketDAO();
            TransaksiDAO transaksiDAO = new TransaksiDAO();
            TiketView view = new TiketView();
            TiketController controller = new TiketController(filmDAO, tiketDAO, transaksiDAO, view);

            view.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

