package Reto3_Lunes.Reto3_Lunes.Repositorio;

import Reto3_Lunes.Reto3_Lunes.Modelo.Categoria;
import Reto3_Lunes.Reto3_Lunes.Interface.InterfaceCategoria;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCategoria implements Serializable{
    @Autowired
    private InterfaceCategoria crud;
    
    public List<Categoria> getAll(){
        return (List<Categoria>) crud.findAll();
    }
    public Optional <Categoria> getCategoria(int id){
        return crud.findById(id);
    }
    public Categoria save(Categoria categoria){
        return crud.save(categoria);
    }
    
    
}
