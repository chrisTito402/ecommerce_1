/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IPersistencia;

import entidades.Resenias;
import java.util.List;

/**
 *
 * @author chris
 */
public interface IReseniasDAO {

    List<Resenias> consultarResenias();
    
    void eliminarResenia(int id);

}
