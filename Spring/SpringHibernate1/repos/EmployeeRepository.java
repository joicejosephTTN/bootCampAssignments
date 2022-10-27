package com.ttn.AssignmentJPA.repos;

import com.ttn.AssignmentJPA.entities.Employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;


// Entity
// Repository
// Configure Data Source

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

    List<Employee> findByName(String name);
    List<Employee> findByNameLike(String name);
    List<Employee> findByAgeBetween(Integer start, Integer end);

}