package com.projects.affectation.backend.repository;

import com.projects.affectation.backend.EntityManagerHolder;
import com.projects.affectation.backend.entity.Affecter;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class AffecterRepositoryImpl {


    public void create(Affecter affecter){

        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        em.persist(affecter);
        System.out.println("Affectation Ajouter");
    }

    public Affecter getById(int id){
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        Affecter affecter = em.find(Affecter.class,id);
        System.out.println("Affectation LU");

        return affecter;
    }

    public List<Affecter> listTousAffectations(){
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        TypedQuery<Affecter> query = em.createNamedQuery("given all affecter",Affecter.class);
        List<Affecter>affecters = query.getResultList();
        System.out.println("Affectations LUS");

        return affecters;


    }
    public List<Affecter> listParSonCode (String code){
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        TypedQuery<Affecter> query = em.createNamedQuery("given by Date",Affecter.class);
        query.setParameter(0,code);
        List<Affecter>affecters = query.getResultList();
        System.out.println("Affectations LUS");

        return affecters;

    }

    public List<Affecter> listParSaDate (Date dateIn){
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        TypedQuery<Affecter> query = em.createNamedQuery("given by Date",Affecter.class);
        query.setParameter(0,dateIn);
        List<Affecter>affecters = query.getResultList();
        System.out.println("Affectations LUS");

        return affecters;


    }
    public void delete(int id){
        Affecter affecter = getById(id);
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        em.remove(affecter);
        System.out.println("Affectation Supprimer");
    }
}
