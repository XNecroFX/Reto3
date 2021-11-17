package Reto3_Lunes.Reto3_Lunes.Servicios;

import Reto3_Lunes.Reto3_Lunes.Modelo.Gymmachine;
import Reto3_Lunes.Reto3_Lunes.Repositorio.RepositorioGymmachine;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosGymmachine implements Serializable{
    @Autowired
    private RepositorioGymmachine metodosCrud;
    public List<Gymmachine> getAll (){
        return metodosCrud.getAll();    
    }
    
    public Optional<Gymmachine> getGymmachine(int idGymmachine){
        return metodosCrud.getGymmachine(idGymmachine);
    }
    public Gymmachine save(Gymmachine machine){
        if(machine.getId()==null){
            return metodosCrud.save(machine);
        
        }else{
            Optional<Gymmachine> evt=metodosCrud.getGymmachine(machine.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(machine);            
            }else{
                return machine;
            }
        }
    }
}