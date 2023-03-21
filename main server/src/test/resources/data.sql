DROP TABLE IF EXISTS quotes CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS vote_quotes CASCADE;

CREATE TABLE users
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) unique NOT NULL,
    password VARCHAR(100) NOT NULL,
    date_of_creation TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

CREATE TABLE quotes(
    id BIGSERIAL PRIMARY KEY,
    date_of_creation TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    score INTEGER,
    text VARCHAR(100) NOT NULL,
    user_id integer NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE RESTRICT
);

create table vote_quotes(
    id BIGSERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    quote_id INTEGER NOT NULL,
    updated_score INTEGER NOT NULL,
    updated_at TIMESTAMP,
    vote BOOLEAN,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE RESTRICT,
    FOREIGN KEY (quote_id) REFERENCES quotes (id) ON DELETE CASCADE ON UPDATE RESTRICT
);