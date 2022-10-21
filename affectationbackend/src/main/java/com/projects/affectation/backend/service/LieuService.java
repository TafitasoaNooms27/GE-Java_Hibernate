package com.projects.affectation.backend.service;

import com.projects.affectation.backend.EntityManagerHolder;
import com.projects.affectation.backend.dto.LieuFullDTO;
import com.projects.affectation.backend.entity.Lieu;
import com.projects.affectation.backend.repository.LieuRepositoryImpl;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class LieuService {

    private final LieuRepositoryImpl lieuRepository;

    public LieuService() {
        this.lieuRepository = new LieuRepositoryImpl();
    }

    public void createLieu(LieuFullDTO dto){

        EntityManager em = null;
        EntityTransaction tx = null;

        try {

            em = new EntityManagerHolder().getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();
            Lieu lieu = new Lieu();
            lieu.setIdLieu(dto.getIdLieu());
            lieu.setCodeLieu(dto.getCodeLieu());
            lieu.setDesignation(dto.getDesignation());
            lieu.setProvince(dto.getProvince());

            lieuRepository.create(lieu);
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

    }


    public LieuFullDTO getLieu(int id){

        EntityManager em = null;
        EntityTransaction tx = null;
        Lieu lieu;
        LieuFullDTO dto = null;

        try{

            em = new EntityManagerHolder().getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();
            lieu= lieuRepository.getById(id);
            dto = new LieuFullDTO();
            dto.setIdLieu(lieu.getIdLieu());
            dto.setCodeLieu(lieu.getCodeLieu());
            dto.setDesignation(lieu.getDesignation());
            dto.setProvince(lieu.getProvince());
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

    public LieuFullDTO getCodeLieu(String code){

        EntityManager em = null;
        EntityTransaction tx = null;
        Lieu lieu;
        LieuFullDTO dto = null;

        try{

            em = new EntityManagerHolder().getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();
            lieu= lieuRepository.getByCode(code);
            dto = new LieuFullDTO();
            dto.setIdLieu(lieu.getIdLieu());
            dto.setCodeLieu(lieu.getCodeLieu());
            dto.setDesignation(lieu.getDesignation());
            dto.setProvince(lieu.getProvince());
            tx.commit();
        }
        catch (Exception t){
            if(tx == null) tx.rollback();
            t.printStackTrace();
        }

        //finally {

            //fermer la session lorsque elle n'est  plus utile
         //   if (em != null) em.close();//optionel

       // }

        return  dto;

    }

    public Long getForCount(){
        EntityManager em ;
        EntityTransaction tx = null;
        em = new EntityManagerHolder().getCurrentEntityManager();
        tx = em.getTransaction();
        tx.begin();
        Long count =(Long)em.createQuery("select count(j.idLieu) from Lieu j").getSingleResult();
        System.out.println("Lieu Compte");
        tx.commit();
        return count;
    }

    public List<LieuFullDTO> getListTousLieu (){

        EntityManager em = null;
        EntityTransaction tx = null;
        List<LieuFullDTO> dtos = new ArrayList<>();

        try {

            em = new EntityManagerHolder().getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();
            List<Lieu> lieus = lieuRepository.listTousLieu();

            for ( Lieu lieu : lieus){

                final LieuFullDTO dto = new LieuFullDTO();


                dto.setIdLieu(lieu.getIdLieu());
                dto.setCodeLieu(lieu.getCodeLieu());
                dto.setDesignation(lieu.getDesignation());
                dto.setProvince(lieu.getProvince());

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

       // }
        return dtos;
    }


    public List<LieuFullDTO> getListLieuParProvince (String province){

        EntityManager em = null;
        EntityTransaction tx = null;
        List<LieuFullDTO> dtos = new ArrayList<>();

        try {

            em = new EntityManagerHolder().getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();

            List<Lieu> lieus = lieuRepository.listParSonProvince(province);

            for ( Lieu lieu : lieus){

                final LieuFullDTO dto = new LieuFullDTO();

                lieu.setIdLieu(dto.getIdLieu());
                dto.setCodeLieu(lieu.getCodeLieu());
                dto.setDesignation(lieu.getDesignation());
                dto.setProvince(lieu.getProvince());

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

       // }
        return dtos;
    }


        public  void modifierLieu(int id , String  NouveauCodeLieu, String nouveauDesignation, String nouveauProvince){


            EntityManager em = null;
            EntityTransaction tx = null;
            Lieu lieu = lieuRepository.getById(id);

            try {

                em = new EntityManagerHolder().getCurrentEntityManager();
                tx = em.getTransaction();
                tx.begin();
                lieu.getIdLieu();
                lieu.setCodeLieu(NouveauCodeLieu);
                lieu.setDesignation(nouveauDesignation);
                lieu.setProvince(nouveauProvince);
                Lieu lieu1 = em.merge(lieu);
                tx.commit();

            }
            catch (Exception t){
                if(tx == null) tx.rollback();
                t.printStackTrace();
            }

           // finally {

                //fermer la session lorsque elle n'est  plus utile
            //    if (em != null) em.close();//optionel

           // }

        }

    /*
      public  void modifierProvince(Long codeLieu, String nouveauPrenom) {


          EntityManager em = null;
          EntityTransaction tx = null;
          Lieu lieu = lieuRepository.getById(codeLieu);


          try {

              em = new EntityManagerHolder().getCurrentEntityManager();
              tx = em.getTransaction();
              tx.begin();
              lieu.setProvince(nouveauPrenom);
              Lieu lieu2 = em.merge(lieu);
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
    public void deleteLieu (int id){

        EntityManager em = null;
        EntityTransaction tx = null;
        try {

            em = new EntityManagerHolder().getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();
            lieuRepository.delete(id);
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
