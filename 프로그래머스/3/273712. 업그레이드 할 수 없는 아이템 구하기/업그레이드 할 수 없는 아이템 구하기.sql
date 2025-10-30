-- 코드를 작성해주세요
SELECT II.ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_TREE IT JOIN ITEM_INFO II ON IT.ITEM_ID = II.ITEM_ID
WHERE II.ITEM_ID NOT IN (SELECT PARENT_ITEM_ID
                             FROM ITEM_TREE
                            WHERE PARENT_ITEM_ID IS NOT NULL)
ORDER BY ITEM_ID DESC
                                                            