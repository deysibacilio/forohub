CREATE TABLE topico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    status VARCHAR(20) NOT NULL,
    autor BIGINT,  -- Cambiado a BIGINT para referenciar al id de la tabla usuarios
    curso VARCHAR(255) NOT NULL,
    INDEX (autor),  -- Índice para autor para búsquedas más rápidas
    INDEX (curso)  -- Índice para curso para búsquedas más rápidas
);
