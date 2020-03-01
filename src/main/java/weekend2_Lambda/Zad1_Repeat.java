package weekend2_Lambda;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 23.02.2020
 */
final class Zad1_Repeat {
    private static void repeat(int n, Runnable runnable) {
        for (int i = 0; i < n; i++) {
            runnable.run();
        }
    }

    public static void main(String[] args) {
        repeat(5, () -> System.out.println("Hello"));
    }
}

interface Usage {
    void usage();
}
