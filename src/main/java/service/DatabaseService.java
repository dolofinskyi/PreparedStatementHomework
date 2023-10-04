package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public interface DatabaseService {
    default String readSqlFile(String path) {
        try {
            return String.join("\n",
                    Files.readAllLines(Paths.get(path)));
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
