package service;

import database.Database;
import service.wrappers.MaxProjectsClient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMaxProjectsClientService implements DatabaseServiceDML {

    public static final String SQL_FILE_PATH = "sql/find_max_projects_client.sql";

    public static void main(String[] args) {
        DatabaseMaxProjectsClientService initService = new DatabaseMaxProjectsClientService();
        System.out.println(initService.findMaxProjectsClient());
    }

    public List<MaxProjectsClient> findMaxProjectsClient(){
        List<MaxProjectsClient> maxProjectsClientList = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();

        try (ResultSet result = executeSelectSqlFile(connection, SQL_FILE_PATH)){
            while (result.next()){
                String clientName = result.getString("client_name");
                int projectsCount = result.getInt("project_count");
                MaxProjectsClient record = new MaxProjectsClient(clientName, projectsCount);
                maxProjectsClientList.add(record);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return maxProjectsClientList;
    }
}
