package DSA.src;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String name= "hey this is first java program";
       Map m = Arrays.asList(name.split("")).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    System.out.println(m);
    }
}