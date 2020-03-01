package weekend2_Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 22.02.2020
 */

//Zad 2.
//Musimy pomóc naszemu klientowi, w naprawieniu bazy danych.
//W pliku tekstowym 5_wprowadzenie_TWiwala_zad2.txt zostało zrzuconych 10 000 numerów telefonów.
//Zauważmy, że niektóre z nich to nie numery telefonu np.
//51a 311 122.
//Przykładowy poprawny numer telefonu to: 621 212 312
//Odpowiedz na poniższe pytania:
//1.Klienta interesuje ile w jego bazie, jest prawdziwych numerów telefonów?
//2.Numery zakończone na 370, są to numery firmowe. Powiedz ile jest takich numerów telefonów?
//3.Numer szczęśliwy, to taki numer który ma cztery siódemki na 5,6 oraz 8,9 pozycji np.
// 552 177 977. Ile jest takich numerów?
//4.Numer wyważony, to taki numer którego suma cyfr środkowych jest równa sumie 3 ostatnich cyfr. Ile jest takich numerów?
//5.Numer bajtkowy, to taki numer który ma potęgi dwójki na 3, 6, 9 pozycji np.
//231 532 448. Ile jest takich numerów?
//
//Wszystkie numery liczymy wśród poprawnych numerów telefonów.

final class Zad3_BazaDanych {
    private static List<String> correctPhones = new ArrayList<>();
    private static Pattern CORRECT_NUMBER_REGEX = Pattern.compile("^([0-9]{3}) ?([0-9]{3}) ?([0-9]{3})$");
    private static Pattern COMPANY_NUMBER_REGEX = Pattern.compile("([0-9]{3})( ?)([0-9]{3})( ?)(370)");
    private static Pattern LUCKY_NUMBER_REGEX = Pattern.compile("([0-9]{3})( ?)([0-9]77)( ?)([0-9]77)");
    private static Pattern BIT_NUMBER_REGEX = Pattern.compile("([0-9]{2}[1248]) ?([0-9]{2}[1248]) ?([0-9]{2}[1248])");


    public static void main(String[] args) {
        readPhones();
        zad1();
        zad2();
        zad3();
        zad4();
        zad5();
    }

    private static void zad1() {
        System.out.println("Zad 1) Ilosc poprawnych numerow: " + correctPhones.size());
    }

    private static void zad2() {
        int count = 0;
        for (String companyPhone : correctPhones) {
            Matcher matcher = COMPANY_NUMBER_REGEX.matcher(companyPhone);
            if (matcher.matches()) {
                count++;
            }
        }
        System.out.println("Zad 2) Ilosc numerow firmowych: " + count);
    }

    private static void zad3() {
        int count = 0;
        for (String luckyNumber : correctPhones) {
            Matcher matcher = LUCKY_NUMBER_REGEX.matcher(luckyNumber);
            if (matcher.matches()) {
                count++;
            }
        }
        System.out.println("Zad 3) Ilosc szczesliwych numerow: " + count);
    }

    private static void zad4() {
        int count = 0;
        for (String balancedNumber : correctPhones) {
            Matcher matcher = CORRECT_NUMBER_REGEX.matcher(balancedNumber);
            while (matcher.find()) {
                String middle = matcher.group(2);
                String end = matcher.group(3);
                if (addedNumber(middle) == addedNumber(end)) {
                    count++;
                }
            }
        }
        System.out.println("Zad 4) Ilosc wywazonych numerow: " + count);
    }

    public static void zad5() {
        int count = 0;
        for (String bitNumber : correctPhones){
            Matcher matcher = BIT_NUMBER_REGEX.matcher(bitNumber);
                if (matcher.matches()){
                    count++;
                }
            }
        System.out.println("Zad 5) Ilosc numerow bajtkowych: " + count);
    }

    private static int addedNumber(String str) {
        char[] tab = str.toCharArray();
        int count = 0;
        for (char number : tab) {
            count = count + Integer.valueOf(number);
        }
        return count;
    }

    private static void readPhones() {

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of("numeryTelefonow.txt"))) {

            /*bufferedReader.lines().forEach(nr -> {
                Matcher matcher = CORRECT_NUMBER_REGEX.matcher(nr);
                if (matcher.matches()) {
                    correctPhones.add(nr);
                } */ //BO TO BARDZO BRZYDKO
            correctPhones = bufferedReader.lines()
                    .filter(CORRECT_NUMBER_REGEX.asPredicate())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
