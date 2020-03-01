package weekend1_IO;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Zapisujemy liczby w formacie bitowym
 * Czyli np 100 nie ajmuje 3 bitów, jak normalnie
 * Tylko od razu zapisujemy to do jednego bitu - oszczędzamy pamięć
 * I jest mniej procesów kodowania pod drodze
 * @author dagmarakitkowska@gmail.com
 * @since 16.02.2020
 */
final class Zad9_ZapisWFormacieBitowym {
        public static void main(String[] args) {
            try(
                    OutputStream outputStream = Files.newOutputStream(Paths.get("zapisbinarny.txt"));
                    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            ){
                dataOutputStream.writeByte(15);
                dataOutputStream.writeByte(11);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
