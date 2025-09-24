package com.example.demo.Services;

import com.example.demo.DTOs.CarDTO;
import com.example.demo.Entity.Car;
import com.example.demo.Repositorys.CarRepository;
import com.example.demo.Services.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    public List<Car> findAll(){
        return repository.findAll();
    }

    public Car findByChassi(String chassi){
        Optional<Car> CarForChassi = repository.findByChassi(chassi);
        return CarForChassi.orElseThrow(() -> new ObjectNotFoundException("Chassi não encontrado!"));
    }

    public Void saveCar(CarDTO carDTO){
        if (repository.findByChassi(carDTO.getChassi()).isPresent()){
            throw new ObjectNotFoundException("Chassi Já Cadastrado!");
        }
       repository.save(new Car(carDTO));
        return null;
    }

    public Void updateCar(CarDTO carDTO){
        if (repository.findByChassi(carDTO.getChassi()).isPresent()){
            Car carOrigin = findByChassi(carDTO.getChassi());
            carOrigin.setModel(carDTO.getModel());
            carOrigin.setObservation(carDTO.getObservation());
            carOrigin.setDeliverToWho(carDTO.getDeliverToWho());
            repository.save(carOrigin);
            return null;
        }
        throw new ObjectNotFoundException("Chassi não encontrado!");
    }
}
