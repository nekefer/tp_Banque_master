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
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte
{
private double taux;
public CompteEpargne(){
    super();
}

    public CompteEpargne(double taux, Integer idCompte, String numeroCompte, Date dateCreation, Double solde, Personne client, Personne employe) {
        super(idCompte, numeroCompte, dateCreation, solde, client, employe);
        this.taux = taux;
    }

   

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
   
}
