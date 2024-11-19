-- Write your PostgreSQL query statement below
SELECT *
FROM cinema
WHERE (id % 2) != 0
AND description NOT IN ('boring')
ORDER BY rating DESC