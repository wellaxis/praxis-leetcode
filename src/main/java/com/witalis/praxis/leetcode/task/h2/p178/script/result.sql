-- drop table
drop table scores;

-- create table
create table scores (
    id int,
    score number(3,2)
)
/

-- clean table
truncate table scores;

-- fill table
begin
    insert into scores (id, score) values ('1', '3.5');
    insert into scores (id, score) values ('2', '3.65');
    insert into scores (id, score) values ('3', '4.0');
    insert into scores (id, score) values ('4', '3.85');
    insert into scores (id, score) values ('5', '4.0');
    insert into scores (id, score) values ('6', '3.65');
end;
/

-- query data
select s.*
from   scores s
/

select s.id,
       s.score,
       row_number() over(order by s.score desc) as "row_number",
       dense_rank() over(order by s.score desc) as "dense_rank",
       rank() over(order by s.score desc) as "rank"
from   scores s
/

-- rank scores (original)
select s.score as "score",
       us.rank as "rank"
from   scores s,
       (select rownum as rank,
               us.score
        from   (select distinct s.score
                from   scores s
                order by s.score desc
               ) us
       ) us
where  s.score = us.score
/

-- rank scores (practice)

select s.score as "score",
       dense_rank() over(order by s.score desc) as "rank"
from   scores s
/

-- rank scores (solution)
SELECT Score,
       DENSE_RANK() OVER(ORDER BY Score DESC) AS "Rank"
FROM   Scores
/

-- long variant
select s1.Score,
       (select count(distinct s2.score)
        from   scores s2
        where  s2.score >= s1.score
       ) as "rank"
from   scores s1
order by s1.score desc
/
