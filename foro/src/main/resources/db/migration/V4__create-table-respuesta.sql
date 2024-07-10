CREATE TABLE RESPUESTA (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    id_topico BIGINT NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    id_autor BIGINT NOT NULL,
    es_solucion BOOLEAN,
    CONSTRAINT fk_respuesta_topico FOREIGN KEY (id_topico) REFERENCES Topico(id),
    CONSTRAINT fk_respuesta_autor FOREIGN KEY (id_autor) REFERENCES Usuario(id)
);
