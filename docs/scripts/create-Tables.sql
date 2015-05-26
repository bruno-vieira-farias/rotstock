DROP TABLE IF EXISTS "usuario" CASCADE;
DROP TABLE IF EXISTS "local" CASCADE;
DROP TABLE IF EXISTS "equipamento" CASCADE;

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
  nome        TEXT    UNIQUE        NOT NULL
);

CREATE TABLE "equipamento"
(
  id              SERIAL      PRIMARY KEY   NOT NULL,
  serial          TEXT                      NOT NULL,
  fabricante      TEXT                      NOT NULL,
  modelo          TEXT                      NOT NULL,
  proprietario    TEXT                      NOT NULL,
  ativo           BOOLEAN                   NOT NULL,
  id_local         INT      NOT NULL REFERENCES "local",
  --Discriminator identifica as especializacoes dos equipamentos
  discriminator   TEXT                      NOT NULL,
  --discriminator Computador
  processador     TEXT                              ,
  memoria         TEXT                              ,
  hd              TEXT                              ,
  --discriminator Impressora
  colorida        BOOLEAN                           ,
  tipo_impressora TEXT                              ,
  --discriminator Monitor
  polegadas       TEXT                              ,
  --discriminator Teclado e Mouse
  tipo_conexao    TEXT                              ,
  --discriminator Telefone
  sem_fio         BOOLEAN                           ,
  ip              BOOLEAN
);
