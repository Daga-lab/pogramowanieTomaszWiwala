package weekend1_IO;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Zadanie 1
 * Zamykanie streamu ale nie do końca poprawne
 * @author dagmarakitkowska@gmail.com
 * @since 15.02.2020
 */
final class ExIO {
    public static void main(String[] args) {

        Path path = Paths.get("odczyt1.txt");

        InputStream inputStream = null;
        try {
            inputStream = Files.newInputStream(Paths.get("odczyt1.txt"));
            int read = inputStream.read();

            System.out.println(read);
            System.out.println(inputStream.read());    //tutaj myśmy się sami zajeli wyjątkami ale to tak nie powinno być, strumień powinien być automatycznie zamknięty gdzy wyleci wyjątek



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
