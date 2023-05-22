-- drop table
drop table employee;
drop table bonus;

-- create table
create table employee (
    empId int,
    name varchar(255),
    supervisor int,
    salary int
);
/
create table bonus (
    empId int,
    bonus int
);
/

-- create index
alter table employee add constraint pkemp_empId
primary key (empId);
/
alter table bonus add constraint pkbon_empId
primary key (empId);
/
alter table bonus add constraint fkbon_empId
foreign key (empId) references employee(empId);
/

-- clean table
truncate table employee;
truncate table bonus;

delete from bonus;
delete from employee;

-- fill table
begin
    insert into employee (empId, name, supervisor, salary) values (3, 'Brad', null, 4000);
    insert into employee (empId, name, supervisor, salary) values (1, 'John', 3, 1000);
    insert into employee (empId, name, supervisor, salary) values (2, 'Dan', 3, 2000);
    insert into employee (empId, name, supervisor, salary) values (4, 'Thomas', 3, 4000);
    --
    insert into bonus (empId, bonus) values (2, 500);
    insert into bonus (empId, bonus) values (3, 2000);
    --
    commit;
end;
/

-- select table
select e.*
from   employee e
/
select b.*
from   bonus b
/

-- report the bonus of each employee with a bonus less than 1000 (original)
select e.name,
       (select b.bonus
        from   bonus b
        where  b.empId = e.empId
       ) as bonus
from   employee e
where not exists (
    select null
    from   bonus b
    where  b.empId = e.empId
    and    b.bonus >= 1000
)
order by 2 asc nulls first
/

-- customer placing the largest number of orders (practice)
select e.name,
       e.bonus
from (
    select e.name,
           (select b.bonus
            from   bonus b
            where  b.empId = e.empId
           ) as bonus
    from   employee e
) e
where nvl(e.bonus, 0) < 1000
/

-- customer placing the largest number of orders (solution)
select e.name,
       b.bonus
from   employee e
    left join bonus b
on e.empid = b.empid
where  nvl(b.bonus, 0) < 1000
/
