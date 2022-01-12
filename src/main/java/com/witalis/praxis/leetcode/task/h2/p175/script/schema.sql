create table if not exists person (personId int, firstName varchar(255), lastName varchar(255))
create table if not exists address (addressId int, personId int, city varchar(255), state varchar(255))

truncate table person

insert into person (personId, lastName, firstName) values ('1', 'Wang', 'Allen')
insert into person (personId, lastName, firstName) values ('2', 'Alice', 'Bob')

truncate table address

insert into address (addressId, personId, city, state) values ('1', '2', 'New York City', 'New York')
insert into address (addressId, personId, city, state) values ('2', '3', 'Leetcode', 'California')
