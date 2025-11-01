select DURATION_TYPE, DISCOUNT_RATE
from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
where CAR_TYPE = '트럭';

select A.HISTORY_ID
    , FLOOR(B.DAILY_FEE
            * (case when DATEDIFF(A.END_DATE, A.START_DATE)+1 >= 90 then 0.85
                   when DATEDIFF(A.END_DATE, A.START_DATE)+1 >= 30 then 0.92
                   when DATEDIFF(A.END_DATE, A.START_DATE)+1 >= 7 then 0.95
             else 1 end)
            * (DATEDIFF(A.END_DATE, A.START_DATE)+1)
    ) as FEE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY A
inner join CAR_RENTAL_COMPANY_CAR B
on A.CAR_ID = B.CAR_ID
where B.CAR_TYPE = '트럭'
order by FEE desc, HISTORY_ID desc;