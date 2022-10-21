package com.projects.affectation.backend.service;

import com.projects.affectation.backend.EntityManagerHolder;
import com.projects.affectation.backend.dto.AffecterFullDTO;
import com.projects.affectation.backend.dto.EmployeFullDTO;
import com.projects.affectation.backend.dto.LieuFullDTO;
import com.projects.affectation.backend.entity.Affecter;

import com.projects.affectation.backend.repository.AffecterRepositoryImpl;
import com.projects.affectation.backend.repository.EmployeRepositoryImpl;
import com.projects.affectation.backend.repository.LieuRepositoryImpl;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AffecterService {

    private  AffecterRepositoryImpl affecterRepository;
    private EmployeRepositoryImpl employeRepository;
    private LieuRepositoryImpl lieuRepository;

    public AffecterService() {
        this.affecterRepository =new AffecterRepositoryImpl();
        this.employeRepository = new EmployeRepositoryImpl();
        this.lieuRepository = new LieuRepositoryImpl();
    }


    public void createAffectation(AffecterFullDTO dto){

        EntityManager em = null;
        EntityTransaction tx = null;
        Affecter affecter =null;

        try {

            em = new EntityManagerHolder().getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();
            affecter = new Affecter();
            affecter.setEmploye(employeRepository.getById(dto.getEmploye().getIdEmploye()));
            affecter.setLieu(lieuRepository.getById(dto.getLieu().getIdLieu()));
            affecter.setDate(dto.getDate());
            affecterRepository.create(affecter);
            tx.commit();


        }
        catch (Exception t){
            if(tx == null) tx.rollback();
            t.printStackTrace();
        }

       // finally {


         //   if (em != null) em.close();

       // }

    }
    public AffecterFullDTO getAffecter(int idAffecter){

        EntityManager em = null;
        EntityTransaction tx = null;
        Affecter affecter;
        AffecterFullDTO dto = null;

        try{

            em = new EntityManagerHolder().getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();
            affecter= affecterRepository.getById(idAffecter);
            dto = new AffecterFullDTO();
            dto.setIdAffecter(affecter.getIdAffecter());

            EmployeFullDTO employeFullDTO = new EmployeFullDTO();
            employeFullDTO.setIdEmploye(affecter.getEmploye().getIdEmploye());
            employeFullDTO.setCodeEmploye(affecter.getEmploye().getCodeEmploye());
            dto.setEmploye(employeFullDTO);
            LieuFullDTO lieuFullDTO = new LieuFullDTO();
            lieuFullDTO.setIdLieu(affecter.getLieu().getIdLieu());
            lieuFullDTO.setCodeLieu(affecter.getLieu().getCodeLieu());
            dto.setLieu(lieuFullDTO);
            dto.setDate(affecter.getDate());
            tx.commit();
        }
        catch (Exception t){
            if(tx == null) tx.rollback();
            t.printStackTrace();
        }

     //   finally {


        //    if (em != null) em.close();

     //   }

        return  dto;

    }

    public Long getForCount(){
        EntityManager em ;
        EntityTransaction tx = null;
        em = new EntityManagerHolder().getCurrentEntityManager();
        tx = em.getTransaction();
        tx.begin();
        Long count =(Long)em.createQuery("select count(j.idAffecter) from Affecter j").getSingleResult();
        System.out.println("Affecter Compte");
        tx.commit();
        return count;
    }

    public List<AffecterFullDTO> getListTousAffectations (){

        EntityManager em = null;
        EntityTransaction tx = null;
        List<AffecterFullDTO> dtos = new ArrayList<>();

        try {

            em = new EntityManagerHolder().getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();

            List<Affecter> affecters = affecterRepository.listTousAffectations();


            for ( Affecter affecter : affecters){

                final AffecterFullDTO dto = new AffecterFullDTO();

                dto.setIdAffecter(affecter.getIdAffecter());
                EmployeFullDTO employeFullDTO =new EmployeFullDTO();
                employeFullDTO.setIdEmploye(affecter.getEmploye().getIdEmploye());
                employeFullDTO.setCodeEmploye(affecter.getEmploye().getCodeEmploye());
                employeFullDTO.setNom(affecter.getEmploye().getNom());
                employeFullDTO.setPrenom(affecter.getEmploye().getPrenom());
                employeFullDTO.setPoste(affecter.getEmploye().getPoste());
                dto.setEmploye(employeFullDTO);
                LieuFullDTO lieuFullDTO = new LieuFullDTO();
                lieuFullDTO.setIdLieu(affecter.getLieu().getIdLieu());
                lieuFullDTO.setCodeLieu(affecter.getLieu().getCodeLieu());
                lieuFullDTO.setDesignation(affecter.getLieu().getDesignation());
                lieuFullDTO.setProvince(affecter.getLieu().getProvince());
                dto.setLieu(lieuFullDTO);
                dto.setDate(affecter.getDate());

                dtos.add(dto);

            }

            tx.commit();

        }
        catch (Exception t) {
            if (tx == null) tx.rollback();
            t.printStackTrace();
        }

        finally {

            if (em != null) em.close();

        }
        return dtos;
    }
    public List<AffecterFullDTO> getListAffecterParDate (Date date){

        EntityManager em = null;
        EntityTransaction tx = null;
        List<AffecterFullDTO> dtos = new ArrayList<>();

        try {

            em = new EntityManagerHolder().getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();

            List<Affecter> affecters = affecterRepository.listParSaDate(date);


            for ( Affecter affecter : affecters){

                final AffecterFullDTO dto = new AffecterFullDTO();

                dto.setIdAffecter(dto.getIdAffecter());
                EmployeFullDTO employeFullDTO =new EmployeFullDTO();
                employeFullDTO.setIdEmploye(affecter.getEmploye().getIdEmploye());
                employeFullDTO.setCodeEmploye(affecter.getEmploye().getCodeEmploye());
                employeFullDTO.setNom(affecter.getEmploye().getNom());
                employeFullDTO.setPrenom(affecter.getEmploye().getPrenom());
                employeFullDTO.setPoste(affecter.getEmploye().getPoste());
                dto.setEmploye(employeFullDTO);
                LieuFullDTO lieuFullDTO = new LieuFullDTO();
                lieuFullDTO.setIdLieu(affecter.getLieu().getIdLieu());
                lieuFullDTO.setCodeLieu(affecter.getLieu().getCodeLieu());
                lieuFullDTO.setDesignation(affecter.getLieu().getDesignation());
                lieuFullDTO.setProvince(affecter.getLieu().getProvince());
                dto.setLieu(lieuFullDTO);

                dtos.add(dto);

            }

            tx.commit();

        }
        catch (Exception t) {
            if (tx == null) tx.rollback();
            t.printStackTrace();
        }

      //  finally {

        //    if (em != null) em.close();

       // }
        return dtos;
    }
    public  void modifierAffectation(int idAffec,int idEmpl,int idLieu, Date nouveauDate){

        EntityManager em ;
        EntityTransaction tx = null;
        Affecter affecter =affecterRepository.getById(idAffec);

        try {

            em = new EntityManagerHolder().getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();
           affecter.getIdAffecter();
            //affecter.getEmploye().setIdEmploye(idEmpl);
           // affecter.getLieu().setIdLieu(idLieu);
           affecter.setEmploye(employeRepository.getById(idEmpl));
           affecter.setLieu(lieuRepository.getById(idLieu));

            affecter.setDate(nouveauDate);
            Affecter affecter1 = em.merge(affecter);
            tx.commit();

        }
        catch (Exception t){
            if(tx == null) tx.rollback();
            t.printStackTrace();
        }

       // finally {

            //fermer la session lorsque elle n'est  plus utile
          //  if (em != null) em.close();//optionel

       // }

    }

    public  void modifierParDate(int idAffec, Date nouveauDate){


        EntityManager em ;
        EntityTransaction tx = null;
        Affecter affecter ;

        try {

            em = new EntityManagerHolder().getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();
            // affecter.getIdAffecter();
            affecter =affecterRepository.getById(idAffec);
            // affecter.setEmploye(employeRepository.getById(dto.getEmploye().getIdEmploye()));
            // affecter.setLieu(lieuRepository.getById(dto.getLieu().getIdLieu()));


            affecter.setDate(nouveauDate);
            Affecter affecter1 = em.merge(affecter);
            tx.commit();

        }
        catch (Exception t){
            if(tx == null) tx.rollback();
            t.printStackTrace();
        }

        // finally {

        //fermer la session lorsque elle n'est  plus utile
        //  if (em != null) em.close();//optionel

        // }

    }
    public void deleteAffectation (int id){

        EntityManager em = null;
        EntityTransaction tx = null;
        try {

            em = new EntityManagerHolder().getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();
            affecterRepository.delete(id);
            tx.commit();


        } catch (Exception t) {
            if (tx == null) tx.rollback();
            t.printStackTrace();
        }
        //finally {

            //fermer la session lorsque elle n'est  plus utile
           // if (em != null) em.close();//optionel

        //}
    }
}
