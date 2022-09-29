import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Employee implements Comparable<Employee>{
    double age;
    double salary;
    String name;

    public double getSalary(){
        return salary;
    }

    public String getName(){
        return name;
    }


    // to sort by name
    @Override
    public int compareTo(Employee Emp) {
        return this.name.compareTo(Emp.getName());
    }

    Employee(double age, double salary, String name){
        this.age = age;
        this.salary = salary;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name +", " + this.salary;
    }
}


public class Q2 {
    public static void main(String[] args){
        Employee Emp1 = new Employee(32,5000,"Bruce Wayne");
        Employee Emp2 = new Employee(44, 10000,"Peter Parker");
        Employee Emp3 = new Employee(22,3000, "Peter Pan");

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(Emp1);
        employees.add(Emp2);
        employees.add(Emp3);


        System.out.println("Default sorting: ");
        System.out.println(employees);

        // to sort based on salary

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                 return ((int)(e1.getSalary()-e2.getSalary()));
                }
        });
        System.out.println("Sorted by salary : ");
        System.out.println(employees);
    }
}
