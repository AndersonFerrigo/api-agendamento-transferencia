CREATE TABLE IF NOT EXISTS conta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS transferencia (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    conta_origem_id BIGINT NOT NULL,
    conta_destino_id BIGINT NOT NULL,
    valor DECIMAL(19,2) NOT NULL,
    taxa DECIMAL(19,2) NOT NULL,
    data_transferencia DATE NOT NULL,
    data_agendamento DATE NOT NULL,
    FOREIGN KEY (conta_origem_id) REFERENCES conta(id),
    FOREIGN KEY (conta_destino_id) REFERENCES conta(id)
);