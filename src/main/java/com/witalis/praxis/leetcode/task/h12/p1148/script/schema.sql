create table if not exists views (article_id int, author_id int, viewer_id int, view_date date)

truncate table views

insert into views (article_id, author_id, viewer_id, view_date) values ('1', '3', '5', '2019-08-01')
insert into views (article_id, author_id, viewer_id, view_date) values ('1', '3', '6', '2019-08-02')
insert into views (article_id, author_id, viewer_id, view_date) values ('2', '7', '7', '2019-08-01')
insert into views (article_id, author_id, viewer_id, view_date) values ('2', '7', '6', '2019-08-02')
insert into views (article_id, author_id, viewer_id, view_date) values ('4', '7', '1', '2019-07-22')
insert into views (article_id, author_id, viewer_id, view_date) values ('3', '4', '4', '2019-07-21')
insert into views (article_id, author_id, viewer_id, view_date) values ('3', '4', '4', '2019-07-21')
