@FunctionalInterface
interface greaterNumber{
    boolean returnGreater(int a, int b);
}

@FunctionalInterface
interface incrementOne{
    int increment(int a);
}

@FunctionalInterface
interface concatString{
    String concat(String a, String b);
}

@FunctionalInterface
interface stringUpperCase{
    String convertUpper(String a);
}

public class Question1 {
    public static void main(String[] args) {
        greaterNumber test1 = (int a,int b) -> {
            if(a >b){
                return true;
            }else {
                return false;
            }
        };

        incrementOne test2 = (int a) -> {
            return a + 1;
        };

        concatString test3 = (String a, String b) -> {
            return (a + b);
        };

        stringUpperCase test4 = (String a) ->{
            return a.toUpperCase();
        };

        System.out.println(test1.returnGreater(17,8));
        System.out.println(test2.increment(17));
        System.out.println(test3.concat("Peter","Parker"));
        System.out.println(test4.convertUpper("wordcomposedofsmallletters"));


    }
}

