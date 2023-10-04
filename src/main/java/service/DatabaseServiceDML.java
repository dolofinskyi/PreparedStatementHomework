package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface DatabaseServiceDML extends DatabaseService {

    default ResultSet executeSelectSqlFile(Connection connection, String sqlFilePath)
            throws SQLException{
        String sql = readSqlFile(sqlFilePath);
        return executeSelectSql(connection, sql);
    }

    default ResultSet executeSelectSql(Connection connection, String sql)
            throws SQLException{
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }
}
