package weekend3_PorzadkowanieHashMapyiLambda;

import weekend2_Lambda.IntSequence;
import java.util.Random;


/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 29.02.2020
 */
final class Zad5_Sequence {
    public static void main(String[] args) {
        IntSequence intSequence = randomInts(0, 10);
        System.out.println("intSequence.next() = " + intSequence.next());
        System.out.println("intSequence.next() = " + intSequence.next());
        System.out.println("intSequence.next() = " + intSequence.next());
        System.out.println("intSequence.next() = " + intSequence.next());
        System.out.println("intSequence.next() = " + intSequence.next());
    }

    //klasa lokalna
    public static IntSequence randomInts(int min, int max) {
        class RandomInts implements IntSequence {
            Random random = new Random();

            @Override
            public int next() {
                // zwraca <o; 11)
                // min -5
                // max 10
                return random.nextInt(max + 1) + min;
            }

            public boolean hasNext() {
                return true;
            }
        }
        return new RandomInts();
    }

    //anonimowa klasa lokalna
    public static IntSequence randomInts2(int min, int max) {
        return new IntSequence() {
            Random random = new Random();

            @Override
            public int next() {
                return random.nextInt(max + 1) + min;
            }

            public boolean hasNext() {
                return true;
            }

        };

    }

    // Lambda
    public static IntSequence randomInts3(int min, int max) {
        Random random = new Random();
        return () -> random.nextInt(max + 1) + min;
    }
}




