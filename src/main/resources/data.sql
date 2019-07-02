delete from  users;
insert into users(id,email,password) values(1,'julie','$2a$10$q3JNqHOmDtGpM9geE.OLbeVF9bq/5.ZsB8CrG1JqwsSpGPMynq3Ve');
insert into users(id,email,password) values(2,'arunk','$2a$10$XLBGA2lS8OHQMCwnvKM91uqiFPog5D8I85C.7UItrM3yYTZRHuR2W');
insert into users(id,email,password) values(3,'arun@gmail.com','$2a$10$dCvToh64Xc.fUBD6Gs5fiesnaTm/4u1nzRCcSUlRfAZJ.GJDU8F0S');

insert into roles(id, name) values(1,'ROLE_USER');
insert into roles(id, name) values(2,'ROLE_ADMIN');

insert into user_role(user_id, role_id) values(1,2);
insert into user_role(user_id, role_id) values(2,2);
insert into user_role(user_id, role_id) values(2,1);
insert into user_role(user_id, role_id) values(3,2);
insert into user_role(user_id, role_id) values(3,1);

