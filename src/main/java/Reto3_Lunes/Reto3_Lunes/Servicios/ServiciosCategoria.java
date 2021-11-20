package Reto3_Lunes.Reto3_Lunes.Servicios;

import Reto3_Lunes.Reto3_Lunes.Modelo.Categoria;
import Reto3_Lunes.Reto3_Lunes.Repositorio.RepositorioCategoria;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosCategoria implements Serializable{

    @Autowired
    private RepositorioCategoria metodosCrud;
    
    public List<Categoria> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Categoria> getCategoria(int idCategoria){
        return metodosCrud.getCategoria(idCategoria);
    }
    
    public Categoria save(Categoria c){
        if(c.getId()==null){
            return metodosCrud.save(c);
        
        }else{
            Optional<Categoria> evt=metodosCrud.getCategoria(c.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(c);            
            
            }else{
                return c;
            }
        
        }
    }
     public Categoria update(Categoria c){
        if(c.getId()!=null){
            Optional<Categoria>g=metodosCrud.getCategoria(c.getId());
            if(!g.isEmpty()){
                if(c.getDescription()!=null){
                    g.get().setDescription(c.getDescription());
                }
                if(c.getName()!=null){
                    g.get().setName(c.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return c;
    }
     
     public boolean delete(int id){
        Boolean d;
        d = getCategoria(id).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
}
