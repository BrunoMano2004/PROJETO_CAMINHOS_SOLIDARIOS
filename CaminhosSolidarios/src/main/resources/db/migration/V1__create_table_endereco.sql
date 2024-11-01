CREATE TABLE endereco(
    id bigint NOT NULL PRIMARY KEY auto_increment,
    logradouro VARCHAR(80) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    complemento VARCHAR(80),
    numero VARCHAR(10),
    cep VARCHAR(8)
)