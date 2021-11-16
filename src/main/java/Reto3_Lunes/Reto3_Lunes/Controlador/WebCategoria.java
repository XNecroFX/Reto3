package Reto3_Lunes.Reto3_Lunes.Controlador;

import Reto3_Lunes.Reto3_Lunes.Modelo.Categoria;
import Reto3_Lunes.Reto3_Lunes.Servicios.ServiciosCategoria;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class WebCategoria implements Serializable{
    
    //Actualizado
    
    @Autowired
    private ServiciosCategoria servicios;
    @GetMapping ("all")
    public List<Categoria> getCategoria(){
        return servicios.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Categoria> getCategoria (@PathVariable("id") int idCategoria) {
        return servicios.getCategoria(idCategoria);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria save(@RequestBody Categoria categoria){
        return servicios.save(categoria);
    }
}
