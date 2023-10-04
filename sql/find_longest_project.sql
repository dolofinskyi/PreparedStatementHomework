-- checking if difference between two dates is equal to MAX() of differences
SELECT client.NAME AS CLIENT_NAME, DATEDIFF(MONTH, START_DATE, FINISH_DATE) AS PROJECT_MONTH_COUNT 
FROM project
JOIN client ON client.ID = CLIENT_ID
WHERE DATEDIFF(MONTH, START_DATE, FINISH_DATE) = (
    SELECT MAX(diff) FROM (
        SELECT DATEDIFF(MONTH, START_DATE, FINISH_DATE) AS diff 
        FROM project
    )
);