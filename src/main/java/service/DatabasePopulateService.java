package service;
import service.entity.Client;
import service.entity.Project;
import service.entity.ProjectWorker;
import service.entity.Worker;
import service.templates.DDLTemplate;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class DatabasePopulateService implements DatabaseService {

    public static void main(String[] args) {
//        DatabasePopulateService service = new DatabasePopulateService();
//
//        List<Worker> workers = List.of(
//                new Worker(
//                        "Den",
//                              Date.valueOf(LocalDate.now()),
//                         "Junior",
//                        1999
//                ),
//                new Worker(
//                        "Robert",
//                        Date.valueOf(LocalDate.now().minusYears(20)),
//                        "Junior",
//                        1999)
//        );
//
//        List<Client> clients = List.of(
//                new Client("Bob"),
//                new Client("Alex"),
//                new Client("Anna"),
//                new Client("Messi")
//        );
//
//        List<Project> projects = List.of(
//                new Project(1,
//                        Date.valueOf(LocalDate.now()),
//                        Date.valueOf(LocalDate.now().plusMonths(5))
//                ),
//                new Project(2,
//                        Date.valueOf(LocalDate.now()),
//                        Date.valueOf(LocalDate.now().plusMonths(10))
//                ),
//                new Project(3,
//                        Date.valueOf(LocalDate.now()),
//                        Date.valueOf(LocalDate.now().plusDays(7))
//                )
//        );
//
//
//        List<ProjectWorker> projectWorkers = List.of(
//            new ProjectWorker(1, 1),
//            new ProjectWorker(2, 1),
//            new ProjectWorker(2, 2)
//        );
//
//        service.addData(workers, DDLTemplate.ADD_WORKER);
//        service.addData(clients, DDLTemplate.ADD_CLIENT);
//        service.addData(projects, DDLTemplate.ADD_PROJECT);
//        service.addData(projectWorkers, DDLTemplate.ADD_PROJECT_WORKER);
    }

    public void createWorkerStatement(PreparedStatement statement, Worker worker)
            throws SQLException {
        statement.setString(1, worker.name());
        statement.setDate(2, worker.birthday());
        statement.setString(3, worker.level());
        statement.setInt(4, worker.salary());
    }

    public void createClientStatement(PreparedStatement statement, Client client)
            throws SQLException {
        statement.setString(1, client.name());
    }

    public void createProjectStatement(PreparedStatement statement, Project project)
            throws SQLException {
        statement.setInt(1, project.clientId());
        statement.setDate(2, project.startDate());
        statement.setDate(3, project.finishDate());
    }

    public void createProjectWorkerStatement(PreparedStatement statement, ProjectWorker projectWorker)
            throws SQLException {
        statement.setLong(1, projectWorker.projectId());
        statement.setLong(2, projectWorker.workerId());
    }

    public void createEntityStatement(PreparedStatement statement, Record entity)
            throws SQLException {
        if (entity instanceof Worker) {
            createWorkerStatement(statement, (Worker) entity);
        } else if (entity instanceof Client) {
            createClientStatement(statement, (Client) entity);
        } else if (entity instanceof Project) {
            createProjectStatement(statement, (Project) entity);
        } else if (entity instanceof ProjectWorker) {
            createProjectWorkerStatement(statement, (ProjectWorker) entity);
        }
    }

    public void addData(List<? extends Record> entities, String sqlTemplate) {
        try (Connection connection = databaseInstance.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlTemplate)) {
            for (Record entity: entities){
                createEntityStatement(statement, entity);
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
