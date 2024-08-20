package com.estudos.hellospring.models;

import org.springframework.data.repository.CrudRepository;
import java.util.List;




public interface ConvidadoRepository extends CrudRepository<Convidado, String>{
    List<Convidado> findByEvento(Evento evento);
    List<Convidado> findAllByEvento(Evento evento);

    void deleteAllByEvento(Evento evento);
}
