/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.banque.defitech.gl3.s5.projet.entities;

/**
 *
 * @author Administrateur
 */


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "PERSONNE")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TP",discriminatorType = DiscriminatorType.STRING,length =3)
public abstract class Personne implements Serializable {

  
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersonne;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String email;
    private String code;
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Compte> comptes;
   
    @JoinColumn(name = "MANAGER_ID")
    @ManyToOne
    private Personne manager;

    public Personne() {
        super();
    }
    
    public Personne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Integer getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode()  {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    @XmlTransient
    public List<Compte> getComptes() {
        return comptes;
    }

    public void setCompteList(List<Compte> compteList) {
        this.comptes = compteList;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonne != null ? idPersonne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.idPersonne == null && other.idPersonne != null) || (this.idPersonne != null && !this.idPersonne.equals(other.idPersonne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite_class.Personne[ idPersonne=" + idPersonne + " ]";
    }

    public Personne(Integer idPersonne, String nom, String prenom, String adresse, String telephone, String email, String code, Personne manager) {
        this.idPersonne = idPersonne;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.code = code;       
        this.manager = manager;
    }
    
    
    
}
