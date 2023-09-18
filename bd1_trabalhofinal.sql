/* Lógico_2: */

CREATE DATABASE bd1_trabalhofinal;

CREATE TABLE Cliente (
    id_cliente SERIAL,
    nome VARCHAR(255),
    cpf VARCHAR(255),
    telefone VARCHAR(255),
    email VARCHAR(255),
    PRIMARY KEY (id_cliente),
	UNIQUE (cpf, telefone, email),
	CONSTRAINT check_cpf CHECK (cpf ~ '^[0-9]{11}$'),
    CONSTRAINT check_telefone CHECK (telefone ~ '^\([1-9]{2}\) 9[0-9]{4}-[0-9]{4}$'),
	CONSTRAINT check_email CHECK (email ~ '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$')
);

CREATE TABLE Atendimento (
	id_atendimento SERIAL,
	fk_Funcionario_id_func INT,
    fk_Cliente_id_cliente INT, 
	data_atendimento TIMESTAMP
);

CREATE TABLE Funcionario (
    id_func SERIAL,
    nome VARCHAR(255),
	email VARCHAR(255) UNIQUE,
    id_gerente INT,
	PRIMARY KEY (id_func),
	CONSTRAINT check_email CHECK (email ~ '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$')
);

CREATE TABLE Hotel (
    id_hotel SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    cidade VARCHAR(255),
    estado VARCHAR(255),
    cnpj VARCHAR(255),
	UNIQUE (cnpj),
	CONSTRAINT check_cpnj CHECK (cnpj ~ '^\d{2}\.\d{3}\.\d{3}/\d{4}-\d{2}$')
);

CREATE TABLE EmpresaTransporte (
    id_empresa SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    cidade VARCHAR(255),
    estado VARCHAR(255),
    cnpj VARCHAR(255),
	UNIQUE (nome, cnpj),
	CONSTRAINT check_cpnj CHECK (cnpj ~ '^\d{2}\.\d{3}\.\d{3}/\d{4}-\d{2}$')
);

CREATE TYPE status AS ENUM (
    'Pago',
    'Sendo Processado',
    'Pendente'
);

/* Quando formos adicionar o pagamento ao pacote, 
   adicionaremos como o proximo valor da sequencia,
   uma vez que id_pagamento pode ser null...
   
   OBS: nextval('pagamento_id_seq') */
CREATE SEQUENCE pagamento_id_seq START 1;
CREATE TABLE Pacote_pagamento (
    id_pacote SERIAL,
    data_criacao TIMESTAMP,
    fk_Funcionario_id_func INT,
    id_pagamento INT,
    fk_Cliente_id_cliente INT,
    valor DOUBLE PRECISION,
    status status,
    data_pagamento TIMESTAMP,
    PRIMARY KEY (id_pacote),
	UNIQUE (id_pagamento),
	CONSTRAINT check_id_pagamento CHECK (
    	(id_pagamento IS NULL) OR (id_pagamento > 0)
	)
);

CREATE TABLE Boleto (
    cod_barras VARCHAR(44),
    fk_pagamento_id_pagamento INT,
    PRIMARY KEY (fk_pagamento_id_pagamento),
	UNIQUE(cod_barras)
);

CREATE TABLE Cartao (
    numero VARCHAR(25),
    fk_pagamento_id_pagamento INT,
    PRIMARY KEY (fk_pagamento_id_pagamento),
	UNIQUE(numero),
	CONSTRAINT check_cartao CHECK (numero ~ '^\d{13,19}$')
);

CREATE TABLE PIX (
    conta VARCHAR(25),
    instituicao VARCHAR(255),
    fk_pagamento_id_pagamento INT,
    PRIMARY KEY (fk_pagamento_id_pagamento),
	UNIQUE(conta),
	CONSTRAINT check_conta CHECK (conta ~ '^\d{6,12}$')
);

CREATE TABLE Reserva (
    fk_Hotel_id_hotel INT,
    fk_Pacote_pagamento_id_pacote INT,
    id_reserva SERIAL PRIMARY KEY,
    data_reserva TIMESTAMP,
    check_in TIMESTAMP,
    check_out TIMESTAMP,
    valor DOUBLE PRECISION
);

