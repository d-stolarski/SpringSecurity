INSERT INTO USER(username, password, enabled) values ('admin', 'abcd1', true);
INSERT INTO USER(username, password, enabled) values ('user', 'abcd2', true);

INSERT INTO USER_ROLE(username, role) values ('admin', 'ROLE_ADMIN');
INSERT INTO USER_ROLE(username, role) values ('user', 'ROLE_USER');
