package com.example.demo.DTOs;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table(name = "Cars")
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    private String chassi;
    private String model;
    private String observation;
    private String deliverToWho;

    public String getObservation() {
        return observation;
    }

    public String getChassi() {
        return chassi;
    }

    public String getModel() {
        return model;
    }

    public String getDeliverToWho() {
        return deliverToWho;
    }
}
