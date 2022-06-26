show databases;
create database Hospital;
use Hospital;

create table doctor(dId varchar(20), dName varchar(20), dPassword varchar(20), dspecialtly varchar(20), dbgrp varchar(5), otp int, primary key(did));
insert into doctor values ('rkzr' , '\{!+=' , '){==[(>~' , "password" , '(6' , -1),('rkzk' , '\(@^' , "John" , '#{>~/($(*:' , '{6' ,-1),('rkzb' , '\{#?' , "123QWE!@#" , '^+,>($(*:' , '{0' ,-1 ),('rkze' , '=;+_+^' , "123456" , ')+{~/{;>/=;' , '(' , -1),('rkzq' , '!{>#' , "X(1_qt" , '(>;@()+~/#=' , '(' , -1);

create table patient(pname varchar(20), pprob varchar(20), pbgrp varchar(5), did varchar(6), pid varchar(6), primary key(pid), foreign key(did) references doctor(dId));
insert into patient(pname,pprob,pbgrp,pid,did) values (')+;+>' , '~/{}+;+=' , '{6' , 'rrzr' , 'rkzr' ),('){>?+>' , '~/{}+;+=' , '{6' , 'rrzk' , 'rkzr' ),('\{?+>;(^' , '#{>~/{# {>>+=;' , '{0' , 'rrzb' , 'rkzk'),('=@{< ( ^+/$' , '{>;+>: }$(#?' , 'z6' , 'rrze' , 'rkzk' ),('+>[/^' , '}>{/^ ;,!(,>' , '}0' , 'rrzq' , 'rkzb' ),('!(^/?{' , '!+!(>: $(==' , 'z6' , 'rrzh' , 'rkzb' ),('#@{^~$+>' , '!{$^,;>/;/(^' , '{6' , 'rrzu' , 'rkze' ),('\/!' , '{^{+!/{' , 'z0' , 'rrzy' , 'rkze'),('[/$$' , '{>;@>/;/=' , '{}0' , 'rrzw' , 'rkzq' ),('?/>{^' , '$+* ->{#;,>+' , 'z0' , 'rrrz' , 'rkzq' );
