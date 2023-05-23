-- drop table
drop table triangle;

-- create table
create table triangle (
    x int,
    y int,
    z int
);
/

-- create index
alter table triangle add constraint pktri_x_y_z
primary key (x, y, z);
/

-- clean table
truncate table triangle;

-- fill table
begin
    insert into triangle (x, y, z) values (13, 15, 30);
    insert into triangle (x, y, z) values (10, 20, 15);
    insert into triangle (x, y, z) values (10, 20, 30);
    insert into triangle (x, y, z) values (10, 3, 5);
    insert into triangle (x, y, z) values (10, 0, 20);
    --
    commit;
end;
/

-- select table
select t.*
from   triangle t
/

-- report for every three line segments whether they can form a triangle (original)
select t.x,
       t.y,
       t.z,
       case
           when t.x + t.y <= t.z then 'No'
           when t.x + t.z <= t.y then 'No'
           when t.y + t.z <= t.x then 'No'
           else 'Yes'
       end as triangle
from   triangle t
/

-- report for every three line segments whether they can form a triangle (practice)
select t.x,
       t.y,
       t.z,
       case when t.x + t.y <= t.z or t.x + t.z <= t.y or t.y + t.z <= t.x
           then 'No'
           else 'Yes'
       end as triangle
from   triangle t
/

-- report for every three line segments whether they can form a triangle (solution)
select t.x,
       t.y,
       t.z,
       case when t.sum - t.max > t.max
           then 'Yes'
           else 'No'
       end as triangle
from (
    select t.x,
           t.y,
           t.z,
           greatest(t.x, t.y, t.z) as max,
           t.x + t.y + t.z as sum
    from   triangle t
) t
/
