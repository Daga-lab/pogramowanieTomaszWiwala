package weekend2_Rekurencja;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 23.02.2020
 */
final class Zad1_Silnia {

    public static void main(String[] args) {
        System.out.println("SilniaIt: " + silniaIT(5));
        System.out.println("SilniaRek: " + silniaRek(5));
    }

    public static int silniaIT(int n) {
        int wynik = 1;
        for (int i = 2; i <= n; i++) {
            wynik *= i;
        }
        return wynik;
    }

    public static int silniaRek(int n){
        if (n==0){
            return 1;
        }
        else
        return n*silniaRek(n-1);
    }
}
