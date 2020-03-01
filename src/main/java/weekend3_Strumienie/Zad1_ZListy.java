package weekend3_Strumienie;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 29.02.2020
 */
final class Zad1_ZListy {
    public static void main(String[] args) {
        List<String> list = List.of("Ala", "Kamil", "Dagmara", "Patryk");

        System.out.println(pierwszeLitery(list));

        String s = "Dagmara";
        System.out.println(listaLiter(s));

    }

    static List<Character> pierwszeLitery(List<String> imiona) {
        return imiona.stream()
                .map(e -> e.charAt(0))
                .collect(Collectors.toList());

    }

    static List<Character> listaLiter(String s) {
        char[] tab = s.toCharArray();
        Stream<Character> charStream = s.chars().mapToObj(i -> (char) i);
        // IntStream stream = CharBuffer.wrap(list).chars();
        return charStream.collect(Collectors.toList());
    }
}
