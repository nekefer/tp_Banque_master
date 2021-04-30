/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.banque.defitech.gl3.s5.projet.entities;


import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 *
 * @author Amen TETTEH
 */
@Entity
@DiscriminatorValue("depot")
public class Depot extends Operation {

    public Depot() {
    }

    public Depot(Integer numeroOperation, Date dateOperation, Double montantOperation, String depot, Compte numeroCompte) {
        super(numeroOperation, dateOperation, montantOperation, depot, numeroCompte);
    }

    public Depot(Date dateOperation, Double montantOperation, String depot, Compte numeroCompte) {
        super(dateOperation, montantOperation, depot, numeroCompte);
    }

  
}
