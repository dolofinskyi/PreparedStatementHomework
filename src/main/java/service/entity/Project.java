package service.entity;

import java.sql.Date;

public record Project(int clientId, Date startDate, Date finishDate) {

}
