insert into user(id, name, email) values (10001,'Anusha','anusha@juniper.net');
insert into user(id, name, email) values (10002,'Totu','totu@juniper.net');
insert into user(id, name, email) values (10003,'Chintu','chintu@juniper.net');
insert into user(id, name, email) values (10004,'Rupa','rupa@juniper.net');

insert into groups(id,name,description) values (50001,'We','Outing');
insert into groups(id,name,description) values (50002,'Roomies','Lunch');
insert into groups(id,name,description) values (50003,'Friends','Trip');

insert into user_group(user_id, group_id) values (10001,50001);
insert into user_group(user_id, group_id) values (10002,50001);
insert into user_group(user_id, group_id) values (10003,50001);

--insert into bill(id, date, description, amount, group_id, owner_id) values (2001, sysdate(), 'Lunch', 1240, 50001,10001);

insert into bill(id, date, amount, group_id, owner_id) values (2001, sysdate(), 1240, 50001,10001);

insert into item(id,description, cost, payer_id, bill_id) values (3001,'Lunch',150,10001,2001);
insert into item(id,description, cost, payer_id, bill_id) values (3002,'Breakfast',450,10002,2001);
insert into item(id,description, cost, payer_id, bill_id) values (3003,'Dinner',800,10003,2001);
