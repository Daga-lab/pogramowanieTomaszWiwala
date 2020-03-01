package weekend2_Porownanie;

import lombok.Builder;
import lombok.Getter;

import java.util.*;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 23.02.2020
 */
//Stwórz arraylistę 5 pracowników
//    - Anna, 15
//    - Jan, 14
//    - Magda, 28
//    - Katarzyna, 20
//    - Robert, 19
//
// 1.
// Zaimplementuj interfejs comparable który sortuje domyślnie pracowników alfabetycznie, po imieniu.
// -> Posortuj pracowników alfabetycznie po imieniu, a następnie wypisz ich na ekran.
//
// 2.Posortuj pracowników rosnąco względem długości imienia i wypisz ich na ekran.
//
// 3. Posortuj pracowników rosnąco względem wieku i wypisz ich na ekran.
//
// Podpowiedź:
//    Collections.sort();
//    Comparator
//    Comparable

final class Zad3_Pracownicy {
    public static void main(String[] args) {
        ArrayList<Pracownik> workers = new ArrayList<>();
        workers.add(new Pracownik("Anna", 15));
        workers.add(new Pracownik("Katarzyna", 20));
        workers.add(new Pracownik("Jan", 14));
        workers.add(new Pracownik("Magda", 28));
        workers.add(new Pracownik("Robert", 19));

        System.out.println("Not sorted: " + workers);

        Collections.sort(workers);
        System.out.println("Sorted default: " + workers);

        Collections.sort(workers, new NameLenghtCoparator());
        System.out.println("Sorted by lenght: " + workers);

        Collections.sort(workers, new AgeComparator());
        System.out.println("Sorted by lenght: " + workers);

        Pracownik pracownik = new Pracownik("Anna", 15);
        Pracownik pracownik2 = new Pracownik("Jan", 14);
        Pracownik pracownik3 = new Pracownik("Magda", 28);
        Pracownik pracownik4 = new Pracownik("Katarzyna", 20);
        Pracownik pracownik5 = new Pracownik("Robert", 18);

        List<Pracownik> pracowniks = new ArrayList<>(Arrays.asList(pracownik,
                pracownik2,
                null,
                pracownik3,
                null,
                null,
                pracownik4,
                null,
                pracownik5));

        System.out.println(pracowniks);

        pracowniks.removeIf(praco ->(praco == null) );

        System.out.println(pracowniks);
    }
}

class NameLenghtCoparator implements Comparator<Pracownik> {

    @Override
    public int compare(Pracownik pracownik, Pracownik t1) {
        int a1 = pracownik.getName().length();
        int a2 = t1.getName().length();
        return (a1 - a2);
    }
}

class AgeComparator implements Comparator<Pracownik> {

    @Override
    public int compare(Pracownik pracownik, Pracownik t1) {
        int a1 = pracownik.getAge();
        int a2 = t1.getAge();
        return (a1 - a2);
    }
}

@Builder
@Getter
class Pracownik implements Comparable<Pracownik> {
    String name;
    int age;

    Pracownik(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Pracownik pracownik) {
        return this.getName().compareTo(pracownik.getName());
    }
}
