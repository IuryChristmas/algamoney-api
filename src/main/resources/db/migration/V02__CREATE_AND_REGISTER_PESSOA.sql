create table if not exists pessoa (
codigo serial,
nome varchar(200) not null,
logradouro varchar(200),
numero varchar(20),
complemento varchar(200),
bairro varchar(100),
cep varchar(15),
cidade varchar(100),
estado varchar(100),
ativo boolean not null,
PRIMARY KEY (codigo)
);

insert into pessoa (nome, logradouro, numero, bairro, cep, cidade, estado, ativo) values ('Iury', 'R Tarrafas', '97', 'Barra do Ceará', '60332520', 'Fortaleza', 'CE', true);
insert into pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Josi', 'Rua José Marcelino Pinto', '1001 fundos', 'casa 2','Bairro Pires', '06950000', 'Juquitiba', 'SP', true);
insert into pessoa (nome, logradouro, numero, bairro, cep, cidade, estado, ativo) values ('Andrea', 'R Cristal', '96', 'Carlito Pamplona', '60326040', 'Fortaleza', 'CE', true);
insert into pessoa (nome, logradouro, numero, bairro, cep, cidade, estado, ativo) values ('Carlos', 'Vila Valença', '115', 'Moura Brasil', '60010030', 'Fortaleza', 'CE', true);
insert into pessoa (nome, logradouro, numero, bairro, cep, cidade, estado, ativo) values ('Dario', 'Rua Adarias de Lima ', '15', 'Moura Brasil', '60010130', 'Fortaleza', 'CE', true);
insert into pessoa (nome, logradouro, numero, bairro, cep, cidade, estado, ativo) values ('Marcela', 'Avenida Filomeno Gomes', '593', 'Jacarecanga', '60010280', 'Fortaleza', 'CE', true);