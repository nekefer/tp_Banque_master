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
import tp.banque.defitech.gl3.s5.projet.entities.Compte;
import tp.banque.defitech.gl3.s5.projet.repositories.CompteRepository;

/**
 *
 * @author Administrateur
 */
@RestController
@RequestMapping("/banque/compte")
public class CompteController {
    @Autowired
    CompteRepository compteRepository;
    
    @GetMapping
    public  List<Compte> list(){
        System.out.println("List*****************************************");
        return  compteRepository.findAll();
    }
    @GetMapping
    @RequestMapping("{id}")
    public  Compte get(@PathVariable Integer id){
        return  compteRepository.findById(id).get();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Compte create(@RequestBody final Compte compte){
        //Vous aurez besoin de vérifier l'existence d'enregistrements fils
        return compteRepository.saveAndFlush(compte);
         
    }
    @RequestMapping(value = "{id)",method = RequestMethod.DELETE)
    public void delete(Integer id){
        //Vous aurez besoin de vérifier l'existence d'enregistrements fils
        compteRepository.deleteById(id);
         
    }
    @RequestMapping(value = "{id)",method = RequestMethod.PUT)
    public Compte update(@PathVariable Integer id,@RequestBody Compte compte){
        Compte existingCompte=(Compte)compteRepository.getOne(id);
        BeanUtils.copyProperties(compte,existingCompte,"idCompte");
        return compteRepository.saveAndFlush(existingCompte);
    }
                                      
}
