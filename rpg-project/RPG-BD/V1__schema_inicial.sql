-- =============================================
-- V1__schema_inicial.sql
-- Criação das tabelas do RPG Ficha
-- =============================================

CREATE TABLE atributos (
    id        SERIAL PRIMARY KEY,
    nome      VARCHAR(50)  NOT NULL,
    valor     INTEGER      NOT NULL DEFAULT 0
);

CREATE TABLE substatus (
    id        SERIAL PRIMARY KEY,
    nome      VARCHAR(80)  NOT NULL,
    categoria VARCHAR(50)  NOT NULL,
    valor     INTEGER      NOT NULL DEFAULT 0
);

-- chave/valor para status calculados persistidos (ex: vida_atual)
CREATE TABLE status_fixos (
    chave     VARCHAR(50)  PRIMARY KEY,
    valor     INTEGER      NOT NULL DEFAULT 0
);

CREATE TABLE inventario (
    id        SERIAL PRIMARY KEY,
    nome      VARCHAR(100) NOT NULL,
    criado_em TIMESTAMP    NOT NULL DEFAULT NOW()
);

CREATE TABLE acessorios (
    nome      VARCHAR(60)  PRIMARY KEY,
    bonus     INTEGER      NOT NULL DEFAULT 0,
    equipado  BOOLEAN      NOT NULL DEFAULT FALSE
);