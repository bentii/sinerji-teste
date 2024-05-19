CREATE TABLE cargo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    salario DECIMAL(10, 2),
    salario_bonus DECIMAL(10, 2),
    beneficio DECIMAL(10, 2)
);

CREATE TABLE funcionario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cargo_id INT,
    data_contratacao DATE,
    FOREIGN KEY (cargo_id) REFERENCES cargo(id)
);

CREATE TABLE venda (
    id INT AUTO_INCREMENT PRIMARY KEY,
    funcionario_id INT,
    data_venda DATE,
    valor_vendido DECIMAL(10, 2),
    FOREIGN KEY (funcionario_id) REFERENCES funcionario(id)
);