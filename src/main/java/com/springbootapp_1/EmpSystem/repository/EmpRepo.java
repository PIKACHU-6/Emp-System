package com.springbootapp_1.EmpSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootapp_1.EmpSystem.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
