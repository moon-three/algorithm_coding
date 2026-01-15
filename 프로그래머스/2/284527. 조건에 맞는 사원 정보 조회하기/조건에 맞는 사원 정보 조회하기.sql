-- 코드를 작성해주세요
select
sum(HG.SCORE) as SCORE,
HE.EMP_NO,
HE.EMP_NAME,
HE.POSITION,
HE.EMAIL
from HR_EMPLOYEES HE
join HR_GRADE HG on HE.EMP_NO = HG.EMP_NO
where HG.YEAR = '2022'
group by HG.EMP_NO, HG.YEAR
order by SCORE desc
limit 1