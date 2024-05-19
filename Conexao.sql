create database salao;
use salao;
create table cliente(
id_cliente int primary key auto_increment,
nome_cliente varchar(100) not null,
tel_cliente int(11) not null,
cpf_cliente int(11) not null,
frequencia int
);

create table funcionario(
id_funcionario int primary key auto_increment,
nome_funcionario varchar(100) not null,
senha_funcionario varchar(100),
tel_funcionario int(11) not null,
email_funcionario varchar(100) not null,
cpf_funcionario int(11) not null
);

create table reserva(
id_reserva int primary key auto_increment,
constraint fk_id_cliente foreign key (id_cliente) references cliente(id_cliente),
id_cliente int not null,
constraint fk_id_funcionario foreign key (id_funcionario) references funcionario(id_funcionario),
id_funcionario int not null,
data_reserva datetime not null,
descricao varchar(255) not null
);

insert into cliente(nome_cliente, senha_cliente, tel_cliente, cpf_cliente, frequencia) values ("Lucass","senha123" ,"4444", "2222", "10");
insert into funcionario(nome_funcionario, senha_funcionario, tel_funcionario, email_funcionario, cpf_funcionario) values ("Pedro","senha123", "123333", "email.email.com", "123444");
insert into reserva(id_cliente, id_funcionario, data_reserva, descricao) values ("2", "1", "2002-12-12 11:00:00", "corte a ");

SELECT * FROM cliente; 
SELECT * FROM funcionario; 
SELECT * FROM reserva;


#drop database salao;
