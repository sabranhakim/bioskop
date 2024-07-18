/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Model.Film;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TiketView extends JFrame {
    private JComboBox<Film> filmComboBox;
    private JTextField jumlahTextField;
    private JButton hitungButton;
    private JLabel totalHargaLabel;
    private JTable transaksiTable;
    private DefaultTableModel tableModel;

    public TiketView() {
        // Set layout and add components
        setTitle("Penjualan Tiket Bioskop");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        filmComboBox = new JComboBox<>();
        jumlahTextField = new JTextField(5);
        hitungButton = new JButton("Hitung Total Harga");
        totalHargaLabel = new JLabel("Total Harga: ");
        tableModel = new DefaultTableModel(new Object[]{"Judul Film", "Jumlah Tiket", "Total Harga"}, 0);
        transaksiTable = new JTable(tableModel);

        // Set layout manager
        setLayout(new BorderLayout());

        // Create panel for form inputs
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Pilih Film:"));
        inputPanel.add(filmComboBox);
        inputPanel.add(new JLabel("Jumlah Tiket:"));
        inputPanel.add(jumlahTextField);
        inputPanel.add(hitungButton);
        inputPanel.add(totalHargaLabel);

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(transaksiTable), BorderLayout.CENTER);
    }

    // Getters for components
    public JComboBox<Film> getFilmComboBox() {
        return filmComboBox;
    }

    public JTextField getJumlahTextField() {
        return jumlahTextField;
    }

    public JButton getHitungButton() {
        return hitungButton;
    }

    public JLabel getTotalHargaLabel() {
        return totalHargaLabel;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    // Main method for testing the view independently
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TiketView view = new TiketView();
            view.setVisible(true);
        });
    }
}

