import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee{
    String fullName;
    Long salary;
    String city;

    public Employee(String fullName, Long salary, String city){
        this.fullName = fullName;
        this.salary = salary;
        this.city = city;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFirstName(){
        return getFullName().split(" ")[0];
    }

    public Long getSalary() {
        return salary;
    }

    public String getCity() {
        return city;
    }

}

public class Question4 {
    public static void main(String[] args) {

        System.out.println("all even numbers from a list using stream");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result =
                numbers.stream()
                .filter(value -> value % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(result+ "\n\n");



        List<Employee> empList = new ArrayList<Employee>();

        empList.add(new Employee("Peter Parker",4000L,"Delhi"));
        empList.add(new Employee("Peter Pan",1000L,"Delhi"));
        empList.add(new Employee("Bruce Wayne",1000L,"Delhi"));
        empList.add(new Employee("Tony Stark",9000L,"Bangalore"));
        empList.add(new Employee("Andrew Schulz",3000L,"Delhi"));

        System.out.println("Unique firstName with Sal <5000 from Delhi: ");


        empList.stream()
                .filter(e->e.getCity().equalsIgnoreCase("Delhi"))
                .filter(e->e.getSalary() < 5000)
                .map(Employee::getFirstName)
                .distinct()
                .forEach(System.out::println);

    }
}
