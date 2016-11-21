CREATE TABLE CLIENTES
(
ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NOME VARCHAR(255),
NASCIMENTO VARCHAR(12),
TELEFONE VARCHAR(30),
ENDERECO VARCHAR(255),
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
ID_VENDA INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
VALOR_FK DOUBLE,
PRODUTO_FK VARCHAR(255),
QTD_FK INTEGER,
PRIMARY KEY (ID_VENDA)
) ;

CREATE TABLE RELATORIO
(
ID_VENDA INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
VALOR_TOTAL DOUBLE,
CLIENTE VARCHAR(255),
QTD_ITEMS INTEGER,
DATA_VENDA VARCHAR(10),
PRIMARY KEY (ID_VENDA)
) ;

CREATE TABLE INFORELATORIO
(
ID_VENDA INTEGER,
VALOR_TOTAL DOUBLE,
QTD_ITEMS INTEGER,
PRODUTO VARCHAR(255),
FOREIGN KEY (ID_VENDA) REFERENCES RELATORIO (ID_VENDA)
) ;