CREATE TYPE meio AS ENUM (
    'Avião',
    'Ônibus',
    'Barco',
	'Trem'
);

CREATE TABLE Transporta (
    fk_EmpresaTransporte_id_empresa INT,
    fk_Pacote_pagamento_id_pacote INT,
    id_viagem SERIAL PRIMARY KEY,
    data_viagem TIMESTAMP,
    check_in TIMESTAMP,
    valor DOUBLE PRECISION,
    meio meio
);

CREATE TABLE Faz (
    fk_Cliente_id_cliente INT,
    fk_pagamento_id_pagamento INT
);
 
ALTER TABLE Atendimento ADD CONSTRAINT FK_Atendimento_2
    FOREIGN KEY (fk_Funcionario_id_func)
    REFERENCES Funcionario (id_func)
    ON DELETE SET NULL;
	
ALTER TABLE Atendimento ADD CONSTRAINT FK_Atendimento_3
    FOREIGN KEY (fk_Cliente_id_cliente)
    REFERENCES Cliente (id_cliente)
    ON DELETE SET NULL;
 
ALTER TABLE Funcionario ADD CONSTRAINT FK_Funcionario_2
    FOREIGN KEY (id_gerente)
    REFERENCES Funcionario (id_func);
 
ALTER TABLE Pacote_pagamento ADD CONSTRAINT FK_Pacote_pagamento_2
    FOREIGN KEY (fk_Funcionario_id_func)
    REFERENCES Funcionario (id_func)
    ON DELETE SET NULL;
	
ALTER TABLE Pacote_pagamento ADD CONSTRAINT FK_Pacote_pagamento_3
    FOREIGN KEY (fk_Cliente_id_cliente)
    REFERENCES Cliente (id_cliente)
    ON DELETE SET NULL;
 
ALTER TABLE Boleto ADD CONSTRAINT FK_Boleto_2
    FOREIGN KEY (fk_pagamento_id_pagamento)
    REFERENCES Pacote_pagamento (id_pagamento);
 
ALTER TABLE Cartao ADD CONSTRAINT FK_Cartao_2
    FOREIGN KEY (fk_pagamento_id_pagamento)
    REFERENCES Pacote_pagamento (id_pagamento);
 
ALTER TABLE PIX ADD CONSTRAINT FK_PIX_2
    FOREIGN KEY (fk_pagamento_id_pagamento)
    REFERENCES Pacote_pagamento (id_pagamento);
 
ALTER TABLE Reserva ADD CONSTRAINT FK_Reserva_2
    FOREIGN KEY (fk_Hotel_id_hotel)
    REFERENCES Hotel (id_hotel)
    ON DELETE RESTRICT;
 
ALTER TABLE Reserva ADD CONSTRAINT FK_Reserva_3
    FOREIGN KEY (fk_Pacote_pagamento_id_pacote)
    REFERENCES Pacote_pagamento (id_pacote)
    ON DELETE SET NULL;
 
ALTER TABLE Transporta ADD CONSTRAINT FK_Transporta_2
    FOREIGN KEY (fk_EmpresaTransporte_id_empresa)
    REFERENCES EmpresaTransporte (id_empresa)
    ON DELETE RESTRICT;
 
ALTER TABLE Transporta ADD CONSTRAINT FK_Transporta_3
    FOREIGN KEY (fk_Pacote_pagamento_id_pacote)
    REFERENCES Pacote_pagamento (id_pacote)
    ON DELETE SET NULL;
 
ALTER TABLE Faz ADD CONSTRAINT FK_Faz_1
    FOREIGN KEY (fk_Cliente_id_cliente)
    REFERENCES Cliente (id_cliente)
    ON DELETE SET NULL;
 
ALTER TABLE Faz ADD CONSTRAINT FK_Faz_2
    FOREIGN KEY (fk_pagamento_id_pagamento)
    REFERENCES Pacote_pagamento (id_pacote);