package com.estudos.hellospring.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estudos.hellospring.models.Convidado;
import com.estudos.hellospring.models.ConvidadoRepository;
import com.estudos.hellospring.models.Evento;
import com.estudos.hellospring.models.EventoRepostory;

import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EventoControle {

    @Autowired
    private EventoRepostory repository;
    @Autowired
    private ConvidadoRepository convidadorepository;
    
    @RequestMapping("/evento")
    public String PaginaFormulario() {
        return "web/formularioevento";
    }

    @PostMapping("/evento")
    @Transactional
    public String CadastrarEvento(@RequestParam String nome, @RequestParam String local, @RequestParam String data, @RequestParam String horario) {
        repository.save(new Evento(nome,local,data,horario));

        return "redirect:/";
    }
    

    @GetMapping("/")
    public ModelAndView listarEventos() {
        ModelAndView mv = new ModelAndView("web/index");
        Iterable<Evento> eventos = repository.findAll();
        mv.addObject("eventos", eventos);
        return mv;
    }
    
    @GetMapping("/detalhes/{id}")
    public ModelAndView pegarDetalhes(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("web/detalhes");
        Evento evento = repository.findById(id).get();
        Iterable<Convidado> convidados = convidadorepository.findAllByEvento(evento);
        mv.addObject("evento", evento);
        mv.addObject("convidados", convidados);
        return mv;
    }

    @GetMapping("/deletar/evento/{id}")
    @Transactional
    public String deletarEvento(@PathVariable Long id) {
        convidadorepository.deleteAllByEvento(repository.findById(id).get());
        repository.deleteById(id);
        return "redirect:/";
    }
    
    
    
    @PostMapping("/detalhes/{id}")
    public String adicionarConvidado(@PathVariable Long id, @RequestParam String rg, @RequestParam String nome) {
        Evento evento = repository.findById(id).get();
        convidadorepository.save(new Convidado(rg, nome, evento));
        return "redirect:/detalhes/{id}";
    }
    
    @GetMapping("/deletar/Convidados/{rg}")
    @Transactional
    public String deletarconvidado(@PathVariable String rg) {
        Long id = convidadorepository.findById(rg).get().getEvento().getId();
        convidadorepository.deleteById(rg);
        return "redirect:/detalhes/"+id;
    }
    
}
