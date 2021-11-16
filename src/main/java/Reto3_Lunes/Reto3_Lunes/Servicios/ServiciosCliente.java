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
    public Cliente save(Cliente cliente){
        if(cliente.getIdClient()==null){
            return metodosCrud.save(cliente);
        
        }else{
            Optional<Cliente> evt=metodosCrud.getClient(cliente.getIdClient());
            if(evt.isEmpty()){
                return metodosCrud.save(cliente);            
            }else{
                return cliente;
            }
        }
    }
}
