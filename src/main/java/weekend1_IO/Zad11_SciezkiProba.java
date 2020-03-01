package weekend1_IO;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 16.02.2020
 */
final class Zad11_SciezkiProba {
    public static void main(String[] args) {
        try(OutputStream source = Files.newOutputStream(Paths.get("hello5.txt"));
                ) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void copy(File source, File dest) throws IOException {

       Files.createFile(Path.of("hello5.txt"));
       Files.move(Path.of("hello5.txt"), Path.of("hello5_1.txt"));

        source = new File("C:/Users/dagma/IdeaProjects/ZajeciaTomaszWiwala/hello5.txt");
        dest = new File("C:/Users/dagma/IdaProjects/ZajeciaTomaszWiwala/zapisywanie3.txt");
        try {
            Files.copy(source.toPath(), dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
