CREATE TABLE TOPICO (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fechaCreacion TIMESTAMP NOT NULL,
    status VARCHAR(255) NOT NULL,
    id_autor BIGINT,
    id_curso BIGINT,
    CONSTRAINT fk_topico_autor FOREIGN KEY (id_autor) REFERENCES Usuario(id),
    CONSTRAINT fk_topico_curso FOREIGN KEY (id_curso) REFERENCES Curso(id)
);
