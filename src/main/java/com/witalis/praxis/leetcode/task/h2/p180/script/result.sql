-- drop table
drop table logs;

-- create table
create table logs (
    id int,
    num int
)
/

-- clean table
truncate table logs;

-- fill table
declare
    scenario$ number := 1;
begin
    delete from logs;
    if (scenario$ = 1) then
        insert into logs (id, num) values ('1', '1');
        insert into logs (id, num) values ('2', '1');
        insert into logs (id, num) values ('3', '1');
        insert into logs (id, num) values ('4', '2');
        insert into logs (id, num) values ('5', '1');
        insert into logs (id, num) values ('6', '2');
        insert into logs (id, num) values ('7', '2');
    elsif (scenario$ = 2) then
        insert into logs (id, num) values ('1', '1');
        insert into logs (id, num) values ('2', '1');
        insert into logs (id, num) values ('3', '1');
    elsif (scenario$ = 3) then
        insert into logs (id, num) values ('1', '1');
        insert into logs (id, num) values ('2', '0');
        insert into logs (id, num) values ('3', '0');
        insert into logs (id, num) values ('4', '0');
    end if;
    commit;
end;
/

-- query data
select l.*
from   logs l
/

select l.id,
       l.num,
       lead(l.num) over(order by l.id) as "next",
       lag(l.num) over(order by l.id) as "previous"
from   logs l
order by l.id
/

-- consecutive numbers (original)
select distinct l.num as "ConsecutiveNums"
from   logs l,
       logs lp,
       logs ln
where  lp.id(+) + 1 = l.id
and    ln.id(+) - 1 = l.id
and    l.num = lp.num
and    l.num = ln.num
/

-- consecutive numbers (practice)
select distinct l.num as "ConsecutiveNums"
from   (select l.id,
               l.num,
               lag(l.num) over(order by l.id) as previous,
               lead(l.num) over(order by l.id) as next
        from   logs l
        ) l
where   l.num = l.previous
and     l.num = l.next
/

-- consecutive numbers (solution)
select distinct l1.num as "ConsecutiveNums"
from   logs l1,
       logs l2,
       logs l3
where  l1.id = l2.id - 1
and    l2.id = l3.id - 1
and    l1.num = l2.num
and    l2.num = l3.num
/
