package weekend1_IO;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 15.02.2020
 */
final class Zad1_OdczytWszystkich {
    public static void main(String[] args) {
        readFile("odczyt1.txt"); // ABC
    }

    public static void readFile(String fileName) {
        Path of = Path.of(fileName);
        try (InputStream inputStream = Files.newInputStream(of)) {
            int read = 0;
            while ((read = inputStream.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
