package Reto3_Lunes.Reto3_Lunes.Servicios;

import Reto3_Lunes.Reto3_Lunes.Modelo.Mensaje;
import Reto3_Lunes.Reto3_Lunes.Repositorio.RepositorioMensaje;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosMensaje implements Serializable{
    @Autowired
    private RepositorioMensaje metodosCrud;
    public List<Mensaje> getAll(){
       return metodosCrud.getAll();
        
    }
    
    public Optional<Mensaje> getMensaje(int idMensaje){
        return metodosCrud.getMensaje(idMensaje);
    }
    
    public Mensaje save(Mensaje mensaje){
        if(mensaje.getIdMessage()==null){
            return metodosCrud.save(mensaje);
        
        }else{
            Optional<Mensaje> evt=metodosCrud.getMensaje(mensaje.getIdMessage());
            if(evt.isEmpty()){
                return metodosCrud.save(mensaje);            
            
            }else{
                return mensaje;
            }
        
        }
    }
}
