package com.uds.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uds.rest.model.Sabor;

@Repository
public interface SaborRepository extends JpaRepository<Sabor, Integer>{

}
