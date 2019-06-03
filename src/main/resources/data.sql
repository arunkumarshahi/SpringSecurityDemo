delete from  users;
insert into users(id,email,password) values(1,'julie','$2a$10$q3JNqHOmDtGpM9geE.OLbeVF9bq/5.ZsB8CrG1JqwsSpGPMynq3Ve');
insert into users(id,email,password) values(2,'arun','$2a$10$dCvToh64Xc.fUBD6Gs5fiesnaTm/4u1nzRCcSUlRfAZJ.GJDU8F0S');

insert into roles(id, name) values(1,'ROLE_USER');
insert into roles(id, name) values(2,'ROLE_ADMIN');

insert into user_role(user_id, role_id) values(1,1);
insert into user_role(user_id, role_id) values(1,2);
insert into user_role(user_id, role_id) values(2,2);

