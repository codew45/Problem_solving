WITH RECURSIVE HOURS AS (
    SELECT 0 AS TIME
    UNION ALL
    SELECT TIME + 1
    FROM HOURS
    WHERE TIME < 23
)

SELECT
    H.TIME, COUNT(O.ANIMAL_ID) AS COUNT
FROM
    HOURS H
LEFT JOIN
    ANIMAL_OUTS O
ON
    H.TIME = HOUR(O.DATETIME)
GROUP BY
    H.TIME
ORDER BY H.TIME