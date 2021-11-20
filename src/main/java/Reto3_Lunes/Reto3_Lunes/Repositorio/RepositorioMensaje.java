package Reto3_Lunes.Reto3_Lunes.Repositorio;

import Reto3_Lunes.Reto3_Lunes.Interface.InterfaceMensaje;
import Reto3_Lunes.Reto3_Lunes.Modelo.Mensaje;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMensaje implements Serializable{
   @Autowired
    private InterfaceMensaje crud;
    
    public List<Mensaje> getAll(){
        return (List<Mensaje>) crud.findAll();
    }
    public Optional <Mensaje> getMensaje(int id){
        return crud.findById(id);
    }
    public Mensaje save(Mensaje e){
        return crud.save(e);
    } 
    public void delete(Mensaje e){
        crud.delete(e);
    }
}
