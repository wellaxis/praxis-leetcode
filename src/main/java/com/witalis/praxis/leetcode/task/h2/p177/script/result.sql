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

-- oracle
select e.salary as "NthHighestSalary"
from (
    select row_number() over (order by e.salary desc) as id,
           e.salary as salary
    from   (select distinct e.salary from employee e) e
    order by e.salary desc
) e
where id = 3
/

select distinct e.salary
from   employee e
order by e.salary desc
offset 3 - 1 rows
fetch next 1 rows only
/

-- n-th highest salary
select getNthHighestSalary(1) as "NthHighestSalary"
from   dual
/

-- oracle
create or replace function getNthHighestSalary(n integer) return number is
    salary$ number := null;
begin
    select e.salary
    into   salary$
    from (
        select row_number() over (order by e.salary desc) as id,
               e.salary as salary
        from   (select distinct e.salary from employee e) e
        order by e.salary desc
    ) e
    where id = n;
    return salary$;
end;
/

create or replace function getNthHighestSalary(n integer) return number is
    salary$ number := null;
begin
    select distinct e.salary
    into   salary$
    from   employee e
    order by e.salary desc
    offset n - 1 rows
    fetch next 1 rows only;
    return salary$;
end;
/

-- mysql
select (
    select distinct e.salary
    from   employee e
    order by e.salary desc
    limit 3 - 1 offset 1
) as "SecondHighestSalary"
/

create function getNthHighestSalary(n int) returns int
begin
  return (
      select distinct r.salary
      from   (
          select e.salary,
                 dense_rank() over (order by e.salary desc) as 'rank'
          from employee e
      ) r
      where  r.rank = n
  );
end
/

create function getNthHighestSalary(n int) returns int
begin
  set n = n - 1;
  return (
      select distinct(e.salary)
      from   employee e
      order by e.salary desc
      limit 1 offset n
  );
end
/
