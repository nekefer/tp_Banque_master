package tp.banque.defitech.gl3.s5.projet.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tp.banque.defitech.gl3.s5.projet.entities.Personne;
import tp.banque.defitech.gl3.s5.projet.repositories.PersonneRepository;

/**
 *
 * @author Administrateur
 */
@RestController
@RequestMapping("/banque/personne")
public class PersonneController {
    @Autowired
    PersonneRepository personneRepository;
    
    @GetMapping
    public  List<Personne> list(){
        return  personneRepository.findAll();
    }
    @GetMapping
    @RequestMapping("{id}")
    public  Personne get(@PathVariable Integer id){
        return  personneRepository.findById(id).get();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Personne create(@RequestBody final Personne personne){
        //Vous aurez besoin de vérifier l'existence d'enregistrements fils
        return personneRepository.saveAndFlush(personne);         
    }
    @RequestMapping(value = "{id)",method = RequestMethod.DELETE)
    public void delete(Integer id){
        //Vous aurez besoin de vérifier l'existence d'enregistrements fils
        personneRepository.deleteById(id);
         
    }
    @RequestMapping(value = "{id)",method = RequestMethod.PUT)
    public Personne update(@PathVariable Integer id,@RequestBody Personne personne){
        Personne existingPersonne=(Personne)personneRepository.getOne(id);
        BeanUtils.copyProperties(personne,existingPersonne,"personneId");
        return personneRepository.saveAndFlush(existingPersonne);
    }
                                      
}
