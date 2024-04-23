package com.example.relation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.relation.model.StudentInfo;

@Repository
public interface AkshayStudentInfoRepository extends JpaRepository<StudentInfo,Integer>{
    
}