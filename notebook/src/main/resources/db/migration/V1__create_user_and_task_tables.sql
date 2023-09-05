CREATE TABLE person (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE task (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content VARCHAR(255) NOT NULL,
    date_to_complete DATE,
    priority VARCHAR(20),
    completed BOOLEAN,
    person_id BIGINT,
    FOREIGN KEY (person_id) REFERENCES person(id)
);