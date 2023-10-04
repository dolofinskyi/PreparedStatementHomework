-- get max salary using subquery
SELECT NAME, SALARY from worker
WHERE SALARY = (
    SELECT MAX(SALARY) 
    FROM worker
);