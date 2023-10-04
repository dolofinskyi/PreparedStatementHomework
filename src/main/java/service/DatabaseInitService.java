package service;

import database.Database;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseInitService implements DatabaseServiceDDL {

    public static final String SQL_FILE_PATH = "sql/init_db.sql";

    public static void main(String[] args) {
        DatabaseInitService initService = new DatabaseInitService();
        initService.initDatabase();
    }

    public void initDatabase(){
        Connection connection = Database.getInstance().getConnection();
        try {
            executeUpdateSqlFile(connection, SQL_FILE_PATH);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
