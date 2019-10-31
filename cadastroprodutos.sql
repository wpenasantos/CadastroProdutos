create table especificacoes
(
  codigo serial not null constraint produtos_pk primary key,
  fabricante varchar(40),
  cor varchar(40),
  sistema varchar(40),
  detalhes varchar(40)
);

create table produtos
(
  codigo serial not null,
  nome varchar(60),
  preco numeric,
  especificacao integer constraint produtos_especificacao_fkey references especificacoes on delete cascade
);
