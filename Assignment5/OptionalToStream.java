import java.util.Optional;

public class OptionalToStream {
    public static void main(String[] args) {
        //creating an instance of optional
        Optional<String> optStr = Optional.of("RandomText");

        optStr.stream().forEach(System.out::println);

    }
}
