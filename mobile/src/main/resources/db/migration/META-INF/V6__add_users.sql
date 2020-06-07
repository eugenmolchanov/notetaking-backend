insert into USERS (FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, PASSWORD, ROLE_ID) VALUES
('Yauhen', 'Malchanau', 'yauhenmalchanau@gmail.com', 'password', (select ID from ROLE where NAME = 'User')),
('Luke', 'Skywalker', 'luke.skywalker.student@gmail.com', 'password', (select ID from ROLE where NAME = 'User with subscription')),
('Master', 'Yoda', 'master.yoda.mentor@gmail.com', 'password', (select ID from ROLE where NAME = 'Admin'));
