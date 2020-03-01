package weekend2_Regex;

import javafx.css.Match;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 22.02.2020
 */

//Zad 4.
// W pliku 5_wprowadzenie_TWiwala_zad4.txt, nasz klient prowadzi spis ludności.
//Ma w nim 10000 osób. Chciałby się dowiedzieć trochę informacji na temat osób które się tam wpisały.
//Zapis bazy wygląda:
//Imie:Nazwisko kod_pocztowy województwo email
//Np.
//Romuald:Lubicz 12-814 Malopolskie hvdxn@o2.pl
//Używając wyrażeń regularnych oraz pozostałych narzędzi Java, odpowiedz na poniższe pytania:
//1.Ile jest kobiet w jego spisie?
//2.Ile jest kobiet które mają na nazwisko: Lubicz?
//3.Ile jest osób z woj. Mazowieckiego?
//4.Ile osób w województwie Dolnośląskim ma skrzynkę w wp.pl?
//5.Ile osób ma kod pocztowy taki, że pierwsze dwie cyfry to 00, a dwie ostatnie to 99?
//  Np. 00-999?
//6. Wymień 3 województwa, w których jest najwięcej osób oraz liczbę tych osób.
//(Do zrobienia tego ćwiczenia, sugerowałbym wykorzystanie jakiejś kolekcji)

final class Zad4_SpisLudnosci {
    private static List<String> people;
    private static Pattern CORRECT_PERSON_REGEX = Pattern
            .compile("([a-zA-Z]+):([a-zA-Z]+) [0-9]{2}-[0-9]{3} ([a-zA-z]+) ([a-zA-z]+@[a-zA-z0-9]+\\.[a-zA-z]+)");
    private static Pattern WOMAN_NAME_REGEX = Pattern.compile("^.*a:.*");
    private static Pattern LUBICZ_SURNAME_REGEX = Pattern
            .compile("^.*a:Lubicz .*$");
    private static Pattern MAZOWIECKIE_ADDRESS_REGEX = Pattern
            .compile("^.*[0-9]{2}-[0-9]{3} Mazowieckie .*$");
    private static Pattern DOLNOSLASKIE_WP_REGEX = Pattern
            .compile("^.* [0-9]{1,2}-[0-9]{3} Dolnoslaskie .*@wp.pl");
    private static Pattern POSTCODE_REGEX = Pattern
            .compile("^.* 00-[0-9]99 .*$");
    private static Pattern STATE_PATTERN_REGEX = Pattern
            .compile("^.* [0-9]{1,2}-[0-9]{3} ([a-zA-Z-]+) .*$");

    public static void main(String[] args) {
        toList();
        zad1();
        zad2();
        zad3();
        zad4();
        zad5();
        Zad6();
    }

    private static void zad1() {
        final long count = people.stream().filter(WOMAN_NAME_REGEX.asPredicate()).count();
        System.out.println("Zad 1) Ilosc kobiet: " + count);
    }

    private static void zad2() {
        final long count = people.stream().filter(LUBICZ_SURNAME_REGEX.asPredicate()).count();
        System.out.println("Zad 2) Ilosc kobiet o nazwisku Lubicz: " + count);
    }

    private static void zad3() {
        final long count = people.stream().filter(MAZOWIECKIE_ADDRESS_REGEX.asPredicate()).count();
        System.out.println("Zad 3) Ilosc ludzi mieszkajacych w woj mazowieckim: " + count);
    }

    private static void zad4(){
       final long count = people.stream().filter(DOLNOSLASKIE_WP_REGEX.asPredicate()).count();
        System.out.println("Zad 4) Ilosc ludzi w dolnoslaskim z poczta na wp.pl: " + count);
    }

    private static void zad5 (){
        final long count = people.stream().filter(POSTCODE_REGEX.asPredicate()).count();
        System.out.println("Zad 5) Ilosc osob z kodem 00-x99: " + count);
    }

    private static void Zad6(){
        Map<String, Long> stateAndAccount = new HashMap<>();
        for(String line : people){
            Matcher matcher = STATE_PATTERN_REGEX.matcher(line);
            while (matcher.find()){
                String woj = matcher.group(1);
                Long iloscOsobWWojewodztwie = stateAndAccount.getOrDefault(woj,0L);
                iloscOsobWWojewodztwie += 1;
                stateAndAccount.put(woj, iloscOsobWWojewodztwie);
            }
        }
        System.out.println(stateAndAccount);
    }


    private static void toList() {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of("spisLudnosci.txt"))) {
            people = bufferedReader
                    .lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
