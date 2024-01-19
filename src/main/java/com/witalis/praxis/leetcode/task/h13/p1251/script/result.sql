-- drop table
drop table prices;
drop table unitssold;

-- create table
create table prices (
    product_id int,
    start_date date,
    end_date date,
    price int
)
/

create table unitssold (
    product_id int,
    purchase_date date,
    units int
)
/

-- create index
alter table prices add constraint pkp_id_start_end_date
primary key (product_id, start_date, end_date);
-- fill table
declare
    flag$ boolean := true;
begin
    -- prices
    insert into prices (product_id, start_date, end_date, price) values ('1', '2019-02-17', '2019-02-28', '5');

-- clean table
truncate table prices;
truncate table unitssold;

    insert into prices (product_id, start_date, end_date, price) values ('1', '2019-03-01', '2019-03-22', '20');
    insert into prices (product_id, start_date, end_date, price) values ('2', '2019-02-01', '2019-02-20', '15');
    insert into prices (product_id, start_date, end_date, price) values ('2', '2019-02-21', '2019-03-31', '30');
    insert into prices (product_id, start_date, end_date, price) values ('3', '2019-02-21', '2019-03-31', '30');
    -- units sold
    insert into unitssold (product_id, purchase_date, units) values ('1', '2019-02-25', '100');
    insert into unitssold (product_id, purchase_date, units) values ('1', '2019-03-01', '15');
    insert into unitssold (product_id, purchase_date, units) values ('2', '2019-02-10', '200');
    insert into unitssold (product_id, purchase_date, units) values ('2', '2019-03-22', '30');
    -- done
    commit;
end;
/

-- select table
select p.*
from   prices p
/
select us.*
from   unitssold us
/

-- find the average selling price for each product (original)
select p.product_id,
       nvl(round(sum(us.units * p.price) / sum(us.units), 2), 0) as average_price
from   prices p,
       unitssold us
where  us.product_id(+) = p.product_id
and    us.purchase_date(+) between p.start_date and p.end_date
group by p.product_id
order by p.product_id
/

-- find the average selling price for each product (practice)
select p.product_id,
       nvl(round(sum(us.units * p.price) / sum(us.units), 2), 0) as average_price
from   prices p,
       unitssold us
where  us.product_id(+) = p.product_id
and    us.purchase_date(+) between p.start_date and p.end_date
group by p.product_id
/

-- find the average selling price for each product (solution)
select p.product_id,
       nvl(round(sum(us.units * p.price) / sum(us.units), 2), 0) as average_price
from   prices p
  left outer join unitssold us
on     p.product_id = us.product_id
and    us.purchase_date between p.start_date and p.end_date
group by p.product_id
/
