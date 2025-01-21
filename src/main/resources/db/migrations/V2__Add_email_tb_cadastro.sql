--Migrations para add coluna de email na tabela de cadastros

ALTER TABLE tb_cadastro
ADD COLUMN email VARCHAR (120);