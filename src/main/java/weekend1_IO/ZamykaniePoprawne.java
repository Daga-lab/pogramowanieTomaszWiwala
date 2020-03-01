package weekend1_IO;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Zadanie 2
 * Poprawne zamykanie streamu
 * @author dagmarakitkowska@gmail.com
 * @since 15.02.2020
 */
final class ZamykaniePoprawne {
    public static void main(String[] args){

        try(InputStream inputStream = Files.newInputStream(Paths.get("odczyt1.txt"));){  // to jest mechanizm otwierania strumienia
            System.out.println(inputStream.read());     // czytamy ze strumienia  dzięki try with resources jeżeli wyleci wyjątek to on się sam tym zajmie(zamknie strumień), nie trzeba tego pisać tak jak w zadaniu 1
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
