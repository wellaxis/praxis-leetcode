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
    insert into employee (id, name, salary, departmentId) values ('1', 'Joe', '70000', '1');
    insert into employee (id, name, salary, departmentId) values ('2', 'Jim', '90000', '1');
    insert into employee (id, name, salary, departmentId) values ('3', 'Henry', '80000', '2');
    insert into employee (id, name, salary, departmentId) values ('4', 'Sam', '60000', '2');
    insert into employee (id, name, salary, departmentId) values ('5', 'Max', '90000', '1');
    --
    commit;
end;
/

-- select table
select d.* from department d;
select e.* from employee e;

select rank() over (partition by DepartmentId order by Salary desc) as rank,
       e.departmentId,
       e.name,
       e.salary
from   employee e
/

-- department highest salary (original): 950
select d.name as "Department",
       e.name as "Employee",
       e.salary as "Salary"
from   department d,
       employee e,
       (select em.departmentId,
               max(em.salary) as max_salary
        from   employee em
        group by em.departmentId
       ) em
where  e.departmentId = d.id
and    em.departmentId = d.id
and    e.salary = em.max_salary
/

-- department highest salary (practice): 984
select d.name as "Department",
       e.name as "Employee",
       d.max_salary as "Salary"
from   (select d.id,
               d.name,
               (select max(e.salary)
                from   employee e
                where  e.departmentId = d.id
               ) as max_salary
        from   department d
       ) d,
       employee e
where  e.departmentId = d.id
and    e.salary = d.max_salary
/

-- department highest salary (solution): 1081
select d.name as "Department",
       e.name as "Employee",
       e.salary as "Salary"
from   employee e,
       department d
where  d.id = e.departmentId
and    (e.DepartmentId, e.salary) in (
    select em.departmentId,
           max(em.salary)
    from   employee em
    group by em.departmentId
)
/

-- alternative: 769 ms
with me as (
    select rank() over (partition by e.departmentId order by e.salary desc) as rank,
           e.departmentId,
           e.name,
           e.salary
    from   employee e
)
select d.name as "Department",
       me.name as "Employee",
       me.salary as "Salary"
from   me,
       department d
where  d.id = me.departmentId
and    me.rank = 1
/

-- the fastest: 712 ms
select de.dep_name as "Department",
       de.name as "Employee",
       de.salary as "Salary"
from   (select e.name,
               e.salary,
               e.departmentId,
               d.name as dep_name,
               max(e.salary) over(partition by e.departmentId) as top_salary
        from   employee e,
               department d
        where  e.departmentId  = d.id(+)
       ) de
where  de.salary = de.top_salary
/
