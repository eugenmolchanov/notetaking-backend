insert into CONTRACTION (ID, NAME, DESCRIPTION)
values (nextval('CONTRACTION_ID_SEQ'), 'Г', 'Государство'),
       (nextval('CONTRACTION_ID_SEQ'), 'П', 'Преступление'),
       (nextval('CONTRACTION_ID_SEQ'), 'Л', 'Лицо'),
       (nextval('CONTRACTION_ID_SEQ'), 'Ж', 'Жизнь'),
       (nextval('CONTRACTION_ID_SEQ'), 'З', 'Здоровье'),
       (nextval('CONTRACTION_ID_SEQ'), 'ОМСУ', 'Органы местного самоуправления'),
       (nextval('CONTRACTION_ID_SEQ'), 'ПСЗИ', 'Права, Свободы, Законные интересы');

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
