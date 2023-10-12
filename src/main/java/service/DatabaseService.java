package service;


import database.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public interface DatabaseService {
    Database databaseInstance = Database.getInstance();

    default String readSqlFile(String path) {
        try {
            return String.join("\n", Files.readAllLines(Paths.get(path)));
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
