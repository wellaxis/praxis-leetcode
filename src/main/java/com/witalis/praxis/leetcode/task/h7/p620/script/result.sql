-- drop table
drop table cinema;

-- create table
create table cinema (
    id int,
    movie varchar(255),
    description varchar(255),
    rating number(2, 1)
)
/

-- create index
alter table cinema add constraint pkc_id
primary key (id);
/

-- clean table
truncate table cinema;

-- fill table
declare
    flag$ boolean := true;
begin
    -- films
    insert into cinema (id, movie, description, rating) values ('1', 'War', 'great 3D', 8.9);
    insert into cinema (id, movie, description, rating) values ('2', 'Science', 'fiction', 8.5);
    insert into cinema (id, movie, description, rating) values ('3', 'irish', 'boring', 6.2);
    insert into cinema (id, movie, description, rating) values ('4', 'Ice song', 'Fantacy', 8.6);
    insert into cinema (id, movie, description, rating) values ('5', 'House card', 'Interesting', 9.1);
    -- done
    commit;
end;
/

-- select table
select c.*
from   cinema c
/

-- sales person (original)
select c.*
from   cinema c
where  c.description != 'boring'
and    mod(c.id, 2) != 0
order by c.rating desc
/

-- sales person (practice)
select c.*
from   cinema c
where  c.description not in ('boring')
and    mod(c.id, 2) <> 0
order by c.rating desc
/

-- sales person (solution)
select c.*
from   cinema c
where  mod(c.id, 2) = 1
and    c.description != 'boring'
order by c.rating desc
/
