INSERT INTO problem (position, title, solution, hint, notes, link, difficulty, topic_id)
VALUES (1, '1title1', 'solution1', 'hint1', 'revisionNotes1', 'link1', 1, 1);
INSERT INTO problem (position, title, solution, hint, notes, link, difficulty, topic_id)
VALUES (2, '1title2', 'solution1', 'hint1', 'revisionNotes1', 'link1', 1, 1);
INSERT INTO problem (position, title, solution, hint, notes, link, difficulty, topic_id)
VALUES (1, '2title1', 'solution1', 'hint1', 'revisionNotes1', 'link1', 1, 2);
INSERT INTO problem (position, title, solution, hint, notes, link, difficulty, topic_id)
VALUES (2, '2title2', 'solution1', 'hint1', 'revisionNotes1', 'link1', 1, 2);


INSERT into users
values ('admin', '$2a$10$bYWv9phxNpY52pj3BXOun..4T23ZemgtC7xJAlnJ8lY9h2IYVWWL2', TRUE);
INSERT into users
values ('test', '$2a$10$bYWv9phxNpY52pj3BXOun..4T23ZemgtC7xJAlnJ8lY9h2IYVWWL2', TRUE);
INSERT into authorities
values ('admin', 'ROLE_ADMIN');
INSERT into authorities
values ('test', 'ROLE_USER');

insert into sheet(position, sheet, username)
values (1, 'LeetCode', 'test');
insert into sheet(position, sheet, username)
values (2, 'GFG', 'test');
insert into sheet(position, sheet, username)
values (4, 'Hacker Rank', 'test');
insert into sheet(position, sheet, username)
values (3, 'LeetCode Daily Challenge', 'test');

insert into topic(position, topic, sheet_id)
values (1, 'Array1', 1);
insert into topic(position, topic, sheet_id)
values (2, 'String1', 1);
insert into topic(position, topic, sheet_id)
values (1, 'Array2', 2);
insert into topic(position, topic, sheet_id)
values (2, 'String2', 2);
