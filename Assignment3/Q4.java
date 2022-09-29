import java.util.HashMap;
import java.util.Objects;

class Employees{
    double age;
    String name;
    String designation;


    Employees(double age, String name, String designation){
        this.age = age;
        this.name = name;
        this.designation = designation;
    }

    public double getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

//
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return Double.compare(employees.age, age) == 0 && name.equals(employees.name) && designation.equals(employees.designation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, designation);
    }
}


public class Q4 {
    public static void main(String[] args){
        HashMap<Employees,Double> empSal =  new HashMap<>();

        Employees e1 =  new Employees(25,"PersonA","JVM");
        Employees e2 =  new Employees( 28,"PersonB","QE");
        Employees e3 =  new Employees(32,"PersonC" , "AMC");
        Employees e4 =  new Employees( 23,"PersonD","DEVOPS");

        empSal.put(e1,200000.0);
        empSal.put(e2,70000.0);
        empSal.put(e3,60000.0);
        empSal.put(e4,100000.0);
        empSal.put(e4,212222.0);

        System.out.println(empSal);



    }
}
