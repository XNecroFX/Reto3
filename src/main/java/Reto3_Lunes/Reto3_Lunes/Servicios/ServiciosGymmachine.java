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
    public Gymmachine save(Gymmachine m){
        if(m.getId()==null){
            return metodosCrud.save(m);
        
        }else{
            Optional<Gymmachine> evt=metodosCrud.getGymmachine(m.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(m);            
            }else{
                return m;
            }
        }
    }
    public Gymmachine update(Gymmachine machine){
        if(machine.getId()!=null){
            Optional<Gymmachine> e=metodosCrud.getGymmachine(machine.getId());
            if(!e.isEmpty()){
                if(machine.getName()!=null){
                    e.get().setName(machine.getName());
                }
                if(machine.getBrand()!=null){
                    e.get().setBrand(machine.getBrand());
                }
                if(machine.getYear()!=null){
                    e.get().setYear(machine.getYear());
                }
                if(machine.getDescription()!=null){
                    e.get().setDescription(machine.getDescription());
                }
                if(machine.getCategory()!=null){
                    e.get().setCategory(machine.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return machine;
            }
        }else{
            return machine;
        }
    }
    
    public boolean delete(int machineId) {
        Boolean aBoolean = getGymmachine(machineId).map(machine -> {
            metodosCrud.delete(machine);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}