/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.domain.Colore;
import entity.domain.Gradazione;
import java.util.List;
import jakarta.persistence.TypedQuery;

/**
 *
 * @author Patrizia
 */
public class ColoreDAO {
    ColoreDAO coloreDAO;
    GradazioneDAO gradazioneDAO;
    
    public void addColore(Colore c){
        DAO.getEM().getTransaction().begin();
        DAO.getEM().persist(c);
        DAO.getEM().getTransaction().commit();
    }

    public List<Colore> getAll() {
        TypedQuery<Colore> tqc;
        List<Colore> lc;
        
        DAO.getEM().getTransaction().begin();
        tqc = (TypedQuery<Colore>)DAO.getEM().
                            createQuery("SELECT c FROM Colore c");
        
        lc = tqc.getResultList();
        DAO.getEM().getTransaction().commit();
        return lc;
    }

    public Colore getByCodice(String codice) {
        TypedQuery<Colore> tqc;
        Colore colore = null;
        
        DAO.getEM().getTransaction().begin();
        tqc = (TypedQuery<Colore>)DAO.getEM().
                            createQuery("SELECT c FROM Colore c WHERE c.codice=:codice")
                            .setParameter("codice", codice);
        
        colore = tqc.getSingleResult();
        DAO.getEM().getTransaction().commit();
        return colore;
    }

    public Colore getByNome(String colore) {
        TypedQuery<Colore> tqc;
        Colore c;
        
        DAO.getEM().getTransaction().begin();
        tqc = (TypedQuery<Colore>)DAO.getEM().
                            createQuery("SELECT c FROM Colore c WHERE c.nome=:colore")
                            .setParameter("colore", colore);
        
        c = tqc.getSingleResult();
        DAO.getEM().getTransaction().commit();
        return c;
    }
    
    public List<Colore> getByGradazione(Gradazione categoria) {
        TypedQuery<Colore> tqc;
        List<Colore> lc;
        
        DAO.getEM().getTransaction().begin();
        tqc = (TypedQuery<Colore>)DAO.getEM().
                            createQuery("SELECT c FROM Colore c WHERE c.gradazione=:categoria")
                            .setParameter("categoria", categoria);
        
        lc = tqc.getResultList();
        DAO.getEM().getTransaction().commit();
        return lc;
    }

    public void delColoreByCodice(String codice) {
        TypedQuery<Colore> tqc;

        DAO.getEM().getTransaction().begin();
        tqc = (TypedQuery<Colore>)DAO.getEM().
                createQuery("DELETE FROM Colore c WHERE c.codice = :c")
                .setParameter("c", codice);
        DAO.getEM().getTransaction().commit();
    }
}
