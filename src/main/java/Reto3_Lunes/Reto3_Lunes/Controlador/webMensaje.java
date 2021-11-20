package Reto3_Lunes.Reto3_Lunes.Controlador;

import Reto3_Lunes.Reto3_Lunes.Modelo.Mensaje;
import Reto3_Lunes.Reto3_Lunes.Servicios.ServiciosMensaje;
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
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class webMensaje implements Serializable{
    @Autowired
    private ServiciosMensaje servicios;
    @GetMapping("/all")
    public List<Mensaje> getMensaje(){
        return servicios.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Mensaje> getMensaje (@PathVariable("id") int idMensaje) {
        return servicios.getMensaje(idMensaje);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje save(@RequestBody Mensaje mensaje){
        return servicios.save(mensaje);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje update(@RequestBody Mensaje message) {
        return servicios.update(message);
    }

    @DeleteMapping("/{idMesage}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("idMessage") int messageId) {
        return servicios.deleteMessage(messageId);
    }

}