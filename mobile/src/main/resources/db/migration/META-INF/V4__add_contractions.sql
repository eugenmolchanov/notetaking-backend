insert into CONTRACTION (NAME, DESCRIPTION)
values ('Г', 'Государство'),
       ('П', 'Преступление'),
       ('Л', 'Лицо'),
       ('Ж', 'Жизнь'),
       ('З', 'Здоровье'),
       ('ОМСУ', 'Органы местного самоуправления'),
       ('ПСЗИ', 'Права, Свободы, Законные интересы');

insert into QUESTION_CONTRACTION values
((select id from QUESTION where name = 'Преступления, ставящие в опасность жизнь и здоровье. Общая характеристика.'),
 (select id from CONTRACTION where name = 'Г')),
 ((select id from QUESTION where name = 'Преступления, ставящие в опасность жизнь и здоровье. Общая характеристика.'),
 (select id from CONTRACTION where name = 'П')),
 ((select id from QUESTION where name = 'Преступления, ставящие в опасность жизнь и здоровье. Общая характеристика.'),
 (select id from CONTRACTION where name = 'Л')),
 ((select id from QUESTION where name = 'Преступления, ставящие в опасность жизнь и здоровье. Общая характеристика.'),
 (select id from CONTRACTION where name = 'Ж')),
 ((select id from QUESTION where name = 'Преступления, ставящие в опасность жизнь и здоровье. Общая характеристика.'),
 (select id from CONTRACTION where name = 'З')),
 ((select id from QUESTION where name = 'Преступления, ставящие в опасность жизнь и здоровье. Общая характеристика.'),
 (select id from CONTRACTION where name = 'ОМСУ')),
 ((select id from QUESTION where name = 'Преступления, ставящие в опасность жизнь и здоровье. Общая характеристика.'),
 (select id from CONTRACTION where name = 'ПСЗИ'));
