package weekend1_IO;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 16.02.2020
 */
final class Zad9_ZapisWFormacieBinarnymNapisu {
    public static void main(String[] args) {
        try(
                OutputStream outputStream = Files.newOutputStream(Paths.get("hello.txt"));
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        ){
            dataOutputStream.writeChars("Hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
