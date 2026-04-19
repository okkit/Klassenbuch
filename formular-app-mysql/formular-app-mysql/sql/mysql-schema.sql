CREATE DATABASE IF NOT EXISTS formulardb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE formulardb;

CREATE TABLE IF NOT EXISTS formular (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titel VARCHAR(255) NOT NULL,
    beschreibung TEXT NOT NULL,
    newsletter BOOLEAN NOT NULL,
    datenschutz_akzeptiert BOOLEAN NOT NULL,
    kategorie VARCHAR(50) NOT NULL,
    erstellt_am TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
