import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class ifPresentOrElse {
    public static void main(String[] args) throws Exception {


        //ifPresentOrElse
        Optional<Integer> op
                = Optional.empty();

        op.ifPresentOrElse(
                (e)-> System.out.println("Value present"), //consumer
                ()-> System.out.println("Value not found") // runnable
        );

        // or
        //firstOptional.or(() -> secondOptional);
        Optional<Integer> optionalInteger = Arrays.asList(1,2,3,4,5,6,7,8)
                .stream()
                .filter(e->e>50)
                .findFirst()//first optional
                .or(()-> Optional.of(-1)); // second optional
        System.out.println(optionalInteger.get());



        String text = "password";
        String text2 = "";
        Optional<String> textOptional = Optional.of(text);
        Optional<String> textOptional2 = Optional.of(text2);

        int len = textOptional2
                .map(String::length)
                .orElseThrow(()-> {
                    return new Exception("no value present in Optional object");
                });

        System.out.println(len);
    }
}
