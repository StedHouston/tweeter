create table app_user (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    created_at DATE NOT NULL,
    email VARCHAR(100) NOT NULL,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

create table tweet (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    app_user_id BIGINT REFERENCES app_user (id) NOT NULL,
    message VARCHAR(124) NOT NULL,
    retweet BOOL NOT NULL,
    retweet_author_id BIGINT REFERENCES app_user (id),
    created_at TIMESTAMP NOT NULL,
    UNIQUE(app_user_id)
);

create table user_followers (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    user_id BIGINT REFERENCES  app_user (id) NOT NULL,
    follower_id BIGINT REFERENCES  app_user (id) NOT NULL
);