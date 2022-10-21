package com.projects.affectation.backend.entity;


import javax.persistence.*;
import java.util.Date;


@NamedQueries({
        @NamedQuery( query = "select j from Affecter j where j.date=?0", name = "given by Date"),
        @NamedQuery( query = "select j from Affecter j ", name = "given all affecter")

})
@Entity
@Table(name ="AFFECTER")
public class Affecter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_affecter", nullable = false)
    private int idAffecter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_employe")
    private Employe employe;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lieu")
    private Lieu lieu;

    @Column(name = "date")
    private Date date ;

    public int getIdAffecter() {
        return idAffecter;
    }

    public void setIdAffecter(int idAffecter) {
        this.idAffecter = idAffecter;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
