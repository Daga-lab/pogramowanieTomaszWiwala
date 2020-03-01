package weekend1_IO;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 15.02.2020
 */
final class Zapisywanie {
    public static void main(String[] args){

        try(OutputStream outputStream = Files.newOutputStream(Paths.get("zapisywanie1.txt"));){
                outputStream.write(65);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
