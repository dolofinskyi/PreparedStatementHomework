package service;

import database.Database;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabasePopulateService implements DatabaseServiceDDL {

    public static final String SQL_FILE_PATH = "sql/populate_db.sql";

    public static void main(String[] args) {
        DatabasePopulateService initService = new DatabasePopulateService();
        initService.populateDatabase();
    }

    public void populateDatabase(){
        Connection connection = Database.getInstance().getConnection();
        try {
           executeUpdateSqlFile(connection, SQL_FILE_PATH);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
