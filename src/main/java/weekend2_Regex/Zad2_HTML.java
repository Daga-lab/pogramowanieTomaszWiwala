package weekend2_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 22.02.2020
 */
////Napisz wyrażenie regularne takie które będzie dopasowywać pojedyńczy tag z html’a. Tj.
// <html><body></body></html>
//  Dopasuje jedynie <html>.
// <b>tekst</b>, dopasuje jedynie <b> zamiast <b>tekst</b>
final class Zad2_HTML {
    public static void main(String[] args) {
        Pattern compile = Pattern.compile("(<.*?>)");
        String html = "<html><body></body></html>";
        Matcher matcher = compile.matcher(html);
        while(matcher.find()){
            System.out.println(matcher.group(1));
        }
    }
}
