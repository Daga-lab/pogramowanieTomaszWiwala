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
final class Zad2_InputOutputTabela {
    public static void main(String[] args) {
        try (InputStream inputStream = Files.newInputStream(Paths.get("odczyt1.txt"));
             OutputStream outputStream = Files.newOutputStream(Paths.get("zapisywanie3.txt"))) {
            copy(inputStream, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copy(InputStream in, OutputStream out) {
        try {
            byte[] tab = new byte[128];    // lepszy sposób na kopiowanie danych bo bierzemy więcej na raz
            int ilePrzeczytanoBajtow = 0;

            while ((ilePrzeczytanoBajtow = in.read(tab)) != -1) {
                out.write(tab, 0, ilePrzeczytanoBajtow);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
