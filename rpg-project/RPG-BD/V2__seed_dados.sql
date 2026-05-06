-- =============================================
-- V2__seed_dados.sql
-- Dados iniciais do personagem
-- =============================================

-- Atributos base
INSERT INTO atributos (nome, valor) VALUES
    ('Força',      0),
    ('Agilidade',  0),
    ('Intelecto',  0),
    ('Presença',   0),
    ('Vitalidade', 0),
    ('Sorte',      0);

-- Substatus
INSERT INTO substatus (nome, categoria, valor) VALUES
    ('Sobrevivência',          'Práticas', 0),
    ('Primeiros Socorros',     'Práticas', 0),
    ('Mecânica',               'Práticas', 0),
    ('Tecnologia',             'Práticas', 0),
    ('Improvisação',           'Práticas', 0),
    ('Medicina Avançada',      'Práticas', 0),
    ('Engenharia',             'Práticas', 0),
    ('Pilotagem',              'Práticas', 0),
    ('Artes Marciais',         'Combate',  0),
    ('Armas Improvisadas',     'Combate',  0),
    ('Luta',                   'Combate',  0),
    ('Explosivos',             'Combate',  0),
    ('Mira',                   'Combate',  0),
    ('Reflexo',                'Combate',  0),
    ('Bloqueio',               'Combate',  0),
    ('Esquiva',                'Combate',  0),
    ('Contra-Ataque Total',    'Combate',  0),
    ('Intimidação',            'Mental',   0),
    ('Persuasão',              'Mental',   0),
    ('Enganação',              'Mental',   0),
    ('Ocultismo',              'Mental',   0),
    ('Investigação',           'Mental',   0),
    ('Liderança',              'Mental',   0),
    ('Negociação',             'Mental',   0),
    ('Psicologia',             'Mental',   0),
    ('Furtividade',            'Extras',   0),
    ('Rastreamento',           'Extras',   0),
    ('Percepção',              'Extras',   0),
    ('Iniciativa',             'Extras',   0),
    ('Conhecimento Elemental', 'Extras',   0),
    ('Resistência Mental',     'Extras',   0),
    ('Instinto Sobrevivente',  'Extras',   0);

-- Status fixo: vida atual começa igual à vida total (50 + 5*vitalidade = 65)
INSERT INTO status_fixos (chave, valor) VALUES
    ('vida_atual', 50 + 5 * (SELECT valor FROM atributos WHILE (nome = 'Vitalidade')));

-- Acessórios disponíveis
INSERT INTO acessorios (nome, bonus, equipado) VALUES
    ('Bolsa',                 1, FALSE),
    ('Mochila',               3, FALSE),
    ('Mochila de Acampamento',5, FALSE);