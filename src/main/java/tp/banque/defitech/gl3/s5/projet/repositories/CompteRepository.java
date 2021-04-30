package tp.banque.defitech.gl3.s5.projet.repositories;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.springframework.data.jpa.repository.JpaRepository;
import tp.banque.defitech.gl3.s5.projet.entities.Compte;

/**
 *
 * @author Administrateur
 */
public interface CompteRepository extends JpaRepository<Compte,Integer>{
    
}
