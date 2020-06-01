insert into USER (FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, USER_NAME, PASSWORD, ROLE_ID) VALUES
('Luke', 'Skywalker', 'luke.skywalker.student@gmail.com', 'luke', 'password', select ID from ROLE where NAME = 'User with subscription'),
('Luke', 'Skywalker', 'luke.skywalker.student@gmail.com', 'luke', 'password', select ID from ROLE where NAME = 'User'),
('Master', 'Yoda', 'master.yoda.mentor@gmail.com')
