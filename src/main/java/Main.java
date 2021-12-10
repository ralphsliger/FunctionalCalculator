import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        BiFunction<Integer,Integer,Integer> addition = (a, b) -> a + b;

        BiFunction<Integer,Integer,Integer> subtract = (a, b) -> a - b;

        BiFunction<Integer, Integer, Integer> multiply = (a, b) ->
                IntStream.range(0, b + 1)
                        .reduce((accu, number)-> addition.apply(accu, a))
                        .getAsInt();

        BiFunction<Integer, Integer, Integer> division = (a, b) -> {

            if(b.equals(0)){
                throw new IllegalArgumentException("undefined");
            }
            return IntStream.range(0, a)
                    .reduce((accu, number) -> multiply.apply(number, b) <= a ? addition.apply(accu, 1) : accu)
                    .orElse(0);
        };


        System.out.println("Addition: " + addition.apply(3,3));
        System.out.println("Subtract: " + subtract.apply(3,3));
        System.out.println("Multiply: " + multiply.apply(3,3));
        System.out.println("Division: " + division.apply(12,6));


    }

}
