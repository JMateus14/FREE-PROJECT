-- Creación de la base de datos (ajusta el nombre)
CREATE DATABASE IF NOT EXISTS goleiro_rush_db;
USE goleiro_rush_db;

-- Tabla de usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de puntuaciones
CREATE TABLE IF NOT EXISTS puntuaciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    puntuacion INT NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modo_juego VARCHAR(50) NOT NULL, -- Ej: "Clásico", "Supervivencia"
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Tabla de logros (achievements)
CREATE TABLE IF NOT EXISTS logros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL, -- Ej: "Atajó 100 balones"
    descripcion TEXT,
    icono VARCHAR(255) -- Ruta del icono
);

-- Insertar datos iniciales (opcional)
INSERT INTO logros (nombre, descripcion) VALUES 
    ('Primera atajada', '¡Atajó su primer balón!'),
    ('Supervivencia', 'Sobrevivió 1 minuto en modo difícil');