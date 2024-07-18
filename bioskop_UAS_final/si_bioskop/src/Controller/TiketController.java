/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.FilmDAO;
import DAO.TiketDAO;
import DAO.TransaksiDAO;
import Model.Film;
import Model.Tiket;
import Model.Transaksi;
import View.TiketView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class TiketController {
    private Film[] films;
    private TiketView view;
    private FilmDAO filmDAO;
    private TiketDAO ticketDAO;
    private TransaksiDAO transaksiDAO;
    

    public TiketController(FilmDAO filmDAO, TiketDAO ticketDAO, TransaksiDAO transaksiDAO, TiketView view) throws SQLException {
        this.filmDAO = filmDAO;
        this.ticketDAO = ticketDAO;
        this.transaksiDAO = transaksiDAO;
        this.view = view;

        // Dapatkan semua film dari database
        List<Film> filmList = filmDAO.getAllFilms();
        this.films = filmList.toArray(new Film[0]);

        // Populate JComboBox with film titles
        for (Film film : films) {
            view.getFilmComboBox().addItem(film);
        }
        
        

        // Add action listener to button
        view.getHitungButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    hitungTotalHarga();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


    private void hitungTotalHarga() throws SQLException {
        try {
            double diskon = 0.1;
            
            int selectedIndex = view.getFilmComboBox().getSelectedIndex();
            if (selectedIndex == -1) {
                JOptionPane.showMessageDialog(view, "Pilih film terlebih dahulu", "Error", JOptionPane.ERROR_MESSAGE);
                return;
                
                
            }
          
            Film selectedFilm = films[selectedIndex];
            int jumlahTiket = Integer.parseInt(view.getJumlahTextField().getText());
            double hargaPerTiket = selectedFilm.getHarga();
            double total = jumlahTiket * hargaPerTiket;
            double totalHarga = total - (total * diskon);
              if( jumlahTiket  > 2 )
             {
                 view.getTotalHargaLabel().setText("Total Harga: " + totalHarga );
            } else {
                  view.getTotalHargaLabel().setText("Total Harga: " + total);
              }
            
           
            

            // Tampilkan total harga
            

            // Simpan tiket ke database
            Tiket ticket = new Tiket(0, selectedFilm.getId(), jumlahTiket, total);
            ticketDAO.saveTiket(ticket);
         

            // Dapatkan tiket terbaru dari database
            List<Tiket> tickets = ticketDAO.getAllTickets();
            Tiket latestTicket = tickets.get(tickets.size() - 1);
            

            // Simpan transaksi ke database
            Transaksi transaksi = new Transaksi(0, latestTicket.getId(), new java.util.Date());
            transaksiDAO.saveTransaksi(transaksi);

            // Tambahkan transaksi ke tabel
            view.getTableModel().addRow(new Object[]{selectedFilm.getJudul(), jumlahTiket, total});
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Masukkan jumlah tiket yang valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void isiCboFilm() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

