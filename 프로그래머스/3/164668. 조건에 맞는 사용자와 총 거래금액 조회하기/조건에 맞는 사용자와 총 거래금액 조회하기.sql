SELECT U.USER_ID, U.NICKNAME, P.TOTAL_SALES
FROM USED_GOODS_USER U
JOIN 
(
    SELECT WRITER_ID, SUM(PRICE) AS TOTAL_SALES
    FROM USED_GOODS_BOARD
    WHERE STATUS LIKE 'DONE'
    GROUP BY WRITER_ID
    HAVING SUM(PRICE) >= 700000
) P
ON U.USER_ID = P.WRITER_ID
ORDER BY TOTAL_SALES