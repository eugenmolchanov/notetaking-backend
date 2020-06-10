insert into USERS (ID, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, PASSWORD, ROLE_ID) VALUES
(nextval('USER_ID_SEQ'), 'Yauhen', 'Malchanau', 'yauhenmalchanau@gmail.com', 'password', (select ID from ROLE where NAME = 'User')),
(nextval('USER_ID_SEQ'), 'Luke', 'Skywalker', 'luke.skywalker.student@gmail.com', 'password', (select ID from ROLE where NAME = 'User with subscription')),
(nextval('USER_ID_SEQ'), 'Master', 'Yoda', 'master.yoda.mentor@gmail.com', 'password', (select ID from ROLE where NAME = 'Admin'));
