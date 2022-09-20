-- drop table
drop table stadium;

-- create table
create table stadium (
    id int,
    visit_date date null,
    people int
)
/

-- create index
alter table stadium add constraint pst_visit_date
primary key (visit_date);
/

-- clean table
truncate table stadium;

-- fill table
declare
    flag$ boolean := true;
begin
    if flag$ then
        insert into stadium (id, visit_date, people) values ('1', '2017-01-01', '10');
        insert into stadium (id, visit_date, people) values ('2', '2017-01-02', '109');
        insert into stadium (id, visit_date, people) values ('3', '2017-01-03', '150');
        insert into stadium (id, visit_date, people) values ('4', '2017-01-04', '100');
    else
        insert into stadium (id, visit_date, people) values ('1', '2017-01-01', '10');
        insert into stadium (id, visit_date, people) values ('2', '2017-01-02', '109');
        insert into stadium (id, visit_date, people) values ('3', '2017-01-03', '150');
        insert into stadium (id, visit_date, people) values ('4', '2017-01-04', '99');
        insert into stadium (id, visit_date, people) values ('5', '2017-01-05', '145');
        insert into stadium (id, visit_date, people) values ('6', '2017-01-06', '1455');
        insert into stadium (id, visit_date, people) values ('7', '2017-01-07', '199');
        insert into stadium (id, visit_date, people) values ('8', '2017-01-09', '188');
    end if;
    --
    commit;
end;
/

-- select table
select s.*
from   stadium s
/

-- human traffic of stadium (original)
select s.id as "id",
       to_char(s.visit_date, 'yyyy-mm-dd') as "visit_date",
       s.people as "people"
from (
    select s.id,
           s.visit_date,
           s.people,
           (select 1
            from   stadium ps
            where  ps.id = s.id - 1
            and    ps.people >= 100
           ) prev1,
           (select 1
            from   stadium ps
            where  ps.id = s.id - 2
            and    ps.people >= 100
           ) prev2,
           (select 1
            from   stadium ns
            where  ns.id = s.id + 1
            and    ns.people >= 100
           ) next1,
           (select 1
            from   stadium ns
            where  ns.id = s.id + 2
            and    ns.people >= 100
           ) next2
    from   stadium s
    where  s.people >= 100
) s
where nvl(prev1 + prev2, 0) + nvl(next1 + next2, 0) + nvl(prev1 + next1, 0) >= 1
order by s.visit_date asc
/

-- human traffic of stadium (practice)
with sn as (
    select s.id,
           s.visit_date,
           case when s.people >= 100 then s.people else null end as people
    from   stadium s
)
select s.id as "id",
       to_char(s.visit_date, 'yyyy-mm-dd') as "visit_date",
       s.people as "people"
from (
    select s.id,
           s.visit_date,
           s.people,
           case when s.people >= 100 then 1 else 0 end as coef,
           lag(people, 1) over (order by s.id) as prev1,
           lag(people, 2) over (order by s.id) as prev2,
           lead(people, 1) over (order by s.id) as next1,
           lead(people, 2) over (order by s.id) as next2
    from   sn s
)s
where coef * (nvl(prev1 + prev2, 0) + nvl(next1 + next2, 0) + nvl(prev1 + next1, 0)) >= 1
/

-- human traffic of stadium (solution)
select s.id as "id",
       to_char(s.visit_date, 'yyyy-mm-dd') as "visit_date",
       s.people as "people"
from (
    select s.id,
           lead(s.id) over(order by s.id) id2,
           lead(s.id, 2) over(order by s.id) id3,
           lag(s.id) over(order by s.id) id4,
           lag(s.id, 2) over(order by s.id) id5,
           s.visit_date,
           s.people
    from   stadium s
    where  s.people >= 100
) s
where  s.id2 - s.id = s.id3 - s.id2
or     s.id4 - s.id5 = s.id - s.id4
or     s.id2 - s.id = s.id - s.id4
/
