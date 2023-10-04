-- check if count of all projects is equal to MAX of counts
SELECT client.NAME as CLIENT_NAME, COUNT(CLIENT_ID) AS PROJECT_COUNT
FROM project
JOIN client ON client.ID = project.CLIENT_ID 
GROUP BY CLIENT_ID 
HAVING PROJECT_COUNT = (
    SELECT MAX(cnt) FROM (
        SELECT COUNT(CLIENT_ID) AS cnt
        FROM project
        GROUP BY CLIENT_ID
    )
);
