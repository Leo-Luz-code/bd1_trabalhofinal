INSERT INTO funcionario (id_func, nome, email, id_gerente) 
VALUES (1, 'joao', 'jp@uesb.com', 0);

INSERT INTO cliente (nome, cpf, telefone, email)
VALUES 
('LEO', '12345678913', '(71) 91234-6897', 'cronos@gmail.com'),
('CAMILLA', '12345678913', '(71) 91234-6897', 'camilla@gmail.com');

INSERT INTO hotel (id_hotel, nome, cidade, estado, cnpj)
VALUES
    (3, 'Pousada Estrela do Mar', 'Florianópolis', 'SC', '12.315.678/0002-23'),
    (4, 'Hotel Monte Verde', 'Gramado', 'RS', '23.451.789/0001-34'),
    (5, 'Resort Paraíso Tropical', 'Natal', 'RN', '33.567.890/0001-45'),
    (6, 'Hotel Serra Dourada', 'Cuiabá', 'MT', '43.678.901/0001-56'),
    (7, 'Pousada Lua Cheia', 'Jericoacoara', 'CE', '53.789.012/0001-67');

INSERT INTO hotel (nome, cidade, estado, cnpj)
VALUES
    ('Pousada Estrela do Mar', 'Florianópolis', 'SC', '12.345.678/0002-23'),
    ('Hotel Monte Verde', 'Gramado', 'RS', '23.456.789/0001-34'),
    ('Resort Paraíso Tropical', 'Natal', 'RN', '34.567.890/0001-45'),
    ('Hotel Serra Dourada', 'Cuiabá', 'MT', '45.678.901/0001-56'),
    ('Pousada Lua Cheia', 'Jericoacoara', 'CE', '56.789.012/0001-67'),
    ('Residencial Corcovado', 'Rio de Janeiro', 'RJ', '67.890.123/0001-78'),
    ('Pousada da Serra', 'Teresópolis', 'RJ', '78.901.234/0001-89'),
    ('Hotel Vale Verde', 'Belo Horizonte', 'MG', '89.012.345/0001-90'),
    ('Pousada das Flores', 'Salvador', 'BA', '90.123.456/0001-01'),
    ('Hotel do Bosque', 'Curitiba', 'PR', '01.234.567/0001-12'),
    ('Resort das Águas', 'Caldas Novas', 'GO', '12.345.678/0001-23'),
    ('Pousada do Sol', 'Fortaleza', 'CE', '23.456.789/0005-34'),
    ('Hotel Fazenda Primavera', 'Goiânia', 'GO', '34.567.890/0801-45'),
    ('Pousada do Cerrado', 'Brasília', 'DF', '45.678.901/0071-56'),
    ('Resort das Dunas', 'Maceió', 'AL', '56.789.012/0004-67');

INSERT INTO empresatransporte (nome, cidade, estado, cnpj)
VALUES
    ('Transporte Rápido', 'São Paulo', 'SP', '12.345.678/0001-23'),
    ('Transporte Seguro', 'Rio de Janeiro', 'RJ', '23.456.789/0001-34'),
    ('TransTour', 'Belo Horizonte', 'MG', '34.567.890/0001-45'),
    ('Transporte Expresso', 'Curitiba', 'PR', '45.678.901/0001-56'),
    ('Viagem Segura', 'Porto Alegre', 'RS', '56.789.012/0001-67'),
    ('Turismo VIP', 'Brasília', 'DF', '67.890.123/0001-78'),
    ('Rota Feliz', 'Salvador', 'BA', '78.901.234/0001-89'),
    ('Transporte Conforto', 'Fortaleza', 'CE', '89.012.345/0001-90'),
    ('CidadeTour', 'Goiânia', 'GO', '90.123.456/0001-01'),
    ('Turismo Premium', 'Recife', 'PE', '01.234.567/0001-12'),
    ('Passeio Tranquilo', 'Manaus', 'AM', '12.345.678/0001-23'),
    ('Turismo Charme', 'Belém', 'PA', '23.456.789/0001-34'),
    ('Viagem Inteligente', 'Porto Velho', 'RO', '34.567.890/0001-45'),
    ('Transporte Amigável', 'Cuiabá', 'MT', '45.678.901/0001-56'),
    ('Passeio Seguro', 'João Pessoa', 'PB', '56.789.012/0001-67');
	
	
INSERT INTO pacote_pagamento (data_criacao, fk_funcionario_id_func, valor, status, data_pagamento)
VALUES 
(NOW(), 1, 100.00, 'Pago', NOW()),
(NOW(), 1, 150.00, 'Pago', NOW()),
(NOW(), 1, 100.00, 'Pendente', NOW()),
(NOW(), 1, 150.00, 'Sendo Processado', NOW()),
(NOW(), 1, 100.00, 'Pago', NOW()),
(NOW(), 1, 150.00, 'Pago', NOW()),
(NOW(), 1, 100.00, 'Pendente', NOW()),
(NOW(), 1, 150.00, 'Pendente', NOW()),
(NOW(), 1, 100.00, 'Pago', NOW()),
(NOW(), 1, 150.00, 'Pago', NOW()),
(NOW(), 1, 100.00, 'Sendo Processado', NOW()),
(NOW(), 1, 150.00, 'Pago', NOW());

INSERT INTO reserva (fk_hotel_id_hotel, fk_pacote_pagamento_id_pacote, data_reserva, check_in, check_out, valor)
VALUES 
(1, 1, NOW(), NOW(), NOW() + INTERVAL '3 days', 80.00),
(2, 2, NOW(), NOW() + INTERVAL '1 days', NOW() + INTERVAL '11 days', 120.00),
(3, 5, NOW(), NOW(), NOW() + INTERVAL '3 days', 90.00),
(4, 6, NOW(), NOW() + INTERVAL '2 days', NOW() + INTERVAL '12 days', 150.00),
(5, 7, NOW(), NOW(), NOW() + INTERVAL '3 days', 80.00),
(6, 8, NOW(), NOW() + INTERVAL '3 days', NOW() + INTERVAL '13 days', 200.00);

CREATE VIEW view_pacote_reserva AS
SELECT 
    pp.id_pacote AS id_pacote,
    f.nome AS funcionario_criador,
    r.valor AS valor_reserva,
    r.check_in,
    r.check_out
FROM 
    pacote_pagamento pp
JOIN
    funcionario f ON pp.fk_funcionario_id_func = f.id_func
JOIN
    reserva r ON pp.id_pacote = r.fk_pacote_pagamento_id_pacote;
	
CREATE VIEW view_pacote_reserva_hotel AS
SELECT 
    pp.id_pacote AS id_pacote,
    f.nome AS funcionario_criador,
    r.valor AS valor_reserva,
    r.check_in,
    r.check_out,
    h.nome AS nome_hotel
FROM 
    pacote_pagamento pp
JOIN
    funcionario f ON pp.fk_funcionario_id_func = f.id_func
JOIN
    reserva r ON pp.id_pacote = r.fk_pacote_pagamento_id_pacote
JOIN
    hotel h ON r.fk_hotel_id_hotel = h.id_hotel;

-- Query com group by
SELECT h.nome as hotel, fk_hotel_id_hotel as id_hotel, SUM(valor) as rendimento_total
FROM reserva
JOIN hotel h on fk_hotel_id_hotel = id_hotel
GROUP BY fk_hotel_id_hotel, h.nome;

select status, COUNT(status)
from pacote_pagamento
group by status;

select * from view_pacote_reserva;
select * from view_pacote_reserva_hotel;
select * from pacote_pagamento;
select * from funcionario;
select * from reserva;