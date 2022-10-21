package com.projects.affectation.backend.repository;

import com.projects.affectation.backend.EntityManagerHolder;
import com.projects.affectation.backend.entity.Employe;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeRepositoryImpl {

    public void create(Employe employe){

        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        em.persist(employe);
        System.out.println("Employe Ajouter");
    }

    public  Employe getById(int id){
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        Employe employe = em.find(Employe.class,id);
        System.out.println("Employe LU");

        return employe;

    }

    public int getForCount(){
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        Query query = em.createQuery("select count(*) from Employe j");
        int count = (int)query.getSingleResult();
        System.out.println("Employe LU");

        return count;

    }

    public List<Employe> listParSonCodeOuSonNom(String str){
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        Query query = em. createQuery("select j from Employe j where j.codeEmploye like '%"+str +"%' or j.nom like '%"+str +"%' ",Employe.class);
        List<Employe>employes = query.getResultList();
        System.out.println("Employes LUS");

        return employes;

    }

    /*


    public List<Employe> listParSonNom (String  nom){
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        Query query = em. createQuery("select j from Employe j where j.Nom like :nom ",Employe.class);
        query.setParameter("nom", "%" + nom + "%");
        List<Employe>employes = query.getResultList();
        System.out.println("Employes LUS");

        return employes;

    }
    */

    public List<Employe> listeTousEmployes ( ){
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        TypedQuery<Employe> query = em.createNamedQuery("given all employe",Employe.class);
        List<Employe>employes = query.getResultList();
        System.out.println("Employes LUS");

        return employes;

    }

    public void delete(int id){
        Employe employe = getById(id);
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        //Query Suppr = em.createQuery("delete j ");
        em.remove(employe);
        System.out.println("Employe supprime");
    }
}
