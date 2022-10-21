package com.projects.affectation.backend.repository;

import com.projects.affectation.backend.EntityManagerHolder;
import com.projects.affectation.backend.entity.Lieu;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class LieuRepositoryImpl {

    public void create(Lieu lieu){

        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        em.persist(lieu);
        System.out.println("Employe Ajouter");
    }

    public  Lieu getById(int id){
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        Lieu lieu = em.find(Lieu.class,id);
        System.out.println("Employe LU");

        return lieu;

    }

    public  Lieu getByCode(String code){
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
       // Query query = em.createQuery("select j from lieu j where j.codeLieu ")
        Lieu lieu = em.find(Lieu.class,code);
        System.out.println("Employe LU");

        return lieu;

    }


    public List<Lieu> listParSonProvince (String province ){
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        TypedQuery<Lieu> query = em.createNamedQuery("given by province",Lieu.class);
        query.setParameter(0,province);
        List<Lieu>employes = query.getResultList();
        System.out.println("Lieu par province LUS");

        return employes;

    }

    public List<Lieu> listTousLieu(){
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        TypedQuery<Lieu> query = em.createNamedQuery("given all lieu",Lieu.class);
        List<Lieu>lieus = query.getResultList();
        System.out.println("Employes LUS");

        return lieus;

    }

    public void delete(int id){
        Lieu lieu = getById(id);
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        em.remove(lieu);
        System.out.println("Employe supprimes");
    }
}
