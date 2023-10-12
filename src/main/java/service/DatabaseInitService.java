package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService implements DatabaseService {

    public static final String SQL_FILE_PATH = "sql/init_db.sql";

    public static void main(String[] args) {
        DatabaseInitService initService = new DatabaseInitService();
        initService.initDatabase();
    }

    public void initDatabase() {
        try (Connection connection = databaseInstance.getConnection();
             Statement statement = connection.createStatement()){
            String sql = readSqlFile(SQL_FILE_PATH);
            statement.executeUpdate(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
