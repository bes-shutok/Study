/*
* Given a linked list, determine if it has a cycle in it.
* To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
* in the linked list where the tail connects to. If pos == -1, then there is no cycle in the linked list.
* 
* */

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args) {
        HashSet<String> stringNumbers = new HashSet<>();
        stringNumbers.add("5");
        stringNumbers.add("5.0");
        System.out.println(String.join(",",stringNumbers));
        TreeSet<BigDecimal> numbers = stringNumbers.stream().map(s -> new BigDecimal(s)).collect(
                Collectors.toCollection(
                        () -> new TreeSet<>())
        );
        System.out.println(numbers.toString());
        BigDecimal five = new BigDecimal(5);
        BigDecimal fiveDot = new BigDecimal(5.0);
        System.out.println(five.compareTo(fiveDot));

    }
}
