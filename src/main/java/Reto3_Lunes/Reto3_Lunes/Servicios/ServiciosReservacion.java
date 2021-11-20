package Reto3_Lunes.Reto3_Lunes.Servicios;

import Reto3_Lunes.Reto3_Lunes.Modelo.Reservacion;
import Reto3_Lunes.Reto3_Lunes.Repositorio.RepositorioReservacion;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosReservacion implements Serializable{

    @Autowired
    private RepositorioReservacion metodosCrud;
    
    public List<Reservacion> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Reservacion> getReservacion(int idReservacion){
        return metodosCrud.getReservacion(idReservacion);
    }
    
    public Reservacion save(Reservacion r){
        if(r.getIdReservation()==null){
            return metodosCrud.save(r);
        
        }else{
            Optional<Reservacion> evt=metodosCrud.getReservacion(r.getIdReservation());
            if(evt.isEmpty()){
                return metodosCrud.save(r);            
            
            }else{
                return r;
            }
        }
    }
    public Reservacion update(Reservacion reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservacion> e = metodosCrud.getReservacion((int) reservation.getIdReservation());
            if (!e.isEmpty()) {

                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservacion(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
