package weekend2_Rekurencja;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 23.02.2020
 */
final class Zad2_Fibbonacci {

    public static void main(String[] args) {
        System.out.println(fibbonacciRek(5));
        System.out.println(fibbonacciRek(9));
    }
    public static int fibbonacciRek(int n){     // uwaga - Efekt niekonczacej sie rekurencji
        if (n == 1 || n == 2){                  // StackOverFlowError
            return 1;                           // zapchamy sobie stertę
        }
        return fibbonacciRek(n-1)+ fibbonacciRek(n-2);
    }
}
