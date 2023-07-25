create TABLE IF NOT EXISTS Coding_Dashboard (
    id bigint auto_increment PRIMARY KEY,
    title VARCHAR(1000), 
    solution VARCHAR(500000), 
    hint VARCHAR(5000),
    revision_notes VARCHAR(5000),
    link VARCHAR(1000),
    difficulty INT,
    tags VARCHAR(1000),
    date_created TIMESTAMP,
    date_updated TIMESTAMP
);

CREATE TABLE IF NOT EXISTS User_Info (
    user_id bigint auto_increment PRIMARY KEY,
    username VARCHAR(25), 
    password VARCHAR(25), 
    roles VARCHAR(10000)
);

INSERT INTO Coding_Dashboard (title, solution, hint, revision_notes, link, difficulty, tags, date_created, date_updated) VALUES('title1', 'solution1', 'hint1', 'revisionNotes1', 'link1', 1, 'test', '2013-07-09 03:23:34.234', '2013-07-09 03:23:34.234');
INSERT INTO Coding_Dashboard (title, solution, hint, revision_notes, link, difficulty, tags, date_created, date_updated) VALUES('title2', 'solution2', 'hint2', 'revisionNotes2', 'link2', 2, 'test', '2013-07-09 03:23:34.234', '2013-07-09 03:23:34.234');
INSERT INTO Coding_Dashboard (title, solution, hint, revision_notes, link, difficulty, tags, date_created, date_updated) VALUES('title3', 'solution3', 'hint3', 'revisionNotes3', 'link3', 1, 'test', '2013-07-09 03:23:34.234', '2013-07-09 03:23:34.234');
INSERT INTO Coding_Dashboard (title, solution, hint, revision_notes, link, difficulty, tags, date_created, date_updated) VALUES('title4', 'solution4', 'hint4', 'revisionNotes4', 'link4', 2, 'test', '2013-07-09 03:23:34.234', '2013-07-09 03:23:34.234');
INSERT INTO Coding_Dashboard (title, solution, hint, revision_notes, link, difficulty, tags, date_created, date_updated) VALUES('title5', 'solution5', 'hint5', 'revisionNotes5', 'link5', 3, 'test', '2013-07-09 03:23:34.234', '2013-07-09 03:23:34.234');
INSERT INTO Coding_Dashboard (title, solution, hint, revision_notes, link, difficulty, tags, date_created, date_updated) VALUES('title6', 'solution6', 'hint6', 'revisionNotes6', 'link6', 3, 'test', '2013-07-09 03:23:34.234', '2013-07-09 03:23:34.234');