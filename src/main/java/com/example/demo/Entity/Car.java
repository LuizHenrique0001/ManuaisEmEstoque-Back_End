package com.example.demo.Entity;

import com.example.demo.DTOs.CarDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Cars")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String chassi;
    private String model;
    private String deliverToWho;
    private String observation;
    private Date dataReceived;
    private Date dataDelivered;
    private Boolean status;

    public Car(CarDTO carDTO) {

        this.id = null;
        this.chassi = carDTO.getChassi();
        this.model = carDTO.getModel();
        this.deliverToWho = null;
        this.observation = null;
        this.dataReceived = new Date();
        this.dataDelivered = null;
        this.status = true;
    }

    public String getChassi() {
        return chassi;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDeliverToWho() {
        return deliverToWho;
    }

    public void setDeliverToWho(String deliverToWho) {
        this.deliverToWho = deliverToWho;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Date getDataReceived() {
        return dataReceived;
    }

    public Date getDataDelivered() {
        return dataDelivered;
    }

    public void setDataDelivered(Date dataDelivered) {
        this.dataDelivered = dataDelivered;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

}
