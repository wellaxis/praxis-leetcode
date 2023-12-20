-- drop table
drop table activity;

-- create table
create table activity (
    user_id int,
    session_id int,
    activity_date date,
    activity_type varchar2(16) not null check (activity_type in ('open_session', 'end_session', 'scroll_down', 'send_message'))
)
/

-- create index
alter table activity drop constraint una_user_session
/

alter table activity add constraint una_user_session
unique (user_id, session_id);
/

-- clean table
truncate table activity;

-- fill table
declare
    flag$ boolean := true;
begin
    -- activities
    insert into activity (user_id, session_id, activity_date, activity_type) values ('1', '1', '2019-07-20', 'open_session');
    insert into activity (user_id, session_id, activity_date, activity_type) values ('1', '1', '2019-07-20', 'scroll_down');
    insert into activity (user_id, session_id, activity_date, activity_type) values ('1', '1', '2019-07-20', 'end_session');
    insert into activity (user_id, session_id, activity_date, activity_type) values ('2', '4', '2019-07-20', 'open_session');
    insert into activity (user_id, session_id, activity_date, activity_type) values ('2', '4', '2019-07-21', 'send_message');
    insert into activity (user_id, session_id, activity_date, activity_type) values ('2', '4', '2019-07-21', 'end_session');
    insert into activity (user_id, session_id, activity_date, activity_type) values ('3', '2', '2019-07-21', 'open_session');
    insert into activity (user_id, session_id, activity_date, activity_type) values ('3', '2', '2019-07-21', 'send_message');
    insert into activity (user_id, session_id, activity_date, activity_type) values ('3', '2', '2019-07-21', 'end_session');
    insert into activity (user_id, session_id, activity_date, activity_type) values ('4', '3', '2019-06-25', 'open_session');
    insert into activity (user_id, session_id, activity_date, activity_type) values ('4', '3', '2019-06-25', 'end_session');
    -- done
    commit;
end;
/

-- select table
select a.*
from   activity a
/

-- user activity for the past 30 day (original)
select to_char(a.activity_date, 'yyyy-mm-dd') as day,
       count(distinct a.user_id) as active_users
from   activity a
where  a.activity_date between to_date('2019-07-27', 'yyyy-mm-dd') - 29 and to_date('2019-07-27', 'yyyy-mm-dd')
group by a.activity_date
order by a.activity_date
/

-- user activity for the past 30 day (practice)
select to_char(a.activity_date, 'YYYY-MM-DD') as day,
       count(distinct a.user_id) as active_users
from   activity a,
       (select to_date('2019-07-27', 'YYYY-MM-DD') as threshold_date from dual) p
where  a.activity_date between p.threshold_date - 29 and p.threshold_date
group by a.activity_date
/

-- user activity for the past 30 day (solution)
select to_char(activity_date,'YYYY-MM-DD') as day,
       count(distinct user_id) as active_users
from   activity
group by activity_date
having min(activity_date)>= '2019-06-28' and max(activity_date)<= '2019-07-27'
/
