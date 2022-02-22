-- drop table
drop table employee;

-- create table
create table employee (
    id       int,
    salary   int,
    primary key (id)
);
/

-- clean table
truncate table employee;

-- fill table
begin
    insert into Employee (id, salary) values ('1', '100');
    --insert into Employee (id, salary) values ('2', '100');
    insert into Employee (id, salary) values ('2', '200');
    insert into Employee (id, salary) values ('3', '300');
    insert into Employee (id, salary) values ('4', '400');
    -- apply
    commit;
end;
/

-- select table
select e.*
from   employee e
where  e.id is not null
/

select distinct e.salary,
       lead(e.salary) over (order by e.salary asc) as next,
       lag(e.salary) over (order by e.salary asc) as prev
from   employee e
where  e.id is not null
order by e.salary desc
/

-- second highest salary
select max(e.salary) as "SecondHighestSalary"
from   employee e
where  e.salary < (
    select max(me.salary)
    from   employee me
    where  me.id <> e.id
)
/

select e.salary as "SecondHighestSalary"
from (
    select row_number() over (order by e.salary desc) as id,
           lag(e.salary) over (order by e.salary asc) as salary
    from   (select distinct e.salary from employee e) e
    order by e.salary desc
) e
where id = 1
/

select (
    select distinct e.salary
    from   employee e
    order by e.salary desc
    limit 1 offset 1
) as "SecondHighestSalary"
/
