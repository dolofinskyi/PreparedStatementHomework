package service;

import database.Database;
import service.wrappers.ProjectPrices;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseProjectPricesService implements DatabaseServiceDML {

    public static final String SQL_FILE_PATH = "sql/find_project_prices.sql";

    public static void main(String[] args) {
        DatabaseProjectPricesService initService = new DatabaseProjectPricesService();
        System.out.println(initService.findProjectPrices());
    }

    public List<ProjectPrices> findProjectPrices(){
        List<ProjectPrices> projectPricesList = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();

        try (ResultSet result = executeSelectSqlFile(connection, SQL_FILE_PATH)){
            while (result.next()){
                String clientName = result.getString("client_name");
                int projectPrice = result.getInt("project_price");
                ProjectPrices record = new ProjectPrices(clientName, projectPrice);
                projectPricesList.add(record);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return projectPricesList;
    }
}
