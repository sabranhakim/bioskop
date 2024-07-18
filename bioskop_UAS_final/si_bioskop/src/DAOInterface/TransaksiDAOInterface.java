/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Transaksi;
import java.util.List;
/**
 *
 * @author hakim
 */

public interface TransaksiDAOInterface {
    void saveTransaksi(Transaksi transaksi) throws Exception;
    List<Transaksi> getAllTransaksi() throws Exception;
}

