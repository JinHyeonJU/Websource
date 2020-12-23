create table colorPicker(
	bno number(8),
	name nvarchar2(10) not null,
	password varchar2(15) not null,
	title nvarchar2(50) not null,
	attach nvarchar2(100),
	readcount number(8) default 0,
	regdate date default sysdate);
	
alter table colorPicker add constraint pk_colorPicker primary key(bno);

create SEQUENCE colorPicker_seq;