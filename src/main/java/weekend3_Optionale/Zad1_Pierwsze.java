package weekend3_Optionale;

import java.util.Optional;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 01.03.2020
 */
final class Zad1_Pierwsze {
    public static void main(String[] args) {
        Optional<Double> a = Optional.ofNullable(null);
        a.ifPresentOrElse((e) -> System.out.println(1/e), ()-> System.out.println(a));
    }
}
