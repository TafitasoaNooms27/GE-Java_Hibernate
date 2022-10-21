package com.projects.affectation.backend.dto;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class LieuFullDTO {

    private int idLieu;

    private String codeLieu;

    private String designation;

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
