drop database login;
create database login;
use login;

create table clientes (
id int primary key auto_increment,
login varchar(15) not null,
senha CHAR(64) );

insert into clientes (ogin, senha) values
('samara.souza', '7837yhu77');

create user 'seu_usuario'@'localhost' identified by 'sua_senha';
grant all privileges on login.* to 'seu_usuario'@'localhost';
flush privileges;


select * from  clientes;

ALTER TABLE clientes ADD COLUMN nivel_acesso VARCHAR(10);

CREATE TABLE logins (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(100),
    data_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    sucesso BOOLEAN
);

select * from logins;

INSERT INTO logins (login, sucesso) VALUES ('sarah.souza', true);

