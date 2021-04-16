drop sequence dept_seq;
create sequence dept_seq;
drop table dept cascade constraint;
create table dept(
deptId number(3) primary key,
deptName varchar2(30)
);
commit;

drop sequence emp_seq;
create sequence emp_seq;
drop table emp cascade constraint;
create table emp(
id number(3)primary key,
name varchar2(20),
salary number(7,2),
age number(3),
deptId number(3) references dept(deptId)
);
commit;

drop table user2 cascade constraint;
create table user2(
username varchar2(20) primary key,
password varchar2(10),
truename varchar(30),
sex varchar2(10) check(sex in('man','women'))
);
commit;

insert into dept values(dept_seq.nextval,'财务部');
insert into dept values(dept_seq.nextval,'研发部');
insert into dept values(dept_seq.nextval,'市场部');
commit;
select * from dept;

insert into emp values(emp_seq.nextval,'刘一',5742,43,1);
insert into emp values(emp_seq.nextval,'陈二',78532,22,1);
insert into emp values(emp_seq.nextval,'张三',3567,87,1);
insert into emp values(emp_seq.nextval,'李四',5657,24,2);
insert into emp values(emp_seq.nextval,'王五',32356,32,2);
insert into emp values(emp_seq.nextval,'赵六',446,65,2);
insert into emp values(emp_seq.nextval,'孙七',13455,15,3);
insert into emp values(emp_seq.nextval,'周八',5245,76,3);
insert into emp values(emp_seq.nextval,'吴九',57485,12,3);
insert into emp values(emp_seq.nextval,'郑十',44356,46,3);
commit;
select * from emp;

insert into user2 values('qqq','qqq','aaa','man');
commit;
select * from user2;

select e.id as eid,e.name as ename,e.salary as esalary,e.age as eage,d.deptid as did,d.deptname as dname
from emp e left join dept d on e.deptid=d.deptid;
