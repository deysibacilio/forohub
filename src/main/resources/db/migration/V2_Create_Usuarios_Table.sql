CREATE TABLE usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    login VARCHAR(100) NOT NULL,
    clave VARCHAR(300) NOT NULL,  -- Asegúrate de almacenar las contraseñas de forma segura (hashed)
    email VARCHAR(255),  -- Campo adicional para el correo electrónico del usuario
    nombre VARCHAR(255) NOT NULL,
    perfiles VARCHAR(255),
    PRIMARY KEY (id)
);
