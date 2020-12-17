CREATE TABLE memberTBL(
	userid varchar2(15) primary key,
	password varchar2(20) not null,
	name nvarchar2(10) not null,
	gender varchar2(2) not null,
	email varchar2(50) not null
);

insert into memberTBL values('hong123','hong123', '홍길동', '남','hong123@naver.com');


select * from memberTBL;

select userid, name from memberTBL where userid='hong123' and password='hong123';


select userid, name from memberTBL where password='hong123';
-- db 설치 다시 한거 아니죠?
-- 네 원래쓰던거에요