import java.util.Scanner;

class Circle {
    public static final double PI = 3.14;
    public static int radius;
    public static double area,circumference;
    public static Scanner scan = new Scanner(System.in);
    public static void calcArea(){
        System.out.println("Enter the radius of the circle: ");
        radius = scan.nextInt();
        area = PI * radius * radius;
        System.out.println("Area of the circle is : "+ area);
    }
    public static void calcCircumference(){
        System.out.println("Enter the radius of the circle: ");
        radius = scan.nextInt();
        circumference = PI * 2 * radius;
        System.out.println("Circumference of the circle is : "+ circumference);
    }
}

public class Q3 {
    public static void main(String[] args) {

        System.out.println("---------MENU----------");
        System.out.println("1. Calculate Area of Circle");
        System.out.println("2. Calculate Circumference of a Circle");
        System.out.println("3. Exit.");
        System.out.println("Choose an option between 1-3: ");
        int choice = Circle.scan.nextInt();
        switch (choice) {
            case 1:
                Circle.calcArea();
                break;
            case 2:
                Circle.calcCircumference();
                break;
            case 3:
                break;

        }
    }
}

