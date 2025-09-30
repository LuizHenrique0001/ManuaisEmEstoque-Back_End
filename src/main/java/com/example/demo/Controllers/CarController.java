package com.example.demo.Controllers;

import com.example.demo.DTOs.CarDTO;
import com.example.demo.Entity.Car;
import com.example.demo.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cars")
public class CarController {

    @Autowired
    private CarService service;

    @GetMapping
    public ResponseEntity<List<Car>> findAll(){
        return ResponseEntity.ok().body(service.findByStatus());
    }

    @GetMapping("/{chassi}")
    public ResponseEntity<Car> findByChassi(@PathVariable String chassi){
        return ResponseEntity.ok().body(service.findByChassi(chassi));
    }

    @PostMapping
    public ResponseEntity<Void> saveCarDTO(@RequestBody CarDTO carDTO){
         return ResponseEntity.status(201).body(service.saveCar(carDTO));
    }

    @PutMapping
    public ResponseEntity<Void> updateCar(@RequestBody CarDTO carDTO){
        return ResponseEntity.accepted().body(service.updateCar(carDTO));
    }

    @DeleteMapping("/{chassi}")
    public ResponseEntity<Void> disableOrActivateCar(@PathVariable String chassi){
        return ResponseEntity.ok().body(service.disableOrActivateCar(chassi));
    }

}
