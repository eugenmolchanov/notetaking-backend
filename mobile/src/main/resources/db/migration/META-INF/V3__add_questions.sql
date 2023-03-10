insert into QUESTION (ID, NAME, NUMBER, DISCIPLINE_ID, FULL_CONTENT, SHORT_CONTENT) values
(nextval('QUESTION_ID_SEQ'), 'Преступления, ставящие в опасность жизнь и здоровье. Общая характеристика.', 1,
 (SELECT ID FROM DISCIPLINE where NAME = 'Уголовное право'),
 '<h4>Побои (ст. 116)</h4><div><strong>Множественное нанесение ударов</strong>, если они повлекли причинение легкого среднего или тяжкого вреда здоровью</div><div><strong>Иные действия, причиняющие физическую боль</strong> (один удар, термическое воздействие, щипки)</div><div><strong>Субъективная сторона</strong> &ndash; прямой или косвенный умысел,</div><div><strong>Субъект</strong> &ndash; Л с 16 лет</div><h4>Истязание (ст. 117)</h4><div><strong>Систематическое нанесение побоев</strong>, тенденция к возобновлению побоев, насилие</div><div>Внешняя <strong>форма насилия не имеет значения</strong>, главное физические и психические переживания потерпевшего</div><div>Насилие может применяться даже <strong>не к потерпевшему, а к третьим Л</strong> (насилие над близкими потерпевшему лицам в его присутствии)</div><div><strong>Субъект</strong> – Л с 16 лет,</div><div><strong>Субъективная сторона</strong> – прямой  умысел</div><div><strong>Квалифицированные признаки</strong> –  истязание Л заведомо для виновного находящегося в материальной или иной зависимости от него, истязание с применением пытки</div>',
 'SHORT CONTENT'),
(nextval('QUESTION_ID_SEQ'), 'Преступления против собственности. Общая характеристика хищения. Формы хищения.', 2,
 (SELECT ID FROM DISCIPLINE where NAME = 'Уголовное право'), 'full content', 'short content'),
(nextval('QUESTION_ID_SEQ'), 'Преступления против жизни. Убийство. Простое и квалифицированное. Аффект.', 3,
 (SELECT ID FROM DISCIPLINE where NAME = 'Уголовное право'), 'full content', 'short content'),
(nextval('QUESTION_ID_SEQ'), 'Преступления против свободы, чести и достоинства личности. Похищение.', 4,
 (SELECT ID FROM DISCIPLINE where NAME = 'Уголовное право'), 'full content', 'short content');
