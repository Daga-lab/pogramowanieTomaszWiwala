package weekend3_Strumienie;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 01.03.2020
 */
final class Zad3_LosoweLiczby {
    public static void main(String[] args) {
        System.out.println(generatorLiczbLosowych());
    }
    static List<Double> generatorLiczbLosowych (){
         List<Double> a = Stream.generate(()-> Math.random()*10)
                 .limit(100)
                 .collect(Collectors.toList());
        return a;
    }
}
