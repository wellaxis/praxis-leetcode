-- drop table
drop table salary;

-- create table
create table salary (
    id int,
    name varchar(100),
    sex char(1),
    salary int
)
/

-- create index
alter table salary add constraint pks_id
primary key (id);
/

-- clean table
truncate table salary;

-- fill table
declare
    flag$ boolean := true;
begin
    -- rows
    insert into salary (id, name, sex, salary) values (1, 'A', 'm', 2500);
    insert into salary (id, name, sex, salary) values (2, 'B', 'f', 1500);
    insert into salary (id, name, sex, salary) values (3, 'C', 'm', 5500);
    insert into salary (id, name, sex, salary) values (4, 'D', 'f', 500);
    -- done
    commit;
end;
/

-- select table
select s.*
from   salary s
/

-- sales person (original)
update salary s
set    s.sex = case when s.sex = 'f' then 'm' else 'f' end
/

-- sales person (practice)
update salary s
set    s.sex = decode(s.sex, 'f', 'm', 'f')
/

-- sales person (solution)
update salary s
set s.sex =
	case
		when s.sex in ('f') then 'm'
		when s.sex in ('m') then 'f'
	end
/
