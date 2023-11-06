show tables;

create user 'hong'@localhost identified by '1234';



create table member(
	id varchar(100) primary key,
	pw varchar(100)
);

create table parking(
	plate varchar(100) primary key, # 번호판
	in_date date
);

create table parking_ad(
	nid int auto_increment primary key,
	plate_ad varchar(100), # 번호판
	in_date date,
	out_date date,
	price int
);