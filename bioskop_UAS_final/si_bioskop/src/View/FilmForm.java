/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import DAO.FilmDAO;
import Model.Film;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class FilmForm extends JFrame {
    private JTextField idTextField;
    private JTextField judulTextField;
    private JTextField genreTextField;
    private JTextField hargaTextField;
    private JTextField keteranganTextField;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JTable filmTable;
    private DefaultTableModel tableModel;

    private FilmDAO filmDAO;
    
    public FilmForm() {
        setTitle("Film Management");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        idTextField = new JTextField(20);
        idTextField.setEditable(false); // ID should not be editable
        judulTextField = new JTextField(20);
        genreTextField = new JTextField(20);
        hargaTextField = new JTextField(20);
        keteranganTextField = new JTextField(20);
        

        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");

        tableModel = new DefaultTableModel(new Object[]{"ID", "Judul", "Genre", "Harga","keterangan"}, 0);
        filmTable = new JTable(tableModel);

        // Set layout and add components
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.add(new JLabel("ID:"));
        formPanel.add(idTextField);
        formPanel.add(new JLabel("Judul:"));
        formPanel.add(judulTextField);
        formPanel.add(new JLabel("Genre:"));
        formPanel.add(genreTextField);
        formPanel.add(new JLabel("Harga:"));
        formPanel.add(hargaTextField);
        formPanel.add(new JLabel("keterangan:"));
        formPanel.add(keteranganTextField);
        formPanel.add(addButton);
        formPanel.add(updateButton);
        formPanel.add(deleteButton);
        formPanel.add(clearButton);

        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.NORTH);
        add(new JScrollPane(filmTable), BorderLayout.CENTER);

        // Initialize FilmDAO
        filmDAO = new FilmDAO();

        // Load films into table
        loadFilms();

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addFilm();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateFilm();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteFilm();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        filmTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fillFormFromTable();
            }
        });
    }

    private void loadFilms() {
        try {
            List<Film> films = filmDAO.getAllFilms();
            tableModel.setRowCount(0);
            for (Film film : films) {
                tableModel.addRow(new Object[]{film.getId(), film.getJudul(), film.getGenre(), film.getHarga(),film.getKeterangan()});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addFilm() throws SQLException {
        String judul = judulTextField.getText();
        String genre = genreTextField.getText();
        double harga = Double.parseDouble(hargaTextField.getText());
       String keterangan= keteranganTextField.getText();        

        if (judul.isEmpty() || genre.isEmpty() || harga <= 0) {
            JOptionPane.showMessageDialog(this, "Please enter valid data!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Film film = new Film(judul, genre, harga,keterangan);
        filmDAO.addFilm(film);
        loadFilms();
        clearForm();
        JOptionPane.showMessageDialog(this, "Film added successfully!");
    }

    private void updateFilm() throws SQLException {
        int id = Integer.parseInt(idTextField.getText());
        String judul = judulTextField.getText();
        String genre = genreTextField.getText();
        double harga = Double.parseDouble(hargaTextField.getText());
        String keterangan= keteranganTextField.getText();  

        if (judul.isEmpty() || genre.isEmpty() || harga <= 0) {
            JOptionPane.showMessageDialog(this, "Please enter valid data!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Film film = new Film(id, judul, genre, harga,keterangan);
        filmDAO.updateFilm(film);
        loadFilms();
        clearForm();
        JOptionPane.showMessageDialog(this, "Film updated successfully!");
    }

    private void deleteFilm() throws SQLException {
        int id = Integer.parseInt(idTextField.getText());
        filmDAO.deleteFilm(id);
        loadFilms();
        clearForm();
        JOptionPane.showMessageDialog(this, "Film deleted successfully!");
    }

    private void clearForm() {
        idTextField.setText("");
        judulTextField.setText("");
        genreTextField.setText("");
        hargaTextField.setText("");
        keteranganTextField.setText("");
    }

    private void fillFormFromTable() {
        int selectedRow = filmTable.getSelectedRow();
        idTextField.setText(tableModel.getValueAt(selectedRow, 0).toString());
        judulTextField.setText(tableModel.getValueAt(selectedRow, 1).toString());
        genreTextField.setText(tableModel.getValueAt(selectedRow, 2).toString());
        hargaTextField.setText(tableModel.getValueAt(selectedRow, 3).toString());
        keteranganTextField.setText(tableModel.getValueAt(selectedRow, 4).toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FilmForm form = new FilmForm();
            form.setVisible(true);
        });
    }
}

