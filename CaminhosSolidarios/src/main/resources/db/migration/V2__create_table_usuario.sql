CREATE TABLE usuario(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_endereco BIGINT NOT NULL,
    nome_completo VARCHAR(60) NOT NULL,
    email VARCHAR(60) NOT NULL,
    cpf VARCHAR(11),
    telefone VARCHAR(13),
    status BOOLEAN,
    FOREIGN KEY (id_endereco) REFERENCES endereco(id)
)