package com.projects.affectation.backend.service;

import com.projects.affectation.backend.EntityManagerHolder;
import com.projects.affectation.backend.dto.EmployeFullDTO;
import com.projects.affectation.backend.entity.Employe;
import com.projects.affectation.backend.repository.EmployeRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class EmployeService {

    private final EmployeRepositoryImpl employeRepository;

    public EmployeService() {
        this.employeRepository =new EmployeRepositoryImpl();
    }

    public void createEmploye(EmployeFullDTO dto){

        EntityManager em = null;
        EntityTransaction tx = null;

        try {

            em = new EntityManagerHolder().getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();
            Employe employe = new Employe();
            employe.setIdEmploye(dto.getIdEmploye());
            employe.setCodeEmploye(dto.getCodeEmploye());
            employe.setNom(dto.getNom());
            employe.setPrenom(dto.getPrenom());
            employe.setPoste(dto.getPoste());
            employeRepository.create(employe);
            tx.commit();


        }
        catch (Exception t){
            if(tx == null) tx.rollback();
            t.printStackTrace();
        }

       // finally {

            //fermer la session lorsque elle n'est  plus utile
         //   if (em != null) em.close();//optionel

        //}

    }
    public EmployeFullDTO getEmploye(int id){

        EntityManager em = null;
        EntityTransaction tx = null;
        Employe employe;
        EmployeFullDTO dto = null;

        try{

            em = new EntityManagerHolder().getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();
            employe= employeRepository.getById(id);
            dto = new EmployeFullDTO();
            dto.setIdEmploye(employe.getIdEmploye());
            dto.setCodeEmploye(employe.getCodeEmploye());
            dto.setNom(employe.getNom());
            dto.setPrenom(employe.getPrenom());
            dto.setPoste(employe.getPoste());
            tx.commit();
        }
        catch (Exception t){
            if(tx == null) tx.rollback();
            t.printStackTrace();
        }

       // finally {

          //  //fermer la session lorsque elle n'est  plus utile
           // if (em != null) em.close();//optionel

      //  }

        return  dto;

    }

    public Long getForCount(){
        EntityManager em ;
        EntityTransaction tx = null;
        em = new EntityManagerHolder().getCurrentEntityManager();
        tx = em.getTransaction();
        tx.begin();
        Long count =(Long)em.createQuery("select count(j.idEmploye) from Employe j").getSingleResult();
        System.out.println("Employe Compte");
        tx.commit();
        return count;
    }
/*
    public EmployeFullDTO getEmployeParCode(String code ){

        EntityManager em = null;
        EntityTransaction tx = null;
        Employe employe;
        EmployeFullDTO dto = null;

        try{

            em = new EntityManagerHolder().getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();
            employe= employeRepository.getByCode(code);
            dto = new EmployeFullDTO();
            dto.setIdEmploye(employe.getIdEmploye());
            dto.setNom(employe.getNom());
            dto.setPrenom(employe.getPrenom());
            dto.setPoste(employe.getPoste());
            tx.commit();
        }
        catch (Exception t){
            if(tx == null) tx.rollback();
            t.printStackTrace();
        }

        finally {

            //fermer la session lorsque elle n'est  plus utile
            if (em != null) em.close();//optionel

        }

        return  dto;

    }
*/

    public List<EmployeFullDTO> getListTousEmployers (){

        EntityManager em = null;
        EntityTransaction tx = null;
        List<EmployeFullDTO> dtos = new ArrayList<>();

        try {
            em = new EntityManagerHolder().getCurrentEntityManager();

            tx = em.getTransaction();
            tx.begin();

            List<Employe> employes = employeRepository.listeTousEmployes();


            for ( Employe employe : employes){

                final EmployeFullDTO dto = new EmployeFullDTO();

                dto.setIdEmploye(employe.getIdEmploye());
                dto.setCodeEmploye(employe.getCodeEmploye());
                dto.setNom(employe.getNom());
                dto.setPrenom(employe.getPrenom());
                dto.setPoste(employe.getPoste());

                dtos.add(dto);
            }

            tx.commit();

        }
        catch (Exception t) {
            if (tx == null) tx.rollback();
            t.printStackTrace();
        }

     //   finally {

          //  if (em != null) em.close();
//
       // }
        return dtos;
    }

    public List<EmployeFullDTO> getListEmployersParNomOuCode (String carac ){

        EntityManager em = null;
        EntityTransaction tx = null;
        List<EmployeFullDTO> dtos = new ArrayList<>();

        try {

            em = new EntityManagerHolder().getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();

            List<Employe> employes = employeRepository.listParSonCodeOuSonNom(carac);

            for ( Employe employe : employes){

                final EmployeFullDTO dto = new EmployeFullDTO();

                dto.setIdEmploye(employe.getIdEmploye());
                dto.setCodeEmploye(employe.getCodeEmploye());
                dto.setNom(employe.getNom());
                dto.setPrenom(employe.getPrenom());
                dto.setPoste(employe.getPoste());
                dtos.add(dto);
            }
            tx.commit();

        }
        catch (Exception t) {
            if (tx == null) tx.rollback();
            t.printStackTrace();
        }

       // finally {

        //    if (em != null) em.close();

      //  }
      return dtos;
    }

    public  void modifierEmploye(int id , String NouveauCodeEmploye, String nouveauNom, String nouveauPrenom, String nouveauPoste ){

        EntityManager em = null;
        EntityTransaction tx = null;
        Employe employe = employeRepository.getById(id);

        try {

            em = new EntityManagerHolder().getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();
            employe.setCodeEmploye(NouveauCodeEmploye);
            employe.setNom(nouveauNom);
            employe.setPrenom(nouveauPrenom);
            employe.setPoste(nouveauPoste);
            Employe employe1 = em.merge(employe);
            tx.commit();
        }
        catch (Exception t){
            if(tx == null) tx.rollback();
            t.printStackTrace();
        }

      //  finally {

            //fermer la session lorsque elle n'est  plus utile
          //  if (em != null) em.close();//optionel

      //  }

    }
/*
    public  void modifierPrenomEmploye(Long codeEmpl, String nouveauPrenom , String ) {


        EntityManager em = null;
        EntityTransaction tx = null;
        Employe employe = employeRepository.getById(codeEmpl);


        try {

            em = new EntityManagerHolder().getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();
            employe.setPrenom(nouveauPrenom);
            Employe employe2 = em.merge(employe);
            tx.commit();

        } catch (Exception t) {
            if (tx == null) tx.rollback();
            t.printStackTrace();
        } finally {

            //fermer la session lorsque elle n'est  plus utile
            if (em != null) em.close();//optionel

        }
    }

        public void modifierPosteEmploye (Long id, String NewNom){


            EntityManager em = null;
            EntityTransaction tx = null;
            Employe employe = employeRepository.getById(id);


            try {

                em = new EntityManagerHolder().getCurrentEntityManager();
                tx = em.getTransaction();
                tx.begin();
                employe.setNom(NewNom);
                Employe employe3 = em.merge(employe);
                tx.commit();

            } catch (Exception t) {
                if (tx == null) tx.rollback();
                t.printStackTrace();
            } finally {

                //fermer la session lorsque elle n'est  plus utile
                if (em != null) em.close();//optionel

            }
        }
*/
        public void deleteEmploye (int id){

            EntityManager em = null;
            EntityTransaction tx = null;
            try {

                em = new EntityManagerHolder().getCurrentEntityManager();
                tx = em.getTransaction();
                tx.begin();
                employeRepository.delete(id);
                tx.commit();


            } catch (Exception t) {
                if (tx == null) tx.rollback();
                t.printStackTrace();
           }
                // finally {

                //fermer la session lorsque elle n'est  plus utile
             //   if (em != null) em.close();//optionel

          //  }
        }


    }
