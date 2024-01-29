

CREATE TABLE Person
(
    id          int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    full_name   varchar NOT NULL UNIQUE,
    date_of_birth DATE    NOT NULL

);

CREATE TABLE Book
(
    id        int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    title     varchar NOT NULL,
    author    varchar NOT NULL,
    isbn      varchar,
    taken_at  DATE,
    person_id int     REFERENCES Person (id) ON DELETE SET NULL
);

TRUNCATE  TABLE  Person CASCADE ;
TRUNCATE TABLE Book;

INSERT INTO Person (full_name, date_of_birth) values ('Иванов Иван Иванович', '1995-12-10');
INSERT INTO Person (full_name, date_of_birth) values ('Петров Петр Петрович', '1997-04-21');
INSERT INTO Person (full_name, date_of_birth) values ('Сидоров Илья Сергеевич', '1995-06-20');
INSERT INTO Person (full_name, date_of_birth) values ('Подгорных Сергей Александрович', '1992-02-23');

INSERT INTO Book (title, author, isbn, taken_at, person_id) VALUES ('Евгений Онегин', 'asd11', 'Александр Сергеевич Пушкин', '2024-01-28' , 1);
INSERT INTO Book (title, author, isbn, taken_at, person_id) VALUES ('Борис Годунов', 'asd12', 'Александр Сергеевич Пушкин', '2024-01-25', 2);
INSERT INTO Book (title, author, isbn, taken_at, person_id) VALUES ('Маленькие трагедии', 'asd13', 'Александр Сергеевич Пушкин', '2024-01-26', 3);
INSERT INTO Book (title, author, isbn, taken_at, person_id) VALUES ('Медный всадник', 'asd14', 'Александр Сергеевич Пушкин', null, null);

