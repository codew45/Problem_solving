SELECT FI.ID, FNI.FISH_NAME, FI.LENGTH
FROM FISH_INFO FI
JOIN FISH_NAME_INFO FNI
ON FI.FISH_TYPE = FNI.FISH_TYPE
WHERE FI.LENGTH = (
SELECT MAX(LENGTH)
    FROM FISH_INFO
    WHERE FI.FISH_TYPE = FISH_TYPE
)
ORDER BY FI.ID ASC;