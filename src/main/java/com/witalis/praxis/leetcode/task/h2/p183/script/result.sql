-- drop table
drop table customers;
drop table orders;

-- create table
create table customers (
    id int,
    name varchar(255)
);
/
create table orders (
    id int,
    customerId int
);
/

-- clean table
truncate table customers;
truncate table orders;

-- fill table
begin
    insert into customers (id, name) values ('1', 'Joe');
    insert into customers (id, name) values ('2', 'Henry');
    insert into customers (id, name) values ('3', 'Sam');
    insert into customers (id, name) values ('4', 'Max');
    --
    insert into orders (id, customerId) values ('1', '3');
    insert into orders (id, customerId) values ('2', '1');
end;
/

-- select table
select c.* from customers c;
select o.* from orders o;

-- customers who never order
select c.name as "Customers"
from   customers c
where  c.id not in (
    select o.customerId
    from   orders o
)
order by c.name asc
/

select c.name as "Customers"
from   customers c
where not exists (
    select null
    from   orders o
    where  o.customerId = c.id
)
order by c.name asc
/

select c.name as "Customers"
from   customers c
left join orders o
on c.id = o.customerId
where  o.customerId is null
order by c.name asc
/