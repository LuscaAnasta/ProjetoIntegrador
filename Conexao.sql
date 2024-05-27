create database salao;
use salao;

create table tb_cliente(
id_cliente int primary key auto_increment,
nome_cliente varchar(100) not null,
tel_cliente int(11) not null,
cpf_cliente varchar(12) not null
);

create table tb_funcionario(
id_funcionario int primary key auto_increment,
nome_funcionario varchar(100) not null,
login_funcionario varchar(20) not null,
senha_funcionario varchar(100),
tel_funcionario int(11) not null,
email_funcionario varchar(100) not null
);

create table tb_servico(
id_servico int primary key auto_increment,
descricao_servico varchar(255) not null,
valor_servico float (6) not null
);

create table tb_reserva(
id_reserva int primary key auto_increment,
id_cliente int not null,
foreign key (id_cliente) references tb_cliente(id_cliente),
id_funcionario int not null,
foreign key (id_funcionario) references tb_funcionario(id_funcionario),
id_servico int not null,
foreign key (id_servico) references tb_servico(id_servico),
horario_reserva varchar(10) not null,
dia_semana varchar(20) not null
);

select tb_reserva.id_reserva, tb_reserva.id_cliente, tb_cliente.nome_cliente, tb_reserva.id_funcionario, tb_funcionario.nome_funcionario, tb_servico.descricao_servico,tb_servico.valor_servico, tb_reserva.horario_reserva , tb_reserva.dia_semana from tb_reserva
inner join tb_cliente on tb_reserva.id_cliente = tb_cliente.id_cliente
inner join tb_funcionario on tb_reserva.id_funcionario = tb_funcionario.id_funcionario
inner join tb_servico on tb_reserva.id_servico = tb_servico.id_servico;

insert into tb_cliente(nome_cliente, tel_cliente, cpf_cliente) values ("Lucass","4444", "22221111231");
insert into tb_funcionario(nome_funcionario, login_funcionario, senha_funcionario, tel_funcionario, email_funcionario) values ("Pedro","", "", "123444", "email.email.com");
insert into reserva(id_cliente, id_funcionario, data_reserva, descricao) values ("2", "1", "2002-12-12 11:00:00", "corte a ");

SELECT * FROM tb_cliente; 
SELECT * from tb_funcionario; 
SELECT * FROM tb_reserva;


#drop table tb_reserva;
