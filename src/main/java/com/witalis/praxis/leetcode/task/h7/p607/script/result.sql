-- drop table
drop table SalesPerson;
drop table Company;
drop table Orders;

-- create table
create table SalesPerson (
    sales_id int,
    name varchar(255),
    salary int,
    commission_rate int,
    hire_date date
)
/

create table Company (
    com_id int,
    name varchar(255),
    city varchar(255)
)
/

create table Orders (
    order_id int,
    order_date date,
    com_id int,
    sales_id int,
    amount int
)
/

-- create index
alter table SalesPerson add constraint pksp_sales_id
primary key (sales_id);
/
alter table Company add constraint pkcm_com_id
primary key (com_id);
/
alter table Orders add constraint pkrd_order_id
primary key (order_id);
/
alter table Orders add constraint fkrd_com_id
foreign key (com_id) references Company(com_id);
/
alter table Orders add constraint fkrd_sales_id
foreign key (sales_id) references SalesPerson(sales_id);
/

-- clean table
truncate table SalesPerson;
truncate table Company;
truncate table Orders;

-- fill table
declare
    flag$ boolean := true;
begin
    -- sales
    insert into SalesPerson (sales_id, name, salary, commission_rate, hire_date) values ('1', 'John', '100000', '6', to_date('4/1/2006', 'mm/dd/yyyy'));
    insert into SalesPerson (sales_id, name, salary, commission_rate, hire_date) values ('2', 'Amy', '12000', '5', to_date('5/1/2010', 'mm/dd/yyyy'));
    insert into SalesPerson (sales_id, name, salary, commission_rate, hire_date) values ('3', 'Mark', '65000', '12', to_date('12/25/2008', 'mm/dd/yyyy'));
    insert into SalesPerson (sales_id, name, salary, commission_rate, hire_date) values ('4', 'Pam', '25000', '25', to_date('1/1/2005', 'mm/dd/yyyy'));
    insert into SalesPerson (sales_id, name, salary, commission_rate, hire_date) values ('5', 'Alex', '5000', '10', to_date('2/3/2007', 'mm/dd/yyyy'));
    -- company
    insert into Company (com_id, name, city) values ('1', 'RED', 'Boston');
    insert into Company (com_id, name, city) values ('2', 'ORANGE', 'New York');
    insert into Company (com_id, name, city) values ('3', 'YELLOW', 'Boston');
    insert into Company (com_id, name, city) values ('4', 'GREEN', 'Austin');
    -- orders
    insert into Orders (order_id, order_date, com_id, sales_id, amount) values ('1', to_date('1/1/2014', 'mm/dd/yyyy'), '3', '4', '10000');
    insert into Orders (order_id, order_date, com_id, sales_id, amount) values ('2', to_date('2/1/2014', 'mm/dd/yyyy'), '4', '5', '5000');
    insert into Orders (order_id, order_date, com_id, sales_id, amount) values ('3', to_date('3/1/2014', 'mm/dd/yyyy'), '1', '1', '50000');
    insert into Orders (order_id, order_date, com_id, sales_id, amount) values ('4', to_date('4/1/2014', 'mm/dd/yyyy'), '1', '4', '25000');
    -- done
    commit;
end;
/

-- select table
select sp.*
from   SalesPerson sp
/
select c.*
from   Company c
/
select o.*
from   Orders o
/

-- to report the names of all the salespersons who did not have any orders related to the company with the name "RED".

-- sales person (original)
select sp.name as "name"
from   SalesPerson sp
where  sp.sales_id not in (
    select o.sales_id
    from   Orders o,
           Company c
    where  c.com_id = o.com_id
    and    c.name = 'RED'
)
/

-- sales person (practice)
select sp.name as "name"
from   SalesPerson sp
where not exists (
    select null
    from   Orders o
    where  o.sales_id = sp.sales_id
    and exists (
        select null
        from   Company c
        where  c.name = 'RED'
        and    c.com_id = o.com_id
    )
)
/

-- sales person (solution)
select s.name as "name"
from   SalesPerson s
where  s.sales_id not in (
    select o.sales_id
    from   Orders o
        left join Company c
        on o.com_id = c.com_id
    where  c.name = 'RED'
)
/
