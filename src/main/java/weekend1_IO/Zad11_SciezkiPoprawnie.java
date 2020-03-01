package weekend1_IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 16.02.2020
 */
final class Zad11_SciezkiPoprawnie {
    public static void main(String[] args) {
        try {
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void run() throws IOException {
        Files.createFile(Paths.get("hello5.txt"));
        Files.move(Paths.get("hello5.txt"), Paths.get("hello5_1.txt"));
        Files.copy(Paths.get("hello5_1.txt"),Paths.get("hello5_2.txt"));
        Files.delete(Paths.get("hello5_1.txt"));
    }
}
