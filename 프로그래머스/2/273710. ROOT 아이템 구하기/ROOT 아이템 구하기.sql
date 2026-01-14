-- 코드를 작성해주세요
select 
II.ITEM_ID, 
II.ITEM_NAME
from ITEM_INFO II
join ITEM_TREE IT on II.ITEM_ID = IT.ITEM_ID
where IT.PARENT_ITEM_ID is null
order by II.ITEM_ID