package service;

import database.Database;
import service.wrappers.LongestProject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseLongestProjectService implements DatabaseServiceDML {

    public static final String SQL_FILE_PATH = "sql/find_longest_project.sql";

    public static void main(String[] args) {
        DatabaseLongestProjectService initService = new DatabaseLongestProjectService();
        System.out.println(initService.findLongestProject());
    }

    public List<LongestProject> findLongestProject(){
        List<LongestProject> longestProjectList = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();

        try (ResultSet result = executeSelectSqlFile(connection, SQL_FILE_PATH)){
            while (result.next()){
                String clientName = result.getString("client_name");
                int projectMonthCount = result.getInt("project_month_count");
                LongestProject record = new LongestProject(clientName, projectMonthCount);
                longestProjectList.add(record);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return longestProjectList;
    }
}
