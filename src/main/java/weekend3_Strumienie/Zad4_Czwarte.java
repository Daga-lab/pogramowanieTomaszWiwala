package weekend3_Strumienie;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 01.03.2020
 */
//27. Utwórz metodę która przyjmuje listę liczb i zwraca tą samą listę liczb tylko, że każda liczba jest
// podniesiona do kwadratu i dodana jest 1.
final class Zad4_Czwarte {
    public static void main(String[] args) {
        List<Double> liczby = List.of(2.0,3.0,5.0,6.0,7.0,3.0);
        System.out.println(doKwadratu(liczby));
    }
    public static List<Double> doKwadratu(List<Double> liczby){
        return liczby.stream()
                .map((e)-> Math.pow(e, 2) +1)
                .collect(Collectors.toList());
    }
}
