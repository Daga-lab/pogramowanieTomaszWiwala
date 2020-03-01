package weekend1_IO;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 15.02.2020
 */
final class Zad3_KodowanieDomyslne {
    public static void main(String[] args) {
        try {
            try(InputStream inputStream = Files.newInputStream(Paths.get("odczyt1.txt"));
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream))
            {

                int read = inputStreamReader.read();
                System.out.println((char)read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
