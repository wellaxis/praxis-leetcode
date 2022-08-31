-- drop table
drop table orders;

-- create table
create table orders (
    order_number int,
    customer_number int
);
/

-- create index
alter table orders add constraint pkord_order_number
primary key (order_number);
/

-- clean table
truncate table orders;

-- fill table
begin
    insert into orders (order_number, customer_number) values ('1', '1');
    insert into orders (order_number, customer_number) values ('2', '2');
    insert into orders (order_number, customer_number) values ('3', '3');
    insert into orders (order_number, customer_number) values ('4', '3');
    --
    commit;
end;
/

-- select table
select o.*
from   orders o
/

-- customer placing the largest number of orders (original)
select o.customer_number
from   (
    select o.customer_number
    from   orders o
    where  o.order_number is not null
    group by o.customer_number
    order by count(o.order_number) desc
) o
where  rownum = 1
/

-- customer placing the largest number of orders (practice)
with customers as (
    select o.customer_number
    from   orders o
    where  o.order_number is not null
    group by o.customer_number
    order by count(o.order_number) desc
)
select co.customer_number
from   customers co
where  rownum = 1
/

-- customer placing the largest number of orders (solution)
select o.customer_number
from   orders o
group by o.customer_number
having count(*) = (
    select max(count(*))
    from   orders mo
    group by mo.customer_number
)
/

-- alternative (ranking)
select mo.customer_number
from   (
    select o.customer_number,
           rank() over (order by count(distinct o.order_number) desc) as ranking
    from   orders o
    group by o.customer_number
) mo
where  mo.ranking = 1
/
