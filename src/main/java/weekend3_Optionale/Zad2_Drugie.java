package weekend3_Optionale;

import java.util.Optional;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 01.03.2020
 */
final class Zad2_Drugie {
    public static void main(String[] args) {
        Optional<Double> x = pierwiastek(25.0);
        x.ifPresent((e) ->System.out.println(e));


    }

    public static Optional<Double> pierwiastek(double x) {
        if (x < 0) {
            return Optional.empty();
        } else
            return Optional.ofNullable(Math.sqrt(x));
    }
}
