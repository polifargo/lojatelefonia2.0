CREATE TABLE CLIENTES
(
ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NOME VARCHAR(255),
NASCIMENTO VARCHAR(12),
TELEFONE VARCHAR(30),
RUA VARCHAR(100),
COMPLEMENTO VARCHAR(50),
CEP VARCHAR (9),
NUMCASA VARCHAR (10),
EMAIL VARCHAR(255),
CPF VARCHAR(14) UNIQUE,
CONSTRAINT PRIMARY_KEY PRIMARY KEY (ID)
);

CREATE TABLE PRODUTOS
(
ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NOME VARCHAR(255),
DESCRICAO VARCHAR(255),
MARCA VARCHAR(50),
NUMPRODUTO VARCHAR(4) UNIQUE,
FABRICACAO VARCHAR(12),
QTD INTEGER,
VALOR DOUBLE,
PRIMARY KEY (ID)
) ;

CREATE TABLE VENDA 
(
IDCARRINHO INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
VALORUNI DOUBLE,
VALOR DOUBLE,
PRODUTO VARCHAR(255),
QTD INTEGER,
PRIMARY KEY (IDCARRINHO)
) ;

CREATE TABLE LISTAGEM
(
IDLISTAGEM INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
PRODUTOS VARCHAR(300),
VALOR_TOTAL DOUBLE,
CLIENTE VARCHAR(255),
QTD_ITEMS INTEGER,
DATA_VENDA VARCHAR(35),
PRIMARY KEY (IDLISTAGEM)
) ;