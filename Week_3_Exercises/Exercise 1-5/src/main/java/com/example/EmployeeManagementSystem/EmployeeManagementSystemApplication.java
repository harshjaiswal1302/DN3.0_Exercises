package com.example.EmployeeManagementSystem;

import com.example.EmployeeManagementSystem.entity.Department;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.repository.DepartmentRepository;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EmployeeManagementSystemApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(EmployeeManagementSystemApplication.class, args);

		// Get repositories from the application context
		EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
		DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);

		// Insert initial departments
		Department hr = new Department();
		hr.setName("HR");
		departmentRepository.save(hr);

		Department it = new Department();
		it.setName("IT");
		departmentRepository.save(it);

		Department finance = new Department();
		finance.setName("Finance");
		departmentRepository.save(finance);

		// Insert initial employees
		Employee john = new Employee();
		john.setName("John Doe");
		john.setEmail("john.doe@example.com");
		john.setDepartment(hr);
		employeeRepository.save(john);

		Employee jane = new Employee();
		jane.setName("Jane Smith");
		jane.setEmail("jane.smith@example.com");
		jane.setDepartment(it);
		employeeRepository.save(jane);

		Employee alice = new Employee();
		alice.setName("Alice Johnson");
		alice.setEmail("alice.johnson@example.com");
		alice.setDepartment(finance);
		employeeRepository.save(alice);
	}
}
