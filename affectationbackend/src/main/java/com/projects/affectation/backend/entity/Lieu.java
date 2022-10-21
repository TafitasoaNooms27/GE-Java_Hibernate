package com.projects.affectation.backend.entity;

import javax.persistence.*;
@NamedQueries({
        @NamedQuery(query = " select j from Lieu j ", name = "given all lieu"),
        @NamedQuery(query = " select j from Lieu j ", name = "given by province")
})
@Entity
@Table(name = "LIEU")
public class Lieu {
    @Id
    @Column(name = "id_lieu", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLieu;
    @Column(name = "codelieu")
    private String codeLieu;
    @Column(name = "designation")
    private String designation;
    @Column(name = "province")
    private String province;

    public int getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(int idLieu) {
        this.idLieu = idLieu;
    }

    public String getCodeLieu() {
        return codeLieu;
    }

    public void setCodeLieu(String codeLieu) {
        this.codeLieu = codeLieu;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
