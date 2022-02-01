-- drop table
drop table weather;

-- create table
create table weather (
    id int,
    recordDate date,
    temperature int
);
/

-- clean table
truncate table weather;

-- fill table
begin
    insert into weather (id, recordDate, temperature) values ('1', '2015-01-01', '10');
    insert into weather (id, recordDate, temperature) values ('2', '2015-01-02', '25');
    insert into weather (id, recordDate, temperature) values ('3', '2015-01-03', '20');
    insert into weather (id, recordDate, temperature) values ('4', '2015-01-04', '30');
end;
/

-- select table
select w.*
from   weather w
order by w.id asc
/

-- rising temperature
select w.id
from   weather w,
       weather wy
where  wy.recorddate = w.recorddate - 1
and    wy.temperature < w.temperature
/

select w.id
from   weather w,
       weather wy
where  datediff(w.recordDate, wy.recordDate) = 1
and    wy.temperature < w.temperature
/
