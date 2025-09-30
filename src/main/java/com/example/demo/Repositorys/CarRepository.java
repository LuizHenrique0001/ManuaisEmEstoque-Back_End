package com.example.demo.Repositorys;

import com.example.demo.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
    Optional<Car> findByChassi(String chassi);
    List<Car> findByStatus(Boolean status);
}
