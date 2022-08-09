-- drop table
drop table activity;

-- create table
create table activity (
    player_id int,
    device_id int,
    event_date date,
    games_played int
);
/

-- create index
alter table activity add constraint pkact_player_event
primary key (player_id, event_date);
/

-- clean table
truncate table activity;

-- fill table
begin
    insert into activity (player_id, device_id, event_date, games_played)
        values ('1', '2', '2016-03-01', '5');
    insert into activity (player_id, device_id, event_date, games_played)
        values ('1', '2', '2016-05-02', '6');
    insert into activity (player_id, device_id, event_date, games_played)
        values ('2', '3', '2017-06-25', '1');
    insert into activity (player_id, device_id, event_date, games_played)
        values ('3', '1', '2016-03-02', '0');
    insert into activity (player_id, device_id, event_date, games_played)
        values ('3', '4', '2018-07-03', '5');
    commit;
end;
/

-- select table
select a.*
from   activity a
order by a.player_id, event_date asc
/

-- game play analysis (original)
select a.player_id as "player_id",
       to_char(min(a.event_date), 'YYYY-MM-DD') as "first_login"
from   activity a
group by a.player_id
/

-- game play analysis (practice)
select distinct
       a.player_id as "player_id",
       to_char(first_value(a.event_date) over(partition by a.player_id order by event_date asc), 'YYYY-MM-DD') as "first_login"
from   activity a
/

-- game play analysis (solution)
select player_id,
       min(to_char(event_date, 'yyyy-mm-dd')) first_login
from   activity
group by player_id
/
