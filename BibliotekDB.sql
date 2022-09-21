CREATE TABLE reservation_status (
  id INT NOT NULL AUTO_INCREMENT,
  status_value VARCHAR(50),
  CONSTRAINT pk_res_status PRIMARY KEY (id)
);

CREATE TABLE category (
  id INT NOT NULL AUTO_INCREMENT,
  category_name VARCHAR(100),
  CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE book (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(500),
  category_id INT,
  publication_date DATE,
  copies_owned INT,
  CONSTRAINT pk_book PRIMARY KEY (id),
  CONSTRAINT fk_book_category FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE author (
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(300),
  last_name VARCHAR(300),
  CONSTRAINT pk_author PRIMARY KEY (id)
);

CREATE TABLE book_author (
  book_id INT NOT NULL AUTO_INCREMENT,
  author_id INT,
  CONSTRAINT fk_bookauthor_book FOREIGN KEY (book_id) REFERENCES book(id),
  CONSTRAINT fk_bookauthor_author FOREIGN KEY (author_id) REFERENCES author(id)
);

CREATE TABLE member (
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(300),
  last_name VARCHAR(300),
  CONSTRAINT pk_member PRIMARY KEY (id)
);

CREATE TABLE reservation (
  id INT NOT NULL AUTO_INCREMENT,
  book_id INT,
  member_id INT,
  reservation_date DATE,
  reservation_status_id INT,
  CONSTRAINT pk_reservation PRIMARY KEY (id),
  CONSTRAINT fk_res_book FOREIGN KEY (book_id) REFERENCES book(id),
  CONSTRAINT fk_res_member FOREIGN KEY (member_id) REFERENCES member(id)
);

CREATE TABLE loan (
  id INT NOT NULL AUTO_INCREMENT,
  book_id INT,
  member_id INT,
  loan_date DATE,
  returned_date DATE,
  CONSTRAINT pk_loan PRIMARY KEY (id),
  CONSTRAINT fk_loan_book FOREIGN KEY (book_id) REFERENCES book(id),
  CONSTRAINT fk_loan_member FOREIGN KEY (member_id) REFERENCES member(id)
  );

CREATE TABLE admin (
idadmin int not null auto_increment,
username varchar(45),
password varchar(45)
);

