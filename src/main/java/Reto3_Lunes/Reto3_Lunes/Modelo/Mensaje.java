package Reto3_Lunes.Reto3_Lunes.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Mensaje implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name ="machineId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Gymmachine machine;
    
    @ManyToOne
    @JoinColumn(name ="clientId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Cliente client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Gymmachine getMachine() {
        return machine;
    }

    public void setMachine(Gymmachine machine) {
        this.machine = machine;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    
}
