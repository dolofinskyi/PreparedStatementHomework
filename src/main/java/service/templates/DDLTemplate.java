package service.templates;

public class DDLTemplate {
    public static final String ADD_WORKER = "INSERT INTO worker(NAME, BIRTHDAY, LEVEL, SALARY) " +
            "VALUES (?, ?, ?, ?);";
    public static final String ADD_CLIENT = "INSERT INTO client(NAME) " +
            "VALUES (?);";
    public static final String ADD_PROJECT = "INSERT INTO project(CLIENT_ID, START_DATE, FINISH_DATE) " +
            "VALUES(?, ?, ?);";
    public static final String ADD_PROJECT_WORKER = "INSERT INTO project_worker(PROJECT_ID, WORKER_ID) " +
            "VALUES(?, ?);";
}
