package com.valderosh.carrent.repository;

import com.valderosh.carrent.models.Cars;
import com.valderosh.carrent.models.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface PricesRepository extends JpaRepository<Prices, Long> {
    Cars findByCarModel(String car_model);
}
