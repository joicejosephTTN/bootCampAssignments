package com.ttn.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDAOService service;

    public EmployeeController(EmployeeDAOService service) {
        this.service = service;
    }


    // Retrieve list of all employees
    @GetMapping(path = "/api/emp")
    public List<Employee> retrieveAll() {
        return service.findAll();
    }

    // Retrieve a particular user via id
    @GetMapping(path = "/api/emp/{id}")
    public Employee retrieveEmployee(@PathVariable int id) {
        Employee emp = service.findOne(id);

        if(emp == null){
            throw new EmployeeNotFoundException("Could not find employee " + id);
        }

        return emp;
    }

    // To add a new employee
    @PostMapping(path = "/api/emp/add")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee emp){
        Employee newEmployee = service.createEmployee(emp);

        //returning the URI of the newly added Employee
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newEmployee.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    // to remove an employee via id
    @DeleteMapping(path="/api/emp/remove/{id}")
    public void removeEmployee(@PathVariable int id){
        service.deleteEmployee(id);
    }


    // to update an employee via id
    @PutMapping(path="/api/emp/update/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee emp){
        return service.updateEmployee(id, emp);
    }

}
