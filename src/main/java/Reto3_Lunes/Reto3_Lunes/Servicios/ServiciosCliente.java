package Reto3_Lunes.Reto3_Lunes.Servicios;

import Reto3_Lunes.Reto3_Lunes.Modelo.Cliente;
import Reto3_Lunes.Reto3_Lunes.Repositorio.RepositorioCliente;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ServiciosCliente implements Serializable{
    @Autowired
    private RepositorioCliente metodosCrud;
    public List<Cliente> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Cliente> getCliente(int idCliente){
        return metodosCrud.getCliente(idCliente);
    }
    public Cliente save(Cliente l){
        if(l.getIdClient()==null){
            return metodosCrud.save(l);
        
        }else{
            Optional<Cliente> evt=metodosCrud.getCliente(l.getIdClient());
            if(evt.isEmpty()){
                return metodosCrud.save(l);            
            }else{
                return l;
            }
        }
    }
    public Cliente update(Cliente l){
        if(l.getIdClient()!=null){
            Optional<Cliente> e= metodosCrud.getCliente(l.getIdClient());
            if(!e.isEmpty()){
                if(l.getName()!=null){
                    e.get().setName(l.getName());
                }
                if(l.getAge()!=0){
                    e.get().setAge(l.getAge());
                }
                if(l.getPassword()!=null){
                    e.get().setPassword(l.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return l;
            }
        }else{
            return l;
        }
    }

    public boolean delete(int clientId) {
        Boolean aBoolean = getCliente(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
