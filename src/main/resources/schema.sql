CREATE TABLE IF NOT EXISTS person
(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(355) NOT NULL,
    email varchar(355) NOT NULL UNIQUE,
    number_phone varchar(50) NOT NULL UNIQUE,
    balance BIGINT
    );

CREATE TABLE IF NOT EXISTS transactions
(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    person_from BIGINT NOT NULL,
    person_to BIGINT NOT NULL,
    amount BIGINT NOT NULL,

    FOREIGN KEY (person_from) references person(id) on delete cascade,
    FOREIGN KEY (person_to) references person(id) on delete cascade
);
