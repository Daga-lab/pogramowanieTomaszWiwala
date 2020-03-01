package weekend1_IO;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *Używamy scannera do czytania
 *
 * @author dagmarakitkowska@gmail.com
 * @since 15.02.2020
 */
final class Zad4_HelloWorld {
    public static void main(String[] args) {
        try (InputStream inputStream = Files.newInputStream(Paths.get("helloworld.txt"));
             Scanner scanner = new Scanner(inputStream);) {

            int i = scanner.nextInt();
            String s = scanner.nextLine();
            System.out.println(i);
            System.out.println(s);

        } catch (IOException e) {
            e.printStackTrace();
        }
        ;

    }
}
