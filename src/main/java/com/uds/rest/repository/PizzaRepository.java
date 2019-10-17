package com.uds.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uds.rest.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Integer>{

}
