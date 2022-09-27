import java.util.Scanner;

public class Q2 {
    public static void  main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Provide Input:");
            String userInput = sc.nextLine();
            if("XDONE".equalsIgnoreCase(userInput)){
                break;
            } else {
                System.out.println("User Input: " + userInput);
            }
        }
    }
}
