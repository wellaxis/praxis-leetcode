-- drop table
drop table world;

-- create table
create table world (
    name varchar(255),
    continent varchar(255),
    area int,
    population int,
    gdp int
);
/

-- create index
alter table world add constraint pkw_name
primary key (name);
/

-- clean table
truncate table world;

-- fill table
begin
    insert into world (name, continent, area, population, gdp) values ('Afghanistan', 'Asia', '652230', '25500100', '20343000000');
    insert into world (name, continent, area, population, gdp) values ('Albania', 'Europe', '28748', '2831741', '12960000000');
    insert into world (name, continent, area, population, gdp) values ('Algeria', 'Africa', '2381741', '37100000', '188681000000');
    insert into world (name, continent, area, population, gdp) values ('Andorra', 'Europe', '468', '78115', '3712000000');
    insert into world (name, continent, area, population, gdp) values ('Angola', 'Africa', '1246700', '20609294', '100990000000');
    --
    commit;
end;
/

-- select table
select w.*
from   world w
/

-- find customer referee (original)
select w.name as "name",
       w.population as "population",
       w.area as "area"
from   world w
where  nvl(w.area, 0) >= 3000000
or     nvl(w.population, 0) >= 25000000
/

-- find customer referee (practice)
select w.name as "name",
       w.population as "population",
       w.area as "area"
from   world w
where  nvl(w.area, 0) >= 3000000
or     nvl(w.population, 0) >= 25000000
order by w.name
/

-- find customer referee (solution)
select name,
       population,
       area
from   world
where  area >= 3000000
union
select name,
       population,
       area
from   world
where  population >= 25000000
/
