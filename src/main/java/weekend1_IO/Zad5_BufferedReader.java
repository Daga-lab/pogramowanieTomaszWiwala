package weekend1_IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 15.02.2020
 */
final class Zad5_BufferedReader {
    public static void main(String[] args) {
        try (/*InputStream inputStream = Files.newInputStream(Paths.get("odczyt1.txt"));
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);*/
                //zamiast tego:
                BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("odczyt1.txt"));
        ) {
            int r = bufferedReader.read();
            System.out.println((char) r);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
