CREATE SCHEMA core

    CREATE TABLE "user"
    (
        ID            SERIAL PRIMARY KEY,
        FIRST_NAME    VARCHAR(50)  NOT NULL,
        LAST_NAME     VARCHAR(50)  NOT NULL,
        EMAIL_ADDRESS VARCHAR(255) NOT NULL UNIQUE,
        USER_NAME     VARCHAR(50)  NOT NULL UNIQUE,
        PASSWORD      VARCHAR(255) NOT NULL,
        ROLE          VARCHAR(50) NOT NULL,
        ENABLED       BOOLEAN
    )


    CREATE TABLE discipline
    (
        ID           SERIAL PRIMARY KEY,
        NAME         VARCHAR(100) NOT NULL,
        ABBREVIATION VARCHAR(45)  NOT NULL,
        FREE_ACCESS  BOOLEAN      NOT NULL
    )


    CREATE TABLE question
    (
        ID            SERIAL PRIMARY KEY,
        NAME          VARCHAR(255) NOT NULL,
        NUMBER        INT          NOT NULL,
        FULL_CONTENT  TEXT         NOT NULL,
        SHORT_CONTENT TEXT         NOT NULL,
        DISCIPLINE_ID INT REFERENCES discipline (ID),
        UNIQUE (NUMBER, DISCIPLINE_ID)
    )

    CREATE TABLE contraction
    (
        ID          SERIAL PRIMARY KEY,
        NAME        VARCHAR(45)  NOT NULL,
        DESCRIPTION VARCHAR(255) NOT NULL
    )


    CREATE TABLE question_contraction
    (
        QUESTION_ID    INT REFERENCES question (ID),
        CONTRACTION_ID INT REFERENCES contraction (ID)
    );