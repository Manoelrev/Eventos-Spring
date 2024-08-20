create table Evento (

    rg varchar unique,

    nome varchar(100),
    evento_id bigint not null;
    
    CONSTRAINT evento_id FOREIGN KEY (evento_id)     
    REFERENCES Evento (id),
    primary key(rg)
    
);