package weekend1_IO;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 15.02.2020
 */
final class Zad7_WpisanieStuLiczb {
    public static void main(String[] args) {
        try( OutputStream outputStream = Files.newOutputStream(Paths.get("zapisywanie3.txt"));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);) {
            input (outputStreamWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void input (OutputStreamWriter out){
        int wpisana = 0;
        for (int i = 0; i <= 100 ; i++) {
            wpisana = i;
            try {
                out.write((String.valueOf(wpisana) + " "));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
