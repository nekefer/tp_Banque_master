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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
 *
 * @author Amen TETTEH
 */
@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {
private double decouvert;

public CompteCourant(){
    super();
}

    public CompteCourant(Integer idCompte, String numeroCompte, Date dateCreation, Double solde, Personne client, Personne employe) {
        super(idCompte, numeroCompte, dateCreation, solde, client, employe);
        this.decouvert=decouvert;
    }

    

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }

   
    
}
