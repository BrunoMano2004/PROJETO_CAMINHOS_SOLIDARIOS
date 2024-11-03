CREATE TABLE solicitacao_participacao(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    status VARCHAR(20) NOT NULL,
    data TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    motivo VARCHAR(100),
    id_usuario BIGINT NOT NULL,
    id_participacao_projeto BIGINT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_participacao_projeto) REFERENCES participacao_projeto(id)
)