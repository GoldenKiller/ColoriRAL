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
public class GradazioneDAO {
    
    ColoreDAO coloreDAO;
    GradazioneDAO gradazioneDAO;
    
    public void addGradazione(Gradazione g){
        DAO.getEM().getTransaction().begin();
        DAO.getEM().persist(g);
        DAO.getEM().getTransaction().commit();
    }
    
    public List<Gradazione> getAll(){
        TypedQuery<Gradazione> tqg;
        List<Gradazione> lg;
        
        DAO.getEM().getTransaction().begin();
        tqg = (TypedQuery<Gradazione>)DAO.getEM().
                            createQuery("SELECT g FROM Gradazione g");
        
        lg = tqg.getResultList();
        DAO.getEM().getTransaction().commit();
        return lg;
    }

    public Gradazione getByNome(String nome) {
        TypedQuery<Gradazione> tqg;
        Gradazione gradazione = null;
        
        DAO.getEM().getTransaction().begin();
        tqg = (TypedQuery<Gradazione>)DAO.getEM().
                            createQuery("SELECT g FROM Gradazione g WHERE g.nome=:nome")
                            .setParameter("nome", nome);
        
        gradazione = tqg.getSingleResult();
        DAO.getEM().getTransaction().commit();
        return gradazione;
    }

    public Gradazione getByCodice(String codice) {
        TypedQuery<Gradazione> tqg;
        Gradazione gradazione = null;

        DAO.getEM().getTransaction().begin();
        tqg = (TypedQuery<Gradazione>)DAO.getEM().
                createQuery("SELECT g FROM Gradazione g WHERE g.codice=:codice")
                .setParameter("codice", codice);

        gradazione = tqg.getSingleResult();
        DAO.getEM().getTransaction().commit();
        return gradazione;
    }
}
