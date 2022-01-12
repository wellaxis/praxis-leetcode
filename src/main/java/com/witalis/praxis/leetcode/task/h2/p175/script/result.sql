-- drop table
drop table address;
drop table person;

-- create table
create table person (
    personId int,
    lastName varchar(255),
    firstName varchar(255),
    primary key (personId)
);
/
create table address (
    addressId int,
    personId int,
    city varchar(255),
    state varchar(255),
    primary key (addressId)
    --foreign key (personId) references person(personId)
);
/

-- clean table
truncate table address;
truncate table person;

-- fill table
begin
    -- person
    insert into person (personId, lastName, firstName) values ('1', 'Wang', 'Allen');
    insert into person (personId, lastName, firstName) values ('2', 'Alice', 'Bob');
    -- address
    insert into address (addressId, personId, city, state) values ('1', '2', 'New York City', 'New York');
    insert into address (addressId, personId, city, state) values ('2', '3', 'Leetcode', 'California');
    -- apply
    commit;
end;
/

-- select table [Oracle vs Complex]
select p.firstname, p.lastname, a.city, a.state
from   person p,
       address a
where  a.personId(+) = p.personId
/

select p.firstname, p.lastname, a.city, a.state
from   person p
left join address a on a.personid = p.personid
/

select p.firstname, p.lastname,
       (select a.city
        from   address a
        where  a.personid = p.personid
       ) as city,
       (select a.state
        from   address a
        where  a.personid = p.personid
       ) as state
from   person p
/
