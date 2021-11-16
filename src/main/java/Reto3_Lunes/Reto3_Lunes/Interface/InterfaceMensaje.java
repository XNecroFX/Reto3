package Reto3_Lunes.Reto3_Lunes.Interface;

import Reto3_Lunes.Reto3_Lunes.Modelo.Mensaje;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceMensaje extends CrudRepository<Mensaje, Integer> {
    
}
