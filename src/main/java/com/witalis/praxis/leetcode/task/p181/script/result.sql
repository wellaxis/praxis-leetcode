-- drop table
drop table employee;

-- create table
create table employee (
    id int,
    name varchar(255),
    salary int,
    managerId int
);
/

-- clean table
truncate table employee;

-- fill table
begin
    insert into employee (id, name, salary, managerId) values ('1', 'Joe', '70000', '3');
    insert into employee (id, name, salary, managerId) values ('2', 'Henry', '80000', '4');
    insert into employee (id, name, salary, managerId) values ('3', 'Sam', '60000', null);
    insert into employee (id, name, salary, managerId) values ('4', 'Max', '90000', null);
end;
/

-- select table
select e.name as employee
from   employee e
where  e.managerid is not null
and    e.salary > (select m.salary from employee m where m.id = e.managerid)
/

select e.name as employee
from   employee e,
       employee m
where  m.id = e.managerid
and    e.salary > m.salary
/
