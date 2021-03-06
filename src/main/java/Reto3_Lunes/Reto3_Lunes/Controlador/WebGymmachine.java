package Reto3_Lunes.Reto3_Lunes.Controlador;

import Reto3_Lunes.Reto3_Lunes.Modelo.Gymmachine;
import Reto3_Lunes.Reto3_Lunes.Servicios.ServiciosGymmachine;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Machine")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class WebGymmachine implements Serializable {
        
    @Autowired
    private ServiciosGymmachine servicios;
    @GetMapping ("/all")
    public List<Gymmachine> getGymmachine(){
        return servicios.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Gymmachine> getGymmachine(@PathVariable("id") int idGymmachine) {
        return servicios.getGymmachine(idGymmachine);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gymmachine save(@RequestBody Gymmachine gymmachine){
        return servicios.save(gymmachine);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gymmachine update(@RequestBody Gymmachine m) {
        return servicios.update(m);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int machineId) {
        return servicios.delete(machineId);
    }
}
