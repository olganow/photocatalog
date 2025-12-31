-- Подключаем расширение UUID
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Создаем таблицу photos
CREATE TABLE IF NOT EXISTS "photos"
(
    id                  UUID UNIQUE     NOT NULL DEFAULT uuid_generate_v1() PRIMARY KEY,
    description         VARCHAR(255)    NOT NULL,
    last_modify_date    DATE            NOT NULL DEFAULT CURRENT_DATE,
    content BYTEA
);