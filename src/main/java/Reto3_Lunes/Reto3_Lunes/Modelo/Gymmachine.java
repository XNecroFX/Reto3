package Reto3_Lunes.Reto3_Lunes.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "machine")
public class Gymmachine implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer idMachine;
    private String brand;
    private Integer year;
    private String name;
    private String description;
    
    @ManyToOne
    @JoinColumn(name ="id")
    @JsonIgnoreProperties("category")
    private Categoria category;
    
    @OneToMany (cascade = {CascadeType.PERSIST},mappedBy="machine")
    @JsonIgnoreProperties({"machine", "client"})
    private List<Mensaje> message;
    
    @OneToMany (cascade = {CascadeType.PERSIST},mappedBy="machine")
    @JsonIgnoreProperties({"machine", "message"})
    private List<Reservacion> reservation;

    public Integer getIdMachine() {
        return idMachine;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
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
