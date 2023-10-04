-- get sum of salaries of project workers multiplicated on project length in months
SELECT client.NAME AS CLIENT_NAME, SUM(SALARY) * DATEDIFF(MONTH, START_DATE, FINISH_DATE) AS PROJECT_PRICE
FROM worker
JOIN project_worker ON worker.ID = project_worker.WORKER_ID
JOIN project ON project.ID = project_worker.PROJECT_ID
JOIN client ON project.CLIENT_ID = client.ID
GROUP BY project.ID;