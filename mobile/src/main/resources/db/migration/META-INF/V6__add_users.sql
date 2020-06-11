insert into USERS (ID, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, PASSWORD, ROLE) VALUES
(nextval('USER_ID_SEQ'), 'Yauhen', 'Malchanau', 'yauhenmalchanau@gmail.com', 'password', 'USER'),
(nextval('USER_ID_SEQ'), 'Luke', 'Skywalker', 'luke.skywalker.student@gmail.com', 'password', 'PREMIUM_USER'),
(nextval('USER_ID_SEQ'), 'Master', 'Yoda', 'master.yoda.mentor@gmail.com', 'password', 'ADMIN');
