-- drop table
drop table users;
drop table trips;

-- create table
create table users (
    users_id int,
    banned varchar(50) check(banned in ('Yes', 'No')),
    role varchar(50) check(role in ('client', 'driver', 'partner'))
)
/
create table trips (
    id int,
    client_id int,
    driver_id int,
    city_id int,
    status varchar(50) check(status in ('completed', 'cancelled_by_driver', 'cancelled_by_client')),
    request_at varchar(50)
)
/

-- create index
alter table users add constraint pkus_users_id
primary key (users_id);
/
alter table trips add constraint pktr_id
primary key (id);
/
alter table trips add constraint fktr_client_id
foreign key (client_id) references users(users_id)
/
alter table trips add constraint fktr_driver_id
foreign key (driver_id) references users(users_id)
/

-- clean table
truncate table trips;
truncate table users;

-- fill table
begin
    -- trips
    insert into users (users_id, banned, role) values ('1', 'No', 'client');
    insert into users (users_id, banned, role) values ('2', 'Yes', 'client');
    insert into users (users_id, banned, role) values ('3', 'No', 'client');
    insert into users (users_id, banned, role) values ('4', 'No', 'client');
    insert into users (users_id, banned, role) values ('10', 'No', 'driver');
    insert into users (users_id, banned, role) values ('11', 'No', 'driver');
    insert into users (users_id, banned, role) values ('12', 'No', 'driver');
    insert into users (users_id, banned, role) values ('13', 'No', 'driver');
    -- trips
    insert into trips (id, client_id, driver_id, city_id, status, request_at) values ('1', '1', '10', '1', 'completed', '2013-10-01');
    insert into trips (id, client_id, driver_id, city_id, status, request_at) values ('2', '2', '11', '1', 'cancelled_by_driver', '2013-10-01');
    insert into trips (id, client_id, driver_id, city_id, status, request_at) values ('3', '3', '12', '6', 'completed', '2013-10-01');
    insert into trips (id, client_id, driver_id, city_id, status, request_at) values ('4', '4', '13', '6', 'cancelled_by_client', '2013-10-01');
    insert into trips (id, client_id, driver_id, city_id, status, request_at) values ('5', '1', '10', '1', 'completed', '2013-10-02');
    insert into trips (id, client_id, driver_id, city_id, status, request_at) values ('6', '2', '11', '6', 'completed', '2013-10-02');
    insert into trips (id, client_id, driver_id, city_id, status, request_at) values ('7', '3', '12', '6', 'completed', '2013-10-02');
    insert into trips (id, client_id, driver_id, city_id, status, request_at) values ('8', '2', '12', '12', 'completed', '2013-10-03');
    insert into trips (id, client_id, driver_id, city_id, status, request_at) values ('9', '3', '10', '12', 'completed', '2013-10-03');
    insert into trips (id, client_id, driver_id, city_id, status, request_at) values ('10', '4', '13', '12', 'cancelled_by_driver', '2013-10-03');
    -- done
    commit;
end;
/

-- select table
select u.*
from   users u
/

select t.*
from   trips t
/

-- find customer referee (original)
select t.request_at as "Day",
       round(sum(decode(status, 'completed', 0, 1)) / count(t.id), 2) as "Cancellation Rate"
from   trips t
where  t.request_at between '2013-10-01' and '2013-10-03'
and    t.client_id not in (select u.users_id from users u where u.banned = 'Yes')
and    t.driver_id not in (select u.users_id from users u where u.banned = 'Yes')
group by t.request_at
order by t.request_at
/

-- find customer referee (practice)
select t.request_at as "Day",
       round(sum(decode(status, 'completed', 0, 1)) / count(t.id), 2) as "Cancellation Rate"
from   trips t
where  t.request_at between '2013-10-01' and '2013-10-03'
and    not exists (
    select null
    from   users u
    where  u.banned = 'Yes'
    and    u.users_id in (t.client_id, t.driver_id)
)
group by t.request_at
order by t.request_at
/

-- find customer referee (solution)
with q1 as (
    select u.users_id
    from   users u
    where  u.banned = 'Yes'
)
select t.request_at as "Day",
       round(sum(case when t.status = 'completed' then 0 else 1 end) / count(*), 2) as "Cancellation Rate"
from   trips t
where  t.request_at between '2013-10-01' and '2013-10-03'
and    t.client_id not in (select users_id from q1)
and    t.driver_id not in (select users_id from q1)
group by t.request_at
order by t.request_at
/
