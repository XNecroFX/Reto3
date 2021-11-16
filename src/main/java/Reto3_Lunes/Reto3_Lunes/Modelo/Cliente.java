package Reto3_Lunes.Reto3_Lunes.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "client")
public class Cliente implements Serializable{
    @Id
    @GeneratedValue (strategy =GenerationType.IDENTITY)
    
    private Integer idClient;
    private String email;
    private String password;
    private String name;
    private Integer age;
    
    @OneToMany (cascade = {CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    private List<Mensaje> message;
    
    @OneToMany (cascade = {CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    private List<Reservacion> reservation;

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Mensaje> getMessage() {
        return message;
    }

    public void setMessage(List<Mensaje> message) {
        this.message = message;
    }

    public List<Reservacion> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservacion> reservation) {
        this.reservation = reservation;
    }

}   