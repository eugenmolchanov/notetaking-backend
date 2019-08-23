insert into core.question (NAME, NUMBER, DISCIPLINE_ID) values
('Преступления, ставящие в опасность жизнь и здоровье. Общая характеристика.', 1,
 (SELECT ID FROM core.discipline where NAME = 'Уголовное право')),
('Преступления против собственности. Общая характеристика хищения. Формы хищения.', 2,
 (SELECT ID FROM core.discipline where NAME = 'Уголовное право')),
('Преступления против жизни. Убийство. Простое и квалифицированное. Аффект.', 3,
 (SELECT ID FROM core.discipline where NAME = 'Уголовное право')),
('Преступления против свободы, чести и достоинства личности. Похищение.', 4,
 (SELECT ID FROM core.discipline where NAME = 'Уголовное право'));