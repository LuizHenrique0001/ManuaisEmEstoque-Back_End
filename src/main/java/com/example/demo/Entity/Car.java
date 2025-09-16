package com.example.demo.Entity;

import com.example.demo.DTOs.CarDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Cars")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
}
