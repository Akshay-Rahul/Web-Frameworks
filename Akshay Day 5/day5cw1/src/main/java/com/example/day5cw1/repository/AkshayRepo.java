package com.example.day5cw1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day5cw1.model.AkshayProduct;

@Repository
public interface AkshayRepo extends JpaRepository<AkshayProduct,Integer>{
    
}
