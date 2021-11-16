
package Reto3_Lunes.Reto3_Lunes.Repositorio;

import Reto3_Lunes.Reto3_Lunes.Modelo.Gymmachine;
import Reto3_Lunes.Reto3_Lunes.Interface.InterfaceGymmachine;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioGymmachine implements Serializable{
    @Autowired
    private InterfaceGymmachine crud;
    
    public List<Gymmachine> getAll(){
        return (List<Gymmachine>) crud.findAll();
    }
    public Optional <Gymmachine> getGymmachine (int id){
            return crud.findById(id);
    }
    public Gymmachine save(Gymmachine gymmachine){
        return crud.save(gymmachine);
    }
}
