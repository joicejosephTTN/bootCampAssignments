import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q1 {
    public static void main(String[] args){
        List<Float> numbers = new ArrayList<Float>();
        float sumOfNum = 0;


        numbers.add(4.5f);
        numbers.add(6.22f);
        numbers.add(431.231f);
        numbers.add(73.2f);
        numbers.add(645.3415f);

        Iterator<Float> it = numbers.iterator();

        while(it.hasNext()){
            sumOfNum += it.next();

        }
        System.out.println("Sum of the numbers is: "+ sumOfNum);


    }
}
