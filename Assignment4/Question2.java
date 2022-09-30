class mathOperations{
    public static int add(int a,int b){
        return a + b;
    };
    public static int subtract(int c, int d){
        return c - d;
    };
    public int multiply(int x,int y){
        return x * y;
    };
}

interface numberMultiplication{
    int operation(int x, int y);
}

public class Question2 {
    public static void main(String[] args) {
        numberMultiplication test1 = mathOperations::add;
        numberMultiplication test2 = mathOperations::subtract;
        numberMultiplication test3 = new mathOperations()::multiply;
        System.out.println("Adding Numbers: "+ test1.operation(1,2));
        System.out.println("Subtracting Numbers: "+test2.operation(7,1));
        System.out.println("Multiplying Numbers: "+ test3.operation(5,6));
    }
}

