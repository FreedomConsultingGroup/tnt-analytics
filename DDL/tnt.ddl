-- Generated by Oracle SQL Developer Data Modeler 18.4.0.339.1532
--   at:        2019-02-20 14:23:35 EST
--   site:      Oracle Database 11g
--   type:      Oracle Database 11g



CREATE TABLE auditevents (
    id            INTEGER NOT NULL,
    description   VARCHAR(2000) NOT NULL,
    code          VARCHAR(50) NOT NULL,
    event_date    DATE
);

ALTER TABLE auditevents ADD CONSTRAINT auditevents_pk PRIMARY KEY ( id );

CREATE TABLE auditlog (
    customers_id       INTEGER NOT NULL,
    auditevents_id     INTEGER NOT NULL,
    time_of_event      DATE NOT NULL,
    customers_userid   VARCHAR(25)  NOT NULL
);

ALTER TABLE auditlog ADD CONSTRAINT auditlog_pk PRIMARY KEY ( customers_id,
                                                              auditevents_id );

CREATE TABLE comments (
    id             INTEGER NOT NULL,
    customers_id   INTEGER NOT NULL,
    comments      TEXT NOT NULL,
    date_added     DATE
);

ALTER TABLE comments ADD CONSTRAINT comments_pk PRIMARY KEY ( id );

CREATE TABLE customerresponse (
    customers_id       INTEGER NOT NULL,
    questions_id       INTEGER NOT NULL,
    response_comment   TEXT,
    customers_userid   VARCHAR(25) NOT NULL,
    date_answered      DATE,
    response           VARCHAR(100)
);

ALTER TABLE customerresponse ADD CONSTRAINT customerresponse_pk PRIMARY KEY ( customers_id,
                                                                              questions_id );

CREATE TABLE customers (
    id              INTEGER NOT NULL,
    userid          VARCHAR(25) NOT NULL,
    last_name       VARCHAR(100) NOT NULL,
    first_name      VARCHAR(100)  NOT NULL,
    last_login      TIMESTAMP NOT NULL,
    date_created    DATE,
    date_modified   DATE
);

ALTER TABLE customers ADD CONSTRAINT customers_pk PRIMARY KEY ( id );

CREATE TABLE documents (
    id              INTEGER NOT NULL,
    customers_id    INTEGER NOT NULL,
    name            VARCHAR(100) NOT NULL,
    description     VARCHAR(2000) ,
    hash            VARCHAR(2000) ,
    date_uploaded   DATE,
    date_modified   DATE,
    comments       TEXT,
    storage_path    VARCHAR(2000)
);

ALTER TABLE documents ADD CONSTRAINT documents_pk PRIMARY KEY ( id );

CREATE TABLE question_type (
    id             NUMERIC NOT NULL,
    qustion_type   VARCHAR(25)
);

ALTER TABLE question_type ADD CONSTRAINT question_type_pk PRIMARY KEY ( id );

CREATE TABLE questions (
    id                     INTEGER NOT NULL,
    question               VARCHAR(2000)
     NOT NULL,
    question_description   VARCHAR(2000)
     NOT NULL,
    date_created           DATE NOT NULL,
    date_modified          DATE NOT NULL,
    question_type_id       NUMERIC NOT NULL
);

ALTER TABLE questions ADD CONSTRAINT questions_pk PRIMARY KEY ( id );

ALTER TABLE auditlog
    ADD CONSTRAINT auditlog_auditevents_fk FOREIGN KEY ( auditevents_id )
        REFERENCES auditevents ( id );

ALTER TABLE auditlog
    ADD CONSTRAINT auditlog_customers_fk FOREIGN KEY ( customers_id )
        REFERENCES customers ( id );

ALTER TABLE comments
    ADD CONSTRAINT comments_customers_fk FOREIGN KEY ( customers_id )
        REFERENCES customers ( id );

ALTER TABLE customerresponse
    ADD CONSTRAINT customerresponse_customers_fk FOREIGN KEY ( customers_id )
        REFERENCES customers ( id );

ALTER TABLE customerresponse
    ADD CONSTRAINT customerresponse_questions_fk FOREIGN KEY ( questions_id )
        REFERENCES questions ( id );

ALTER TABLE documents
    ADD CONSTRAINT documents_customers_fk FOREIGN KEY ( customers_id )
        REFERENCES customers ( id );

ALTER TABLE questions
    ADD CONSTRAINT questions_question_type_fk FOREIGN KEY ( question_type_id )
        REFERENCES question_type ( id );



-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                             8
-- CREATE INDEX                             0
-- ALTER TABLE                             15
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                  12
-- WARNINGS                                 0
