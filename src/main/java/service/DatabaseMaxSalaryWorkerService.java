package service;

import database.Database;
import service.wrappers.MaxWorkerSalary;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMaxSalaryWorkerService implements DatabaseServiceDML {

    public static final String SQL_FILE_PATH = "sql/find_max_salary_worker.sql";

    public static void main(String[] args) {
        DatabaseMaxSalaryWorkerService initService = new DatabaseMaxSalaryWorkerService();
        System.out.println(initService.findMaxSalaryWorker());
    }

    public List<MaxWorkerSalary> findMaxSalaryWorker(){
        List<MaxWorkerSalary> maxWorkerSalaryList = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();

        try (ResultSet result = executeSelectSqlFile(connection, SQL_FILE_PATH)){
            while (result.next()){
                String name = result.getString("name");
                int salary = result.getInt("salary");
                MaxWorkerSalary record = new MaxWorkerSalary(name, salary);
                maxWorkerSalaryList.add(record);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return maxWorkerSalaryList;
    }
}
