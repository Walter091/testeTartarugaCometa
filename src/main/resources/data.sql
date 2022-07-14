CREATE TABLE ENDERECO (
    ID_ENDERECO INT NOT NULL AUTO_INCREMENT,
    NOME_RUA VARCHAR(200),
    NUMERO VARCHAR(200),
    BAIRRO VARCHAR(45),
    MUNICIPIO VARCHAR(45),
    UF VARCHAR(45),
    PRIMARY KEY (ID_ENDERECO)
);

CREATE TABLE REMETENTE (
    ID_REMETENTE INT NOT NULL AUTO_INCREMENT,
    NOME VARCHAR(200),
    RAZAO_SOCIAL VARCHAR(200),
    CNPJ_CNPF VARCHAR(45),
    ID_ENDERECO INT,
    PRIMARY KEY (ID_REMETENTE),
    CONSTRAINT fk_remetente FOREIGN KEY (ID_ENDERECO) REFERENCES endereco (ID_ENDERECO)
);

CREATE TABLE PRODUTO (
    ID_PRODUTO INT NOT NULL AUTO_INCREMENT,
    NOME VARCHAR(200),
    VOLUME VARCHAR(200),
    PESO FLOAT,
    VALOR FLOAT,
    PRIMARY KEY (ID_PRODUTO)
);

CREATE TABLE DESTINATARIO (
    ID_DESTINATARIO INT NOT NULL AUTO_INCREMENT,
    ID_LANCAMENTO INT,
    ID_ENDERECO INT,
    NOME VARCHAR(200),
    ENDERECO VARCHAR(200),
    RAZAO_SOCIAL VARCHAR(200),
    CNPJ_CNPF VARCHAR(45),
    PRIMARY KEY (ID_DESTINATARIO),
    CONSTRAINT fk_destinatario FOREIGN KEY (ID_LANCAMENTO) REFERENCES lancamento (ID_LANCAMENTO)
);

CREATE TABLE LANCAMENTO (
    ID_LANCAMENTO INT NOT NULL AUTO_INCREMENT,
    ID_PRODUTO INT,
    ID_REMETENTE INT,
    ID_DESTINATARIO INT,
    IND_STATUS_LANCAMENTO INT,
    PRIMARY KEY (ID_LANCAMENTO),
    CONSTRAINT fk_lancamento 
    FOREIGN KEY (ID_PRODUTO) REFERENCES produto (ID_PRODUTO),
    FOREIGN KEY (ID_REMETENTE) REFERENCES remetente (ID_REMETENTE),
    FOREIGN KEY (ID_DESTINATARIO) REFERENCES destinatario (ID_DESTINATARIO),
    FOREIGN KEY (ID_DESTINATARIO) REFERENCES destinatario (ID_DESTINATARIO)
);		
			