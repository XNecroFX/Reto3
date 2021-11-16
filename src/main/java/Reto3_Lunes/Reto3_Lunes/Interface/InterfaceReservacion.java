package Reto3_Lunes.Reto3_Lunes.Interface;

import Reto3_Lunes.Reto3_Lunes.Modelo.Reservacion;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceReservacion extends CrudRepository<Reservacion, Integer> {
    
}
