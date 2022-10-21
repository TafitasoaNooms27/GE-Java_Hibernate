package com.projects.affectation.backend.dto;


import com.projects.affectation.backend.entity.Employe;
import com.projects.affectation.backend.entity.Lieu;

import javax.persistence.*;
import java.util.Date;

public class AffecterFullDTO {

    private int idAffecter;


    private EmployeFullDTO employe;

    private LieuFullDTO lieu;

    private Date date ;

    public int getIdAffecter() {
        return idAffecter;
    }

    public void setIdAffecter(int idAffecter) {
        this.idAffecter = idAffecter;
    }


    public EmployeFullDTO getEmploye() {
        return employe;
    }

    public void setEmploye(EmployeFullDTO employe) {
        this.employe = employe;
    }

    public LieuFullDTO getLieu() {
        return lieu;
    }

    public void setLieu(LieuFullDTO lieu) {
        this.lieu = lieu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
