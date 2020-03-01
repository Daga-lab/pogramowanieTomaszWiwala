package weekend1_IO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 15.02.2020
 */
final class Zad2_InputOutput {
    public static void main(String[] args) {

        try (InputStream inputStream = Files.newInputStream(Paths.get("odczyt1.txt"));
             OutputStream outputStream = Files.newOutputStream(Paths.get("zapisywanie2.txt"))) {
            copy(inputStream, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copy(InputStream in, OutputStream out) {
        try {
            int read = 0;
            while ((read = in.read()) != -1) {   // taki sposób nie jest wyjdajny, bo kopijuemy bajt po bajcie
                out.write(read);                // lepsze rozwiązanie jest w InputOutputTabela = bierzemy na raz więcej bajów i je zapisać
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
