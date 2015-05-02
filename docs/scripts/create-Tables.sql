DROP TABLE IF EXISTS "usuario" CASCADE;
DROP TABLE IF EXISTS "local" CASCADE;

CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE "usuario"
(
  id    SERIAL PRIMARY KEY NOT NULL,
  email TEXT UNIQUE        NOT NULL,
  nome  TEXT               NOT NULL,
  senha TEXT               NOT NULL,

  CHECK (email ~* '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+[.][A-Za-z]+$')
);

CREATE TABLE "local"
(
  id          SERIAL  PRIMARY KEY   NOT NULL,
  nome        TEXT    UNIQUE        NOT NULL,
  logradouro  TEXT                  NOT NULL,
  cep	        TEXT		              NOT NULL,
  cidade      TEXT		              NOT NULL,
  estado      TEXT		              NOT NULL
);