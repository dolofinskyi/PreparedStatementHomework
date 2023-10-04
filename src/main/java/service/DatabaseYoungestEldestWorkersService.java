package service;

import database.Database;
import service.wrappers.YoungestEldestWorkers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseYoungestEldestWorkersService implements DatabaseServiceDML {

    public static final String SQL_FILE_PATH = "sql/find_youngest_eldest_workers.sql";

    public static void main(String[] args) {
        DatabaseYoungestEldestWorkersService initService = new DatabaseYoungestEldestWorkersService();
        System.out.println(initService.findYoungestEldestWorkers());
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers(){
        List<YoungestEldestWorkers> youngestEldestWorkersList = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();


        try (ResultSet result = executeSelectSqlFile(connection, SQL_FILE_PATH)){
            while (result.next()){
                String name = result.getString("name");
                String birthday = result.getString("birthday");
                String type = result.getString("type");
                YoungestEldestWorkers record = new YoungestEldestWorkers(name, birthday, type);
                youngestEldestWorkersList.add(record);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return youngestEldestWorkersList;
    }
}
