CREATE TABLE participacao_projeto(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    data_inicio TIMESTAMP NOT NULL,
    data_fim TIMESTAMP,
    funcao_voluntario VARCHAR(50) NOT NULL,
    status boolean,
    id_usuario BIGINT NOT NULL,
    id_projeto BIGINT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_projeto) REFERENCES projeto_ong(id)
)