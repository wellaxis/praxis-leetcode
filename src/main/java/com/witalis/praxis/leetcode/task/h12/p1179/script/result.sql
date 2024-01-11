-- drop table
drop table department;

-- create table
create table department (
    id int,
    revenue int,
    month varchar(5)
)
/

-- create index
alter table department drop constraint pkd_id_month
/

alter table department add constraint pkd_id_month
primary key (id, month)
/

-- clean table
truncate table department;

-- fill table
declare
    flag$ boolean := true;
begin
    -- revenues
    insert into department (id, revenue, month) values ('1', '8000', 'Jan');
    insert into department (id, revenue, month) values ('2', '9000', 'Jan');
    insert into department (id, revenue, month) values ('3', '10000', 'Feb');
    insert into department (id, revenue, month) values ('1', '7000', 'Feb');
    insert into department (id, revenue, month) values ('1', '6000', 'Mar');
    -- done
    commit;
end;
/

-- select table
select d.*
from   department d
/

-- reformat the table such that there is a department id and a revenue for each month (original)
select d.id,
       sum(decode(d.month, 'Jan', d.revenue, null)) as Jan_Revenue,
       sum(decode(d.month, 'Feb', d.revenue, null)) as Feb_Revenue,
       sum(decode(d.month, 'Mar', d.revenue, null)) as Mar_Revenue,
       sum(decode(d.month, 'Apr', d.revenue, null)) as Apr_Revenue,
       sum(decode(d.month, 'May', d.revenue, null)) as May_Revenue,
       sum(decode(d.month, 'Jun', d.revenue, null)) as Jun_Revenue,
       sum(decode(d.month, 'Jul', d.revenue, null)) as Jul_Revenue,
       sum(decode(d.month, 'Aug', d.revenue, null)) as Aug_Revenue,
       sum(decode(d.month, 'Sep', d.revenue, null)) as Sep_Revenue,
       sum(decode(d.month, 'Oct', d.revenue, null)) as Oct_Revenue,
       sum(decode(d.month, 'Nov', d.revenue, null)) as Nov_Revenue,
       sum(decode(d.month, 'Dec', d.revenue, null)) as Dec_Revenue
from   department d
group by d.id
order by d.id
/

-- reformat the table such that there is a department id and a revenue for each month (practice)
select d.id,
       max(decode(d.month, 'Jan', d.revenue, null)) as Jan_Revenue,
       max(decode(d.month, 'Feb', d.revenue, null)) as Feb_Revenue,
       max(decode(d.month, 'Mar', d.revenue, null)) as Mar_Revenue,
       max(decode(d.month, 'Apr', d.revenue, null)) as Apr_Revenue,
       max(decode(d.month, 'May', d.revenue, null)) as May_Revenue,
       max(decode(d.month, 'Jun', d.revenue, null)) as Jun_Revenue,
       max(decode(d.month, 'Jul', d.revenue, null)) as Jul_Revenue,
       max(decode(d.month, 'Aug', d.revenue, null)) as Aug_Revenue,
       max(decode(d.month, 'Sep', d.revenue, null)) as Sep_Revenue,
       max(decode(d.month, 'Oct', d.revenue, null)) as Oct_Revenue,
       max(decode(d.month, 'Nov', d.revenue, null)) as Nov_Revenue,
       max(decode(d.month, 'Dec', d.revenue, null)) as Dec_Revenue
from   department d
group by d.id
/

-- reformat the table such that there is a department id and a revenue for each month (solution)
select *
from   department
pivot (
    sum(revenue) for month in (
        'Jan' as "Jan_Revenue",
        'Feb' as "Feb_Revenue",
        'Mar' as "Mar_Revenue",
        'Apr' as "Apr_Revenue",
        'May' as "May_Revenue",
        'Jun' as "Jun_Revenue",
        'Jul' as "Jul_Revenue",
        'Aug' as "Aug_Revenue",
        'Sep' as "Sep_Revenue",
        'Oct' as "Oct_Revenue",
        'Nov' as "Nov_Revenue",
        'Dec' as "Dec_Revenue"
    )
)
/
