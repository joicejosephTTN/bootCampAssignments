package com.ttn.AssignmentJPA;

import com.ttn.AssignmentJPA.entities.Employee;
import com.ttn.AssignmentJPA.repos.EmployeeRepository;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.awt.print.Pageable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
class AssignmentJpaApplicationTests {

	@Autowired
	EmployeeRepository empRepo;

	@Test
	void contextLoads() {
	}


	@Test
	public void testCreate(){
		Employee employee = new Employee();
		employee.setId(3);
		employee.setName("Alisa");
		employee.setAge(21);
		employee.setLocation("Edinburgh");

		empRepo.save(employee);

	}

	@Test
	public void testUpdate(){
		Employee employee = empRepo.findById(2).get();
		employee.setLocation("Noida");
		empRepo.save(employee);
	}

	@Test
	public void testDelete(){
		empRepo.deleteById(1);
	}

	@Test
	public void testRead(){
		Employee employee = empRepo.findById(2).get();
		assertNotNull(employee);
	}

	@Test
	public void testCount(){
		long numEmp = empRepo.count();
		System.out.println("num>>>>>>>>>>>>>>>>>>"+ numEmp);
		assertEquals(3,numEmp);
	}

	@Test
	public void testFindAll_PagingSorting(){
		PageRequest pageable =  PageRequest.of(0, 5, Sort.Direction.DESC,"age");
		empRepo.findAll(pageable).forEach(p->System.out.println(p));
	}

	@Test
	public void testFindByName(){
		List<Employee> emp = empRepo.findByName("Tarun");
		assertNotNull(emp);

	}

	@Test
	public void testFindByNameLike(){
		List<Employee> emp = empRepo.findByNameLike("A%");
		System.out.println("Emp>>>>>>>>>>>"+ emp);
		assertNotNull(emp);
	}

	@Test
	public void testFindByAgeBetween(){
		List<Employee> emp = empRepo.findByAgeBetween(19,22);
		System.out.println("Emp>>>>>>>>>>>"+ emp);
		assertNotNull(emp);
	}


}
