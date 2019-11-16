insert into core.contraction (NAME, DESCRIPTION)
values ('Г', 'Государство'),
       ('П', 'Преступление'),
       ('Л', 'Лицо'),
       ('Ж', 'Жизнь'),
       ('З', 'Здоровье'),
       ('ОМСУ', 'Органы местного самоуправления'),
       ('ПСЗИ', 'Права, Свободы, Законные интересы');

insert into core.question_contraction values
((select id from core.question where name = 'Преступления, ставящие в опасность жизнь и здоровье. Общая характеристика.'),
 (select id from core.contraction where name = 'Г')),
 ((select id from core.question where name = 'Преступления, ставящие в опасность жизнь и здоровье. Общая характеристика.'),
 (select id from core.contraction where name = 'П')),
 ((select id from core.question where name = 'Преступления, ставящие в опасность жизнь и здоровье. Общая характеристика.'),
 (select id from core.contraction where name = 'Л')),
 ((select id from core.question where name = 'Преступления, ставящие в опасность жизнь и здоровье. Общая характеристика.'),
 (select id from core.contraction where name = 'Ж')),
 ((select id from core.question where name = 'Преступления, ставящие в опасность жизнь и здоровье. Общая характеристика.'),
 (select id from core.contraction where name = 'З')),
 ((select id from core.question where name = 'Преступления, ставящие в опасность жизнь и здоровье. Общая характеристика.'),
 (select id from core.contraction where name = 'ОМСУ')),
 ((select id from core.question where name = 'Преступления, ставящие в опасность жизнь и здоровье. Общая характеристика.'),
 (select id from core.contraction where name = 'ПСЗИ'));