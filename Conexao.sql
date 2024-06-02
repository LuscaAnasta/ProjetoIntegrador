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

insert into tb_funcionario(nome_funcionario, login_funcionario, senha_funcionario, tel_funcionario, email_funcionario) values ("","admin", "admin", "1", "");

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



#drop database salao;
