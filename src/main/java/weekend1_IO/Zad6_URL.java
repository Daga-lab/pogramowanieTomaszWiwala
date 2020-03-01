package weekend1_IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 15.02.2020
 */
final class Zad6_URL {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("https://www.google.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try (InputStream inputStream = url.openStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            bufferedReader.lines().forEach(e -> System.out.println(e));  //wyrażenie lambda

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
