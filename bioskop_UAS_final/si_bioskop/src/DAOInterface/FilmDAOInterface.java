/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Film;
import java.util.List;
/**
 *
 * @author hakim
 */
public interface FilmDAOInterface {
    List<Film> getAllFilms() throws Exception;
}
