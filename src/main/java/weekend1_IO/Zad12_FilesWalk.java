package weekend1_IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 16.02.2020
 */
final class Zad12_FilesWalk {
    public static void main(String[] args) {
        try {
            Files.walk(Path.of("src"))
                    .filter(e -> Files.isRegularFile(e))
                    .filter(e -> e.toString().contains("Ex"))
                    .forEach(e -> {
                        System.out.println(e);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
