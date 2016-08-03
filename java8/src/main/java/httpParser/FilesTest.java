package httpParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * User: fh
 * Date: 16/4/13 17:50
 */
public class FilesTest {
    public static void main(String[] args) {
        try {
            Files.list(new File("/Users/fh/Desktop/").toPath())
                    .filter(path1 -> path1.getFileName().toString().endsWith("txt"))
                    .forEach(path -> System.out.println(path.getFileName()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
