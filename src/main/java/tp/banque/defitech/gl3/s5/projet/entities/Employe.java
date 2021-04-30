/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.banque.defitech.gl3.s5.projet.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 *
 * @author Amen TETTEH
 */
@Entity
@DiscriminatorValue("EMP")
public class Employe extends Personne{

    public Employe() {
        super();
    }

    public Employe(Integer idPersonne, String nom, String prenom, String adresse, String telephone, String email, String code, Personne idSuperieurHierarchique) {
        super(idPersonne, nom, prenom, adresse, telephone, email, code, idSuperieurHierarchique);
    }    
}
