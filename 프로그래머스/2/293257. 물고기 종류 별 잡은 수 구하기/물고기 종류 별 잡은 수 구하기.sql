-- 코드를 작성해주세요
select
count(FI.FISH_TYPE) as 'FISH_COUNT',
FNI.FISH_NAME 
from FISH_INFO FI 
join FISH_NAME_INFO FNI 
    on FI.FISH_TYPE = FNI.FISH_TYPE
group by FI.FISH_TYPE, FNI.FISH_NAME
order by FISH_COUNT desc