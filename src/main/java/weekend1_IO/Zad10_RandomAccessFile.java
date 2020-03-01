package weekend1_IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Jeżeli mamy coś zapisane w formacie bitowy
 * A chcemy w środku coś dopisać
 * RandomAccessFile działa TYLKO DO PLIKÓW!!!
 * @author dagmarakitkowska@gmail.com
 * @since 16.02.2020
 */
final class Zad10_RandomAccessFile {
    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("zapisbinarny.txt", "rw");
        ) {
            byte b = randomAccessFile.readByte();
            randomAccessFile.seek(1);   // znajduję pozycję gdzie chce ustawić kursor
            randomAccessFile.getFilePointer();  // ustawiam tam kursor
            randomAccessFile.write(19); // wpisuję tam 19
            randomAccessFile.writeByte(b);   // przepisuję reszę bajtów, które wczytałam na początku, bo jakbym tego nie zrobiła to by mi po prostu nadpisało te bajty
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
