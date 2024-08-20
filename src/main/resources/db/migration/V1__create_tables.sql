create table Evento (

    id bigint auto_increment not null unique,

    nome varchar(100),
    localizacao varchar(100),
    datalocal varchar(300),
    horario varchar(300),
    
    primary key(id)
);