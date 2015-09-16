CREATE TABLE role
(
  role_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(200) NOT NULL,
  UNIQUE (name)
);

create table permission
(
  permission_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  UNIQUE (name)
);


create table role_permission
(
  role_id BIGINT,
  permission_id BIGINT,
  FOREIGN KEY (role_id) REFERENCES role(role_id),
  FOREIGN KEY (permission_id) REFERENCES permission(permission_id)
);


CREATE TABLE user
(
  user_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
  username VARCHAR(400) NOT NULL,
  password VARCHAR(400) NOT NULL,
  role_id BIGINT,
  FOREIGN KEY (role_id) REFERENCES role(role_id)
);

CREATE TABLE object
(
  object_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
  name VARCHAR(400) NOT NULL,
  value INT,
  creator_id BIGINT  NOT NULL,
  FOREIGN KEY (creator_id) REFERENCES user(user_id)
);



INSERT INTO role (name) VALUE("USER");
INSERT INTO role (name) VALUE("ADMIN");


insert into permission (name) values("VIEW_OBJECT");
insert into permission (name) values("CREATE_OBJECT");
insert into permission (name) values("EDIT_OBJECT");
insert into permission (name) values("DELETE_OBJECT");
insert into permission (name) values("VIEW_ADMIN_PAGE");


insert into role_permission VALUES(1,1);
insert into role_permission VALUES(1,3);
insert into role_permission VALUES(2,1);
insert into role_permission VALUES(2,2);
insert into role_permission VALUES(2,3);
insert into role_permission VALUES(2,4);
insert into role_permission VALUES(2,5);

INSERT INTO user (username, password, role_id) VALUES ("testUser", "$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y",1);
INSERT INTO user (username, password, role_id) VALUES ("testAdmin", "$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y",2);