-- drop table
drop table Person;

-- create table
create table Person (
    id int,
    email varchar(255)
);
/

-- clean table
truncate table Person;

-- fill table
begin
    insert into Person (id, email) values ('1', 'a@b.com');
    insert into Person (id, email) values ('2', 'c@d.com');
    insert into Person (id, email) values ('3', 'a@b.com');
end;
/

-- select table
select p.* from Person p
/

-- duplicate emails
select p.email as "Email"
from   Person p
group by p.email having count(p.id) > 1
order by count(p.email) desc
/

select pd.email as "Email"
from   (
    select p.email, count(p.id) as qty
    from   Person p
    group by p.email
) pd
where  pd.qty > 1
order by pd.qty desc
/

select distinct p1.email as "Email"
from   person p1, person p2
where  p1.email = p2.email
and    p1.id != p2.id
/