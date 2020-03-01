package weekend3_PorzadkowanieHashMapyiLambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 29.02.2020
 */
final class Zad4_LambdaCwiczenie {
    public static void main(String[] args) {
        String[] tab = {"Daga", "Kamil", "Jarek"};
        Arrays.sort(tab, compareInDirection(true));    //tworzymy klasę wewnętrzną
        System.out.println(Arrays.toString(tab));
    }

    public static Comparator<String> compareInDirection(boolean asc) {

        return asc ?
                (s, t1) -> s.compareTo(t1) : (s, t1) -> s.compareTo(t1) * (-1);
        // lub return (s, t1) -> s.compareTo(t1) * (asc ? 1: (-1));
    }
}
