package weekend3_PorzadkowanieHashMapyiLambda;

import java.sql.SQLOutput;
import java.util.stream.IntStream;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 29.02.2020
 */
final class Zad1_Lambda {
    public static void main(String[] args) {
        Runnable[] tasks={
                ()-> System.out.println("Hello world!"),
                ()-> IntStream.rangeClosed(0,10).forEach(e-> System.out.println(e)),
                ()-> System.out.println("Motyle jestem")
        };
        runInOrder(tasks);
        runTogether(tasks);
    }
    public static void runTogether(Runnable...tasks){
        for (int i = 0; i < tasks.length; i++) {
            Thread t = new Thread(tasks[i]);
            t.start();
        }
    }
    public static void runInOrder(Runnable...tasks){
        for (int i = 0; i <tasks.length ; i++) {
            tasks[i].run();
        }
    }
}
