package com.springbootapp_1.EmpSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootapp_1.EmpSystem.entity.Employee;
import com.springbootapp_1.EmpSystem.repository.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo empRepo;
	
	public Employee addEmp(Employee e) {
		return empRepo.save(e);
	}
	
	public List<Employee> getAllEmp(){
		return empRepo.findAll();
	}
	
	public Employee getEmpById(int id) {
		return empRepo.findById(id).get();
	}
	
	public void deleteById(int id) {
		empRepo.deleteById(id);
	}
	
}
