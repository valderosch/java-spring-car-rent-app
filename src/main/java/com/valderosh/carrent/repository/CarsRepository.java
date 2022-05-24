package com.valderosh.carrent.repository;

import com.valderosh.carrent.models.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CarsRepository  extends JpaRepository<Cars, Long> {

   // List<Cars> findByCarModel(String car_model);
}
