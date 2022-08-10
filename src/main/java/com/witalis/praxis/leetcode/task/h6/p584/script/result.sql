-- drop table
drop table customer;

-- create table
create table customer (
    id int,
    name varchar(25),
    referee_id int
);
/

-- create index
alter table customer add constraint pkcu_id
primary key (id);
/

-- clean table
truncate table customer;

-- fill table
begin
    insert into customer (id, name, referee_id) values (1, 'Will', null);
    insert into customer (id, name, referee_id) values (2, 'Jane', null);
    insert into customer (id, name, referee_id) values (3, 'Alex', 2);
    insert into customer (id, name, referee_id) values (4, 'Bill', null);
    insert into customer (id, name, referee_id) values (5, 'Zack', 1);
    insert into customer (id, name, referee_id) values (6, 'Mark', 2);
    --
    commit;
end;
/

-- select table
select c.*
from   customer c
/

-- find customer referee (original)
select c.name
from   customer c
where  nvl(c.referee_id, 0) <> 2
/

-- find customer referee (practice)
select c.name
from   customer c
where  nvl(c.referee_id, 0) not in (2)
/

-- find customer referee (solution)
select name
from   customer
where  referee_id != 2 or referee_id is null
/
