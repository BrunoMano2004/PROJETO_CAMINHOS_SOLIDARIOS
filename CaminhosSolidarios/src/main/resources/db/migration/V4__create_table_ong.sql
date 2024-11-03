CREATE TABLE ong(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(500) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(13) NOT NULL,
    website VARCHAR(200),
    status boolean,
    id_endereco BIGINT NOT NULL,
    FOREIGN KEY (id_endereco) REFERENCES endereco(id)
)