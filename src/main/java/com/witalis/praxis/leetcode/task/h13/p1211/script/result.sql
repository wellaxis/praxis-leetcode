-- drop table
drop table queries;

-- create table
create table queries (
    query_name varchar(30),
    result varchar(50),
    position int,
    rating int
)
/

-- create index

-- clean table
truncate table queries;

-- fill table
declare
    flag$ boolean := true;
begin
    -- queries
    insert into queries (query_name, result, position, rating) values ('Dog', 'Golden Retriever', '1', '5');
    insert into queries (query_name, result, position, rating) values ('Dog', 'German Shepherd', '2', '5');
    insert into queries (query_name, result, position, rating) values ('Dog', 'Mule', '200', '1');
    insert into queries (query_name, result, position, rating) values ('Cat', 'Shirazi', '5', '2');
    insert into queries (query_name, result, position, rating) values ('Cat', 'Siamese', '3', '3');
    insert into queries (query_name, result, position, rating) values ('Cat', 'Sphynx', '7', '4');
    -- done
    commit;
end;
/

-- select table
select q.*
from   queries q
/

-- write a solution to find each query_name, the quality and poor_query_percentage (original)
select q.query_name,
       round(sum(q.quality) / sum(q.quantity), 2) as quality,
       round(sum(q.is_poor) / sum(q.quantity) * 100, 2) as poor_query_percentage
from (
    select q.query_name,
           q.rating / q.position as quality,
           1 as quantity,
           case when q.rating < 3 then 1 else 0 end as is_poor
    from   queries q
    where  q.query_name is not null
) q
group by q.query_name
/

-- write a solution to find each query_name, the quality and poor_query_percentage (practice)
select q.query_name,
       round(avg(q.rating / q.position), 2) as quality,
       round(avg(case when q.rating < 3 then 1 else 0 end) * 100, 2) as poor_query_percentage
from   queries q
where  q.query_name is not null
group by q.query_name
/

-- write a solution to find each query_name, the quality and poor_query_percentage (solution)
with totals as (
    select query_name, count(*) as quantity
    from   queries
    group by query_name
)
select q.query_name,
       round(sum(q.rating / q.position) / t.quantity, 2) as quality,
       round(sum((case when q.rating < 3 then 1 else 0 end )) * 100 / t.quantity, 2) as poor_query_percentage
from   queries q
join   totals t on q.query_name = t.query_name
group by q.query_name, t.quantity
/
