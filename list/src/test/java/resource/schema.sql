DROP TABLE IF EXISTS tb_tarefa;
DROP TABLE IF EXISTS tb_user;

CREATE TABLE tb_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
);

CREATE TABLE tb_tarefa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    categoria VARCHAR(50) NOT NULL,
    data_limite TIMESTAMP,
    user_id BIGINT NOT NULL,
    
    CONSTRAINT fk_tarefa_user 
        FOREIGN KEY (user_id) 
        REFERENCES tb_user(id) 
        ON DELETE CASCADE
);