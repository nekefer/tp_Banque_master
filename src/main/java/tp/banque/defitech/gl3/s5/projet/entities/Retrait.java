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
 * @author ASUS
 */
@Entity
@DiscriminatorValue("retrait")
public class Retrait extends Operation {

    public Retrait() {
    }

    public Retrait(Integer numeroOperation, Date dateOperation, Double montantOperation, String retrait, Compte numeroCompte) {
        super(numeroOperation, dateOperation, montantOperation, retrait, numeroCompte);
    }

    public Retrait(Date dateOperation, Double montantOperation, String retrait, Compte numeroCompte) {
        super(dateOperation, montantOperation, retrait, numeroCompte);
    }
    
}
