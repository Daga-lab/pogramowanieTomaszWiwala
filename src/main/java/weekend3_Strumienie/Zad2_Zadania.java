package weekend3_Strumienie;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 29.02.2020
 */

//22. Utwórz metodę która przyjmuje listę liczb, a następnie zwraca listę liczb parzystych
//23.  Utwórz metodę która przyjmuje listę liczb, a następie sortuje je rosnąco (metoda sorted() na strumieniu)
//24. Utwórz metodę która przyjmuje listę liczb,
// a następnie zwraca listę liczb, w której są pierwiastki tych liczb,
// pamiętaj że nie liczymy pierwiastka z liczby ujemnej! Dla listy [2, 4, 16], zwróc [1.41, 2, 4]
//25. Utwórz metodę która przyjmuje Stringa który jest zdaniem.
// Zwróć z metody Liste słów które zaczynają się od samogłoski. // Dla Ala ma kota, zwróć [„Ala"]
final class Zad2_Zadania {
    public static void main(String[] args) {
        List<Integer> list = List.of(2,4,3,5,6,8,1,9);
        System.out.println(parzyste(list));

        System.out.println(sortowanieRosnaco(list));

        System.out.println(zwrotPierwiastkow(list));

        String s = "Ala ma kota";
        System.out.println(zwrotZaczynajacychSieOdSamogloski(s));

    }
    static List<Integer> parzyste(List<Integer> liczby) {
        return liczby.stream()
                .filter(e -> e%2 == 0)
                .collect(Collectors.toList());

    }
    static  List<Integer> sortowanieRosnaco (List<Integer> liczby){
        return  liczby.stream()
                .sorted()
                .collect(Collectors.toList());
    }
    static  List<Double> zwrotPierwiastkow (List<Integer> liczby){
        return  liczby.stream()
                .map(e -> Math.sqrt(e))
                .collect(Collectors.toList());
    }
    static List<String> zwrotZaczynajacychSieOdSamogloski (String s){
        Stream<String> stringStream = Stream.of(s.split(" "));
        return stringStream
                .filter(e -> e.matches("^[AEIOUYaeiouy].*"))
                .collect(Collectors.toList());
    }

}


