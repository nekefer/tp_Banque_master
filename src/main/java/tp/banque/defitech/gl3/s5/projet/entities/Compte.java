/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.banque.defitech.gl3.s5.projet.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Amen TETTEH
 */
@Entity
@Table(name = "COMPTE")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPT",discriminatorType = DiscriminatorType.STRING,length = 2)
public abstract class Compte implements Serializable {

    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompte;
    private String numeroCompte;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreation;
    private Double solde;
    
    @ManyToOne
    @JoinColumn(name = "CODE_CLIENT")
    private Personne client;
    @OneToMany(mappedBy="compte")
    @JsonIgnore
    private List<Operation> operations;
    
    @ManyToOne
    @JoinColumn(name = "CODE_EMPLOYE")
    private Personne employe;

    public Compte() {
    }

    public Compte(Integer idCompte,String numeroCompte, Date dateCreation, Double solde, Personne client, Personne employe) {
        this.idCompte = idCompte;
        this.numeroCompte = numeroCompte;
        this.dateCreation = dateCreation;
        this.solde = solde;
        this.client = client;
        this.employe = employe;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Personne getClient() {
        return client;
    }

    public void setClient(Personne client) {
        this.client = client;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public Personne getEmploye() {
        return employe;
    }

    public void setEmploye(Personne employe) {
        this.employe = employe;
    }

    public Integer getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Integer idCompte) {
        this.idCompte = idCompte;
    }
    

}
