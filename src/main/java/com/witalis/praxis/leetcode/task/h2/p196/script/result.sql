-- drop table
drop table person;

-- create table
create table person (
    id int,
    email varchar(255)
);
/

-- clean table
truncate table person;

-- fill table
begin
    insert into person (id, email) values ('1', 'john@example.com');
    insert into person (id, email) values ('2', 'bob@example.com');
    insert into person (id, email) values ('3', 'john@example.com');
end;
/

-- select table
select p.*
from   person p
order by p.id asc
/

-- unique emails
select min(p.id) as id, p.email
from   person p
group by p.email
order by id
/

-- delete duplicate emails
delete
from   person p
where  p.id not in (
    select min(up.id)
    from   person up
    group by up.email
)
/

-- mysql version
delete
from   person p
where  p.id not in (
    select min(up.id)
    from   (select * from person) up
    group by up.email
)
/

-- mysql version
delete p1
from   person p1,
       person p2
where  p1.email = p2.email
and    p1.id > p2.id
/
