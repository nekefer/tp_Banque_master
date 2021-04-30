/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.banque.defitech.gl3.s5.projet.entities;

/**
 *
 * @author Administrateur
 */


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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "OPERATION")
@XmlRootElement
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OPT",discriminatorType = DiscriminatorType.STRING,length = 2)
public abstract class Operation implements Serializable {

    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOperation;
    private Integer numeroOperation;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOperation;
    private Double montantOperation;
    @JoinColumn(name = "NUMERO_COMPTE")
    @ManyToOne
    private Compte compte;
    @OneToMany
    private List<Operation> operations;
    @JoinColumn(name = "ID_PERSONNE")
    @ManyToOne
    private Personne employe;

    public Operation() {
    }

    public Operation(Integer idOperation) {
        this.idOperation = idOperation;
    }

    public Integer getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(Integer idOperation) {
        this.idOperation = idOperation;
    }

    public Integer getNumeroOperation() {
        return numeroOperation;
    }

    public void setNumeroOperation(Integer numeroOperation) {
        this.numeroOperation = numeroOperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public Double getMontantOperation() {
        return montantOperation;
    }

    public void setMontantOperation(Double montantOperation) {
        this.montantOperation = montantOperation;
    }

   

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @XmlTransient
    public List<Operation> getOperationsList() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations= operations;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperation != null ? idOperation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operation)) {
            return false;
        }
        Operation other = (Operation) object;
        if ((this.idOperation == null && other.idOperation != null) || (this.idOperation != null && !this.idOperation.equals(other.idOperation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite_class.Operations[ idOperation=" + idOperation + " ]";
    }

    public Operation(Integer numeroOperation, Date dateOperation, Double montantOperation, String typeOperation, Compte compte) {
        this.numeroOperation = numeroOperation;
        this.dateOperation = dateOperation;
        this.montantOperation = montantOperation;
        this.compte = compte;
    }

    public Operation(Date dateOperation, Double montantOperation, String typeOperation, Compte compte) {
        this.dateOperation = dateOperation;
        this.montantOperation = montantOperation;
        this.compte = compte;
    }

    
    
    
}
