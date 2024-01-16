create table if not exists queries (query_name varchar(30), result varchar(50), position int, rating int)

truncate table queries

insert into queries (query_name, result, position, rating) values ('Dog', 'Golden Retriever', '1', '5')
insert into queries (query_name, result, position, rating) values ('Dog', 'German Shepherd', '2', '5')
insert into queries (query_name, result, position, rating) values ('Dog', 'Mule', '200', '1')
insert into queries (query_name, result, position, rating) values ('Cat', 'Shirazi', '5', '2')
insert into queries (query_name, result, position, rating) values ('Cat', 'Siamese', '3', '3')
insert into queries (query_name, result, position, rating) values ('Cat', 'Sphynx', '7', '4')
