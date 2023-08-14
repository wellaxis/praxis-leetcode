-- drop table
drop table my_numbers;

-- create table
create table my_numbers (
    num int
)
/

-- create index // no pk

-- clean table
truncate table my_numbers;

-- fill table
declare
begin
    -- numbers
    insert into my_numbers (num) values ('8');
    insert into my_numbers (num) values ('8');
    insert into my_numbers (num) values ('3');
    insert into my_numbers (num) values ('3');
    insert into my_numbers (num) values ('1');
    insert into my_numbers (num) values ('4');
    insert into my_numbers (num) values ('5');
    insert into my_numbers (num) values ('6');
    -- done
    commit;
end;
/

-- select table
select n.*
from   my_numbers n
/

-- biggest single number (original)
select sum(n.num) as num
from (
    select n.num
    from   my_numbers n
    group by n.num
    having count(n.num) = 1
    order by n.num desc
) n
where rownum = 1
/

select n.num
from (
    select n.num
    from (
        select n.num from my_numbers n
        union all
        select null from dual
    ) n
    group by n.num
    having count(n.num) <= 1
    order by n.num desc nulls last
) n
fetch first 1 rows only
/

-- biggest single number (practice)
select max(n.num) as num
from (
    select n.num
    from   my_numbers n
    group by n.num
    having count(n.num) = 1
) n
/

-- biggest single number (solution)
select max(t.num) as num
from (
    select num
    from   my_numbers
    group by num
    having count(num) = 1
) t
/
