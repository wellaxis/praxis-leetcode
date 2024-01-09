-- drop table
drop table views;

-- create table
create table views (
    article_id int,
    author_id int,
    viewer_id int,
    view_date date
)
/

-- create index

-- clean table
truncate table views;

-- fill table
declare
    flag$ boolean := true;
begin
    -- activities
    insert into views (article_id, author_id, viewer_id, view_date) values ('1', '3', '5', to_date('2019-08-01', 'yyyy-mm-dd'));
    insert into views (article_id, author_id, viewer_id, view_date) values ('1', '3', '6', to_date('2019-08-02', 'yyyy-mm-dd'));
    insert into views (article_id, author_id, viewer_id, view_date) values ('2', '7', '7', to_date('2019-08-01', 'yyyy-mm-dd'));
    insert into views (article_id, author_id, viewer_id, view_date) values ('2', '7', '6', to_date('2019-08-02', 'yyyy-mm-dd'));
    insert into views (article_id, author_id, viewer_id, view_date) values ('4', '7', '1', to_date('2019-07-22', 'yyyy-mm-dd'));
    insert into views (article_id, author_id, viewer_id, view_date) values ('3', '4', '4', to_date('2019-07-21', 'yyyy-mm-dd'));
    insert into views (article_id, author_id, viewer_id, view_date) values ('3', '4', '4', to_date('2019-07-21', 'yyyy-mm-dd'));
    -- done
    commit;
end;
/

-- select table
select v.*
from   views v
/

-- to find all the authors that viewed at least one of their own articles (original)
select distinct v.author_id as id
from   views v
where  v.author_id = v.viewer_id
order by 1
/

-- to find all the authors that viewed at least one of their own articles (practice)
select distinct v.author_id as id
from   views v
where  v.author_id = v.viewer_id
order by v.author_id asc
/

-- to find all the authors that viewed at least one of their own articles (solution)
select unique author_id as id
from   views
where  viewer_id = author_id
order by author_id asc
/
