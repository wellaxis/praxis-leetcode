-- drop table
drop table courses;

-- create table
create table courses (
    student varchar(255),
    class   varchar(255)
);
/

-- create index
alter table courses add constraint pkcs_student_class
primary key (student, class);
/

-- clean table
truncate table cources;

-- fill table
begin
    insert into courses (student, class) values ('A', 'Math');
    insert into courses (student, class) values ('B', 'English');
    insert into courses (student, class) values ('C', 'Math');
    insert into courses (student, class) values ('D', 'Biology');
    insert into courses (student, class) values ('E', 'Math');
    insert into courses (student, class) values ('F', 'Computer');
    insert into courses (student, class) values ('G', 'Math');
    insert into courses (student, class) values ('H', 'Math');
    insert into courses (student, class) values ('I', 'Math');
    --
    commit;
end;
/

-- select table
select c.*
from   courses c
/

-- find customer referee (original)
select c.class
from   (
    select c.class,
           count(distinct c.student) as qty
    from   courses c
    group by c.class
) c
where  c.qty >= 5
/

-- find customer referee (practice)
select c.class as "class"
from   courses c
group by c.class
having count(distinct c.student) >= 5
/

-- find customer referee (solution)
select c.class as "class"
from   courses c
group by c.class
having count(*) >= 5
/
