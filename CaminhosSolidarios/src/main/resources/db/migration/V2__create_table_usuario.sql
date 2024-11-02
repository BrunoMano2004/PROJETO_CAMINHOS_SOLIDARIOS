CREATE TABLE usuario(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome_completo VARCHAR(60) NOT NULL,
    email VARCHAR(60) NOT NULL,
    cpf VARCHAR(11),
    telefone VARCHAR(13),
    status BOOLEAN
)