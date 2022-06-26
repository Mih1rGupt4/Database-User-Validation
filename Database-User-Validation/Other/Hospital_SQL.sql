show databases;
create database Hospital;
use Hospital;

create table doctor(dId varchar(20), dName varchar(20), dPassword varchar(20), dspecialtly varchar(20), dbgrp varchar(5), otp int, primary key(did));
insert into doctor values (1201,"James","password","Diabetes","O-",-1), (1202,"John","John","Cardiology","A-",-1), (1203,"Jack","123QWE!@#","Neurology","A+",-1), (1204, "Steven","123456","Peadiatrist","O",-1), (1205,"Marc","X(1_qt","Orthopedics","O",-1);

create table patient(pname varchar(20), pprob varchar(20), pbgrp varchar(5), did varchar(6), pid varchar(6), primary key(pid), foreign key(did) references doctor(dId));
insert into patient(pname,pprob,pbgrp,pid,did) values ("Peter","Diabetes","A-",1101,1201),("Parker","Diabetes","A-",1102,1201),("Jakerton","Cardiac Arrest","A+",1103,1202),("Shaq O Neil","Artery Block","0-",1104,1202),("Erwin","Brain Tumour","B+",1105,1203),("Monika","Memory loss","0-",1106,1203),("Chandler","Malnutrition","A-",1107,1204),("Jim","Anaemia","0+",1108,1204),("Will","Arthritis","AB+",1109,1205),("Kiran","Leg Fracture","0+",1110,1205);
