
DROP DATABASE IF EXISTS mysqldb;
CREATE DATABASE mysqldb;
USE mysqldb;

DROP TABLE IF EXISTS colore;
DROP TABLE IF EXISTS gradazione;


CREATE TABLE colore
(id int not null,
codice varchar(200),
nome varchar(200),
hex varchar(200),
img varchar(200),
gradazione int,
PRIMARY KEY (id),
FOREIGN KEY (gradazione) REFERENCES gradazione(id)
);

CREATE TABLE gradazione
(
    id     BIGINT       NOT NULL,
    codice VARCHAR(255) NULL,
    nome   VARCHAR(255) NULL,
    CONSTRAINT pk_gradazione PRIMARY KEY (id)
);