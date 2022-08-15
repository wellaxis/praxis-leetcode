-- drop table
drop table employee;
drop table department;

-- create table
create table employee (
    id int,
    name varchar(255),
    salary int,
    departmentId int
)
/
create table department (
    id int,
    name varchar(255)
)
/
-- create index
alter table employee add constraint pkemp_id
primary key (id)
/
alter table department add constraint pkdep_id
primary key (id)
/
alter table employee add constraint fkemp_department_id
foreign key (departmentId) references department(id)
/

-- clean table
truncate table employee;
truncate table department;

-- fill table
begin
    insert into department (id, name) values ('1', 'IT');
    insert into department (id, name) values ('2', 'Sales');
    --
    insert into Employee (id, name, salary, departmentId) values ('1', 'Joe', '85000', '1');
    insert into Employee (id, name, salary, departmentId) values ('2', 'Henry', '80000', '2');
    insert into Employee (id, name, salary, departmentId) values ('3', 'Sam', '60000', '2');
    insert into Employee (id, name, salary, departmentId) values ('4', 'Max', '90000', '1');
    insert into Employee (id, name, salary, departmentId) values ('5', 'Janet', '69000', '1');
    insert into Employee (id, name, salary, departmentId) values ('6', 'Randy', '85000', '1');
    insert into Employee (id, name, salary, departmentId) values ('7', 'Will', '70000', '1');
    --
    commit;
end;
/

-- select table
select d.* from department d;
select e.* from employee e;

select rank() over (partition by e.departmentId order by e.salary desc) as rank,
       dense_rank() over (partition by e.departmentId order by e.salary desc) as dense_rank,
       e.departmentId,
       e.name,
       e.salary
from   employee e
/

-- department top three salaries (original): 1381
select d.name as "Department",
       e.name as "Employee",
       e.salary as "Salary"
from   department d,
       employee e,
       (select de.departmentId,
               de.id,
               dense_rank() over (partition by de.departmentId order by de.salary desc) as rank
        from   employee de
       ) de
where  de.rank <= 3
and    de.departmentId = d.id
and    de.id = e.id
order by de.departmentid, de.rank
/

-- department top three salaries (practice): 961
select d.name as "Department",
       e.name as "Employee",
       e.salary as "Salary"
from   department d,
       (select e.id,
               e.name,
               e.departmentId,
               e.salary,
               dense_rank() over (partition by e.departmentId order by e.salary desc) as rank
        from   employee e
       ) e
where  e.rank <= 3
and    d.id = e.departmentId
order by d.id, e.rank
/

-- department top three salaries (solution): 1067
select d.name as "Department",
       e.name as "Employee",
       e.salary as "Salary"
from   employee e
join   department d
on e.departmentId = d.Id
where  3 > (
    select count(distinct de.salary)
    from   employee de
    where  de.salary > e.salary
    and    de.departmentId = e.departmentId
)
order by d.id, e.salary desc
/

-- department top three salaries (alternative): 1262 ms
with e as (
    select dense_rank() over (partition by e.departmentId order by e.salary desc) as rank,
           e.id,
           e.name,
           e.departmentId,
           e.salary
    from   employee e
)
select d.name as "Department",
       e.name as "Employee",
       e.salary as "Salary"
from   department d,
       e
where  e.rank <= 3
and    d.id = e.departmentId
/
