

public class Q5 {
    private String firstName;
    private String lastName;
    private int age;

    Q5(){
        firstName = "John";
        lastName = "Doe";
        age = 40;
        System.out.println("No-args Constructor called!");
        System.out.println("Info: " + firstName + " " + lastName + "," + age);
    }
    Q5(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        System.out.println("Parameterized Constructor called!");
        System.out.println("Info: " + firstName + " " + lastName + "," + age);
    }

    //setter
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setAge(int age){
        this.age = age;
    }

    //getter
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getAge(){
        return age;
    }

    //overriding toString
    @Override
    public String toString(){
        return firstName+" "+lastName+", "+age;
    }

    public static void main(String[] args){
        Q5 Emp1 = new Q5();
        Q5 Emp2 = new Q5("Joice","Joseph",23);
        Emp1.setFirstName("Bruce");
        Emp1.setLastName("Wayne");
        Emp1.setAge(35);
        System.out.println("\n\nUpdated Info (using setter) emp1: " + Emp1.getFirstName()+ " " + Emp1.getLastName() + "," + Emp1.getAge());

        System.out.println("\n\nChecking to see if toString overriding is working.");
        System.out.println(Emp1);
        System.out.println(Emp2);

    }
}
