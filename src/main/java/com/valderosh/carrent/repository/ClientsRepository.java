package com.valderosh.carrent.repository;

import com.valderosh.carrent.models.Clients;
import org.springframework.data.repository.CrudRepository;

public interface ClientsRepository extends CrudRepository<Clients, Long> {
}
