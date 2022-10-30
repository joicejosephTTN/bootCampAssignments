package com.example.SpringHibernate.repos;

import com.example.SpringHibernate.entities.Employee;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    // JPQL

    @Query(value = "select firstName,lastName from Employee where salary > (select avg(salary) from Employee) ORDER BY age ASC, salary DESC")
    List<Object[]> filterEmployeeByAge();

    // running into problems with update and delete questions in JPQL
    // apparently the question can't be solved using JPQL will have to use native SQL.

//    @Query(value = "update Employee e set e.salary = :salary where e.salary < (select avg(e.salary) from Employee e)")
//    List<Object[]> setEmployeeSalary(@Param("salary") int salary);


    // Native SQL Query

    @Query(value= "select emp_id, emp_first_name, emp_age from employee_table where emp_last_name = 'Singh' ", nativeQuery = true)
    List<Object[]> findEmployeeSingh();

    @Modifying
    @Transactional
    @Query(value="delete from employee_table e where e.emp_age >:age", nativeQuery = true)
    void deleteEmployee(@Param("age") int age);
}