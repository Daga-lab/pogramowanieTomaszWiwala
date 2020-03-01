package weekend2_Lambda;

import lombok.ToString;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 23.02.2020
 */
//Zadanie 1
//1.Stwórz interfejs IntSequence zawierający dwie metody:
//a.hasNext() – zwraca boolean (defaultowo zwraca true)
//b.next() – zwraca int
//2.Wszystkie poniższe klasy mają implementować IntSequence
//3.Stwórz klasę PrimeSequence która z każdym wywołaniem metoda next(),
// będzie zwracała kolejne liczby pierwsze, mniejsze od 2000
//a.jeżeli metoda next zwróci ostatnią liczbę pierwszą < 2000, metoda hasNext() powinna zwracać fałsz

//4.Stwórz klasę SquareSequence która wraz z każdym wywołaniem metody next()
// zwraca kolejne kwadraty liczb dodatnich -> 1,4,9,16, …
//5.Stwórz klasę DigitSequence która wraz z każdym wywołaniem metody next()
// zwraca kolejne cyfry liczby (od końca) przekazanej jako konstruktor
//Np. DigitSequence(1236) -> 6, 3, 2, 1
//6.W klasie Main, stwórz metodę statyczną average przyjmującą parametry
//a.Jedną z powyższych klas (chcemy aby ta jedna metoda miała możliwość załadowania
// jako argumentu jednej z powyższych klas – zastanów się jak napisać taką uniwersalną metodę)
//b.Int n
//Jej zadaniem jest policzenie średniej z liczb dopóki:
// Ilość liczb branych pod uwagę jest mniejsza od n lub metoda hasNext() zwróci fałsz
//Np. dla DigitSequence(1236) i parametru n = 4, funkcja powinna zwracać 3
//Dla DigitSequence(1236) i parametru n = 3, funkcja powinna zwracać 3,66
//Dla DigitSequence(1236) i parametru n = 5, funkcja powinna zwracać 3
//Dla SquareSequence () i parametru n=4, funkcja powinna zwracać 7.5 - (1+4+9+16)/4
//Przetestuj wszystkie klasy, sprawdź czy Twoja funkcja jest oporna na błędy :blush: - nie chodzi o testy jednostkowe, tylko zwyczajnie w „mainie”
final class Zad4_Zadanko {
    static void main(String[] args) {
//measurePrimes(1_000);
//        measurePrimes(10_000);
//        measurePrimes(100_000);
//        measurePrimes(1_000_000);


        PrimeSequence primeSequence = new PrimeSequence();
        System.out.println("Primesequence.next: " + primeSequence.next());
        System.out.println("Primesequence.next: " + primeSequence.next());
        System.out.println("Primesequence.next: " + primeSequence.next());


        SquareSequence squareSentence = new SquareSequence();
        System.out.println("Squaresentence.next: " + squareSentence.next());
        System.out.println("Squaresentence.next: " + squareSentence.next());
        System.out.println("Squaresentence.next: " + squareSentence.next());
    }
}

//  private static void measurePrimes(int maxVal) {
//        long l1 = System.currentTimeMillis();
//        int[] ints = IntStream.rangeClosed(1, maxVal)
//                .filter(e -> PrimeSequence.isPrime(e))
//                .toArray();
//        long l2 = System.currentTimeMillis();
//        System.out.println(maxVal + " trwalo " + (l2 - l1) + "ms znaleziono " + ints.length + " liczb pierwszych.");
//    }

@ToString
class DigitSequence implements IntSequence {

    private int val;

    public DigitSequence(int val) {
        this.val = val;
    }

    @Override
    public int next() {
        int i = val %10;
        val = val/10;
        return i;
    }

    public boolean hasNext() {
        return val != 0;
    }
}

class PrimeSequence implements IntSequence {

    private int currentPrime = 0;
    private static int MAX_PRIME = 2000;

    private static boolean isPrime(int v) {
        if (v == 1) {
            return false;
        }
        if (v == 2) {
            return true;
        }
        if (v % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= v; i += 2) {
            if (v % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean hasNext() {
        int tmp = currentPrime+1;
        while(!isPrime(tmp)){
            tmp++;
        }
        if(tmp > MAX_PRIME){
            return false;
        }
        return true;
    }

    @Override
    public int next() {
        currentPrime++;
        while (!isPrime(currentPrime)){
            currentPrime++;
        }
        if (currentPrime > MAX_PRIME){
            throw new IllegalArgumentException("Prime > " + MAX_PRIME);
        }
        return currentPrime;
    }
}

class SquareSequence implements IntSequence {

    private int currentSquare = 0;


    @Override
    public int next() {
        currentSquare++;
        return ((int) Math.pow(currentSquare, 2));
    }
}

public interface IntSequence {

    private boolean hasNext() {
        return true;
    }


    int next();

}
