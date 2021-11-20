package Reto3_Lunes.Reto3_Lunes.Repositorio;

import Reto3_Lunes.Reto3_Lunes.Interface.InterfaceReservacion;
import Reto3_Lunes.Reto3_Lunes.Modelo.Reservacion;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioReservacion implements Serializable{
    @Autowired
    private InterfaceReservacion crud;
    
    public List<Reservacion> getAll(){
        return (List<Reservacion>) crud.findAll();
    }
    public Optional <Reservacion> getReservacion(int id){
        return crud.findById(id);
    }
    public Reservacion save(Reservacion r){
        return crud.save(r);
    }
    public void delete(Reservacion r){
        crud.delete(r);
    }
}
