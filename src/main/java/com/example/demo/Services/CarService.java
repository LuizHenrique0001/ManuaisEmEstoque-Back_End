package com.example.demo.Services;

import com.example.demo.Entity.Car;
import com.example.demo.Repositorys.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    public List<Car> findAll(){
        return repository.findAll();
    }
}
