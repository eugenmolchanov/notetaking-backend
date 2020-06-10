CREATE SCHEMA CORE;

CREATE SEQUENCE USER_ID_SEQ;
CREATE SEQUENCE ROLE_ID_SEQ;
CREATE SEQUENCE QUESTION_ID_SEQ;
CREATE SEQUENCE DISCIPLINE_ID_SEQ;
CREATE SEQUENCE CONTRACTION_ID_SEQ;

CREATE TABLE ROLE
(
    ID   SERIAL PRIMARY KEY,
    NAME VARCHAR(45) NOT NULL
);


CREATE TABLE USERS
(
    ID            SERIAL PRIMARY KEY,
    FIRST_NAME    VARCHAR(50)  NOT NULL,
    LAST_NAME     VARCHAR(50)  NOT NULL,
    EMAIL_ADDRESS VARCHAR(255) NOT NULL UNIQUE,
    PASSWORD      VARCHAR(255) NOT NULL,
    ROLE_ID       INT REFERENCES role (ID)
);


CREATE TABLE DISCIPLINE
(
    ID           SERIAL PRIMARY KEY,
    NAME         VARCHAR(100) NOT NULL,
    ABBREVIATION VARCHAR(45)  NOT NULL,
    FREE_ACCESS  BOOLEAN      NOT NULL
);


CREATE TABLE QUESTION
(
    ID            SERIAL PRIMARY KEY,
    NAME          VARCHAR(255) NOT NULL,
    NUMBER        INT          NOT NULL,
    FULL_CONTENT  TEXT         NOT NULL,
    SHORT_CONTENT TEXT         NOT NULL,
    DISCIPLINE_ID INT REFERENCES discipline (ID),
    UNIQUE (NUMBER, DISCIPLINE_ID)
);

CREATE TABLE CONTRACTION
(
    ID          SERIAL PRIMARY KEY,
    NAME        VARCHAR(45)  NOT NULL,
    DESCRIPTION VARCHAR(255) NOT NULL
);


CREATE TABLE QUESTION_CONTRACTION
(
    QUESTION_ID    INT REFERENCES question (ID),
    CONTRACTION_ID INT REFERENCES contraction (ID)
);
