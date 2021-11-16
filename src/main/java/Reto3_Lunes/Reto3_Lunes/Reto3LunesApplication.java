//Modelo
//Interface
//Repositorio
//Servicios
//Controlador


package Reto3_Lunes.Reto3_Lunes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"Reto3_Lunes.Reto3_Lunes.Modelo"})
@SpringBootApplication
public class Reto3LunesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Reto3LunesApplication.class, args);
	}

}
