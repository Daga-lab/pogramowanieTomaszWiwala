package weekend2_Regex;

import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 22.02.2020
 */
final class Zad1_ZipCode {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[0-9]{2}-[0-9]{3}");
        Matcher matcher = pattern.matcher("02-212");
        System.out.println(matcher.matches());

        Matcher matcher1 = pattern.matcher("ab-212");
        System.out.println(matcher1.matches());

        Pattern.matches("[a-zA-Z_]+@([a-zA-Z]+\\.[a-zA-Z]+)+", "daga@gmail.com");
        System.out.println(matcher.matches());

        Pattern pattern1 = Pattern.compile("([a-zA-Z]+):([a-zA-Z]+)");
        Matcher matcher2 = pattern1.matcher("Dagmara:Kitkowska");
        System.out.println(matcher2.matches());
        System.out.println(matcher2.group(0));
        System.out.println(matcher2.group(1));
        System.out.println(matcher2.group(2));

        String name = "Dagmara:Kitkowska";
        String changed = name.replaceAll("([a-zA-Z]+):([a-zA-Z]+)", "Imię: $1, Nazwisko: $2");
        System.out.println(changed);
    }
}
