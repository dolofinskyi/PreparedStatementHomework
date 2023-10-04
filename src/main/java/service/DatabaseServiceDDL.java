package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface DatabaseServiceDDL extends DatabaseService {

    default void executeUpdateSqlFile(Connection connection, String sqlFilePath)
            throws SQLException {
        String query = readSqlFile(sqlFilePath);
        executeUpdateSql(connection, query);
    }

    default void executeUpdateSql(Connection connection, String sql)
            throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

}
