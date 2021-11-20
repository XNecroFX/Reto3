package Reto3_Lunes.Reto3_Lunes.Repositorio;

import Reto3_Lunes.Reto3_Lunes.Interface.InterfaceCliente;
import Reto3_Lunes.Reto3_Lunes.Modelo.Cliente;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class RepositorioCliente implements Serializable{
    @Autowired
    private InterfaceCliente crud;
    
    public List<Cliente> getAll(){
        return (List<Cliente>) crud.findAll();
    }
    public Optional <Cliente> getCliente (int id){
        return crud.findById(id);
    }
    public Cliente save(Cliente l){
        return crud.save(l);
    }
    public void delete(Cliente l){
        crud.delete(l);
    }
}
