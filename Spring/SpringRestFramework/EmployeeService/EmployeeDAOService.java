package com.ttn.EmployeeService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDAOService {

    //using list as a dummy DB
    private static List<Employee> employeeList = new ArrayList<>();

    // using counter as a substitute for auto-incrementing id;
    private static int counter = 0;

    //populating the list
    static {
        employeeList.add(new Employee(++counter,"ABC",20));
        employeeList.add(new Employee(++counter,"DEF",23));
        employeeList.add(new Employee(++counter,"XYZ",22));
        employeeList.add(new Employee(++counter,"LMN",27));
        employeeList.add(new Employee(++counter,"QPR",21));
    }

    // to retrieve a single employee
    public Employee findOne(int id){

        return employeeList.stream().filter(e->e.getId() == id).findFirst().orElse(null);
    }


    // to retrieve all employees
    public List<Employee> findAll(){
        return employeeList;
    }


    // to add a new employee
    public Employee createEmployee(Employee emp){
        //incrementing the counter on creation
        emp.setId(++counter);
        employeeList.add(emp);
        // returning emp, to see details of the newly added employee
        return emp;
    }


    // to delete an employee
    public void deleteEmployee(int id){
        employeeList.removeIf(e->e.getId()==id);
    }


    // to update employee details
    public Employee updateEmployee(int id, Employee requestEmp){
        Employee emp = findOne(id);
        emp.setAge(requestEmp.getAge());
        emp.setName(requestEmp.getName());
        return emp;
    }

}
