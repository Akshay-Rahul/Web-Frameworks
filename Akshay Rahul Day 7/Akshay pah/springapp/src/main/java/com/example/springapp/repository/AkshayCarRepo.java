package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.Car;


@Repository
public interface AkshayCarRepo extends JpaRepository<Car,Integer>{

    Car findDistinctBycurrentOwnerNameAndAddress(String currentOwnerName, String address); 
}
