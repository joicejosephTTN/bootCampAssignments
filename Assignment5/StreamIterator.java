import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StreamIterator {
    public static void main(String[] args) {
        IntStream
                .iterate(0,i->i<=10,i->i+3)
                .forEach(System.out::println);
    }
}
