package com.example.SpringHibernate;

import com.example.SpringHibernate.entities.*;
import com.example.SpringHibernate.repos.DeveloperRepository;
import com.example.SpringHibernate.repos.EmpRepository;
import com.example.SpringHibernate.repos.EmployeeRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringHibernateApplicationTests {

	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	DeveloperRepository devRepo;

	@Autowired
	EmpRepository salRepo;

	@Test
	void contextLoads() {
	}

	// SPRING HIBERNATE PT.2

	// JPQL, Native SQL

	@Test
	public void testCreate() {
		Employee employee = new Employee();
		employee.setId(5);
		employee.setFirstName("Robert");
		employee.setLastName("Batra");
		employee.setAge(29);
		employee.setSalary(4000);

		empRepo.save(employee);
	}

	@Test
	public void testFilterEmployee() {

		List<Object[]> reqdData = empRepo.filterEmployeeByAge();
			for (Object[] objects : reqdData) {
				System.out.println(objects[0] + " " + objects[1]);
			}
	}


	@Test
	public void testFindEmployeeSingh(){
		List<Object[]> reqdData = empRepo.findEmployeeSingh();
		for (Object[] objects : reqdData) {
			System.out.println(objects[0] + " " + objects[1]);
		}
	}


	@Test
	public void testDeleteEmployee(){
		empRepo.deleteEmployee(46);
	}


	// Inheritance Mapping

	// testing SINGLE_TABLE
	// stores all records in a single table
	@Test
	public void createDeveloper(){
		PartTime dev1 = new PartTime();
		FullTime dev2 = new FullTime();

		dev1.setName("Mark");
		dev1.setHourlyRate(100);

		dev2.setName("Colson");
		dev2.setSalary(100000);

		devRepo.save(dev1);
		devRepo.save(dev2);

	}

	// testing TABLE_PER_CLASS
	// stores records in different tables for each entity, uses UNION under the hood when we perform query
	// on parent entity
	@Test
	public void createDeveloperPerTable(){
		PartTime dev1 = new PartTime();
		FullTime dev2 = new FullTime();

		dev1.setName("Henry");
		dev1.setHourlyRate(80);

		dev2.setName("Liam");
		dev2.setSalary(150000);

		devRepo.save(dev1);
		devRepo.save(dev2);

	}

	// testing JOINED
	// stores records in different tables for each entity, id column (or any identifier that you set)
	// is repeated in each table, which is used for joining.
	// uses JOIN when we retrieve entities.
	@Test
	public void createDeveloperJoined(){
		PartTime dev1 = new PartTime();
		FullTime dev2 = new FullTime();

		dev1.setName("Denji");
		dev1.setHourlyRate(150);

		dev2.setName("Makima");
		dev2.setSalary(200000);

		devRepo.save(dev1);
		devRepo.save(dev2);

	}

    // testing content mapping
	
	@Test
	public void testCreateEmployee_ContentMapping()
	{
		Emp employee=new Emp();
		employee.setId(100);
		employee.setFirstName("Don");
		employee.setLastName("Draper");
		employee.setAge(45);
		Salary salary=new Salary();
		salary.setBasicSalary(100000.00);
		salary.setBonusSalary(50000.00);
		salary.setTaxAmount(25000.00);
		salary.setSpecialAllowanceSalary(10000.00);
		employee.setSalary(salary);
		salRepo.save(employee);
	}

}
