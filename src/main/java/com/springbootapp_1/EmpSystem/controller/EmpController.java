package com.springbootapp_1.EmpSystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springbootapp_1.EmpSystem.entity.Employee;
import com.springbootapp_1.EmpSystem.service.EmpService;


@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@GetMapping("/")
	public String home(Model m) {
		List<Employee>  emp=empService.getAllEmp();
		m.addAttribute("emp", emp);
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmpForm() {
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session) {
		empService.addEmp(e);
		session.setAttribute("msg", "New Employee added sucessfully");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee e=empService.getEmpById(id);
		m.addAttribute("emp", e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee employee,HttpSession session) {
//		   Employee existingEmp=empService.getEmpById(id);
//		   existingEmp.setName(employee.getName());
//		   existingEmp.setAddress(employee.getAddress());
//		   existingEmp.setEmail(employee.getEmail());
//		   existingEmp.setPhone(employee.getPhone());
//		   existingEmp.setSalary(employee.getSalary());
//		empService.addEmp(existingEmp);
		empService.addEmp(employee);
		session.setAttribute("msg", "Employee data updated successfully");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id,HttpSession session) {
		empService.deleteById(id);
		session.setAttribute("msg", "Employee deleted successfully");
		return "redirect:/";
	}
}
