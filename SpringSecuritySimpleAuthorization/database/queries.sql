CREATE TABLE role
(
  role_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(200) NOT NULL,
  UNIQUE (name)
);


CREATE TABLE user
(
  user_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
  username VARCHAR(400) NOT NULL,
  password VARCHAR(400) NOT NULL,
  role_id BIGINT,
  FOREIGN KEY (role_id) REFERENCES role(role_id)
);


INSERT INTO role (name) VALUE("USER");
INSERT INTO role (name) VALUE("ADMIN");

INSERT INTO user (username, password, role_id) VALUES ("testUser", "$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y",1);
INSERT INTO user (username, password, role_id) VALUES ("testAdmin", "$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y",2);