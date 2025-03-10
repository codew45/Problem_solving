SELECT
    H.HISTORY_ID,
    ROUND(
        (DATEDIFF(H.END_DATE, H.START_DATE) + 1) * C.DAILY_FEE *
        CASE
            WHEN (DATEDIFF(H.END_DATE, H.START_DATE) + 1) BETWEEN 7 AND 29 THEN 1 - COALESCE(D.DISCOUNT_RATE, 0) / 100
            WHEN (DATEDIFF(H.END_DATE, H.START_DATE) + 1) BETWEEN 30 AND 89 THEN 1 - COALESCE(D.DISCOUNT_RATE, 0) / 100
            WHEN (DATEDIFF(H.END_DATE, H.START_DATE) + 1) >= 90 THEN 1 - COALESCE(D.DISCOUNT_RATE, 0) / 100
            ELSE 1
        END,
        0
    ) AS FEE
FROM
    CAR_RENTAL_COMPANY_CAR C
JOIN
    CAR_RENTAL_COMPANY_RENTAL_HISTORY H
ON
    C.CAR_ID = H.CAR_ID
LEFT JOIN
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN D
ON
    C.CAR_TYPE = D.CAR_TYPE
    AND (
        (D.DURATION_TYPE = '7일 이상' AND (DATEDIFF(H.END_DATE, H.START_DATE) + 1) BETWEEN 7 AND 29) OR
        (D.DURATION_TYPE = '30일 이상' AND (DATEDIFF(H.END_DATE, H.START_DATE) + 1) BETWEEN 30 AND 89) OR
        (D.DURATION_TYPE = '90일 이상' AND (DATEDIFF(H.END_DATE, H.START_DATE) + 1) >= 90)
    )
WHERE
    C.CAR_TYPE = '트럭'
GROUP BY
    H.HISTORY_ID
ORDER BY
    FEE DESC,
    H.HISTORY_ID DESC;
