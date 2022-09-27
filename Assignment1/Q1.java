class Person {
    int empCode;
    public static String firstName = "Joice";
    public static String lastName = "Joseph";
    public static byte age = 23;

    static {
        // static block is called automatically as class is loaded into memory
        System.out.println("Printed using static block: "+ firstName);
    }
    //for learning purpose
    public void showInfo(int empCode){
        // can access instance variable and static variables
        System.out.println("\n\nPrinted using Instance Method:");
        System.out.println("Employee Code: " + empCode);
        System.out.println("Info: " + firstName + " "+ lastName + "," + age);
    }

    public static void showLastName(){
        System.out.println("Printed using static method: "+ lastName);
        // cannot access non-static variables
        // non-static methods can access both static and non-static variables/methods
        //Static method can be called in another static method
        //You need to have object to call this non-static method
        // Eg: object.someFunc()
    }
}

public class Q1 {

    public static void  main(String[] args){
        Person.showLastName();
        System.out.println("Printed using static variable: " + Person.age);

        Person P1 = new Person();
        P1.showInfo(6587);

    }
}
