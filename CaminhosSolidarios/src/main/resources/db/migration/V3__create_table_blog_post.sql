CREATE TABLE blog_post(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(70) NOT NULL,
    conteudo VARCHAR(500) NOT NULL,
    data_publi TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_usuario BIGINT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id)
)