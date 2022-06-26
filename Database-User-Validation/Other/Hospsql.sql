show databases;
create database Hospital;
use Hospital;

create table doctor(dId varchar(20), dName varchar(20), dPassword varchar(20), dspecialtly varchar(20), dbgrp varchar(5), otp int, primary key(did));
insert into doctor values ("1201","James"," ){==[(>~","Diabetes","O-",-1), ("1202","John","\(@^","Cardiology","A-",-1), ("1203","Jack","rkb<[+800","Neurology","A+",-1), ("1204", "Steven","rkbeqh","Peadiatrist","O",-1), ("1205","Marc","]4r0<","Orthopedics","O",-1);

create table patient(pname varchar(20), pprob varchar(20), pbgrp varchar(5), did varchar(6), pid varchar(6), primary key(pid), foreign key(did) references doctor(dId));
insert into patient(pname,pprob,pbgrp,pid,did) values (')+;+>' , '~/{}+;+=' , '{6' , 'rrzr' , '1201' ),('){>?+>' , '~/{}+;+=' , '{6' , 'rrzk' , '1201' ),('\{?+>;(^' , '#{>~/{# {>>+=;' , '{0' , 'rrzb' , '1202'),('=@{< ( ^+/$' , '{>;+>: }$(#?' , 'z6' , 'rrze' , '1202' ),('+>[/^' , '}>{/^ ;,!(,>' , '}0' , 'rrzq' , '1203' ),('!(^/?{' , '!+!(>: $(==' , 'z6' , 'rrzh' , '1203' ),('#@{^~$+>' , '!{$^,;>/;/(^' , '{6' , 'rrzu' , '1204' ),('\/!' , '{^{+!/{' , 'z0' , 'rrzy' , '1204'),('[/$$' , '{>;@>/;/=' , '{}0' , 'rrzw' , '1205' ),('?/>{^' , '$+* ->{#;,>+' , 'z0' , 'rrrz' , '1205' );
