package weekend1_IO;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 16.02.2020
 */
final class Zad9_OdczytWFormacieBitowym {
    public static void main(String[] args) {
        try(
                InputStream inputStream = Files.newInputStream(Paths.get("zapisbinarny.txt"));
                DataInputStream dataInputStream = new DataInputStream(inputStream);
        ){
            int i = dataInputStream.readByte();
            int i2 = dataInputStream.readByte();
            int i3 = dataInputStream.readByte();
            System.out.println(i);
            System.out.println(i2);
            System.out.println(i3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
