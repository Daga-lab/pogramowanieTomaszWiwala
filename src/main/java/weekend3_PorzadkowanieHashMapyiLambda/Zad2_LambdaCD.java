package weekend3_PorzadkowanieHashMapyiLambda;

import java.util.function.IntConsumer;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 29.02.2020
 */
final class Zad2_LambdaCD {
    public static void main(String[] args) {
        repeat(5, (i) -> System.out.println("Hello" + i));
    }
    private static void repeat (int n, IntConsumer o){
        for (int j = 0; j <n ; j++) {
            o.accept(j);
        }
    }
}
/*
@FunctionalInterface
interface IntExecutor{
    void execute(int i);
} */
