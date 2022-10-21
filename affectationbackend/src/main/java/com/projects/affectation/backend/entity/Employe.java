package com.projects.affectation.backend.entity;


import javax.persistence.*;
import java.util.Set;


@NamedQueries({
        @NamedQuery(query = "select j from Employe j ", name = "given all employe")
})

@Entity
@Table(name ="EMPLOYE")
public class Employe {
    @Id
    @Column(name = "id_employe", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmploye;

    @Column(name = "codeemp")
    private String codeEmploye ;
    @Column(name = "nom")
    private String nom ;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "poste")
    private String poste;


    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getCodeEmploye() {
        return codeEmploye;
    }

    public void setCodeEmploye(String codeEmploye) {
        this.codeEmploye = codeEmploye;
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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }
}
