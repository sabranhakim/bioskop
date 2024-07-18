/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Tiket;
import java.util.List;
/**
 *
 * @author hakim
 */


public interface TiketDAOInterface {
    void saveTiket(Tiket tiket) throws Exception;
    List<Tiket> getAllTickets() throws Exception;
}

