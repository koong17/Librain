create table Facilities( --시설물
Fac_serialnum number  ,          --일련번호 PK
Fac_name varchar2(30),         -- 시설물 
Fac_address varchar2(30)    --위치

);
create table Facilities_inspection(   --시설물 점검
FacIn_INSPECTION_DATE date default sysdate,    -- 점검일 
FacIn_serialnum  number                            --점검한것 Facilities의 fk
);

select * from Facilities_inspection;
select * from Facilities join Facilities_inspection  on Facilities.Fac_serialnum=Facilities_inspection.FacIn_serialnum;

select Fac_serialnum,Fac_name,Fac_address,FacIn_INSPECTION_DATE from Facilities,Facilities_inspection;  --FK확실하게 정해지면 natural join으로 해결할것.


select * from Facilities natural join Facilities_inspection  on Facilities.Fac_serialnum=Facilities_inspection.FacIn_serialnum;



select * from Facilities join (select FacIn_INSPECTION_DATE,FacIn_serialnum Fac_serialnum from Facilities_inspection) Facilities_inspection 
on Facilities.Fac_serialnum=Facilities_inspection.Fac_serialnum;



select * from Facilities join on Facilities.Fac_serialnum=Facilities_inspection.FacIn_serialnum;

insert into Facilities values(1,'소화기','1층화단');
insert into Facilities values(2,'소화기','1층열람실');
insert into Facilities values(3,'소화기','1층열람실문앞');
insert into Facilities values(4,'분전함','1층');
insert into Facilities values(5,'분전함','1층');
insert into Facilities values(6,'분전함','2층');

create or replace trigger facilities_trigger
after insert on  Facilities for each row
begin
 insert into Facilities_inspection(FacIn_serialnum) values(:new.Fac_serialnum);
 end;
 /
 insert into Facilities values(7,'분전함','3층');
 
 select * from Facilities_inspection;
  select * from Facilities;

select *from  Facilities natural join (select  FacIn_serialnum Fac_serialnum ,case when Fac_serialnum=111 then 111 end
   , FacIn_INSPECTION_DATE from Facilities_inspection);
 select Fac_serialnum,Fac_name,Fac_address,FacIn_INSPECTION_DATE,case when Fac_name='소방'
                                                                                        case when (sysdate-FacIn_INSPECTION_DATE)>150 then FacIn_INSPECTION_DATE+180 end
                                                                      when Fac_name='분전함'
                                                                                       case when (sysdate-FacIn_INSPECTION_DATE)>60 then FacIn_INSPECTION_DATE+180
                                                                                             
 then 13 end aa from Facilities,Facilities_inspection;  --FK확실하게 정해지면 natural join으로 해결할것.

 select 
 
 


insert into Facilities_inspection(FacIn_serialnum) values(1);
insert into Facilities_inspection(FacIn_serialnum) values(2);