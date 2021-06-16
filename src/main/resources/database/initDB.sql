CREATE TABLE IF NOT EXISTS scenes (
    id    BIGSERIAL PRIMARY KEY ,
    date  timestamp NOT NULL
    );
CREATE TABLE IF NOT EXISTS figures (
    id      BIGSERIAL PRIMARY KEY,
    scene   BIGSERIAL NOT NULL,
    type    TEXT NOT NULL,
    center  TEXT NOT NULL,
    radius  TEXT NOT NULL
);