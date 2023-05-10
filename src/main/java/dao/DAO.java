/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 *
 * @author Patrizia
 */
public class DAO {
    private static final String PERSISTENCE_UNIT_NAME = "DEFAULT_PU";
    
    private static EntityManager em;
    private static ColoreDAO coloreDAO;
    private static GradazioneDAO gradazioneDAO;
    
    static{
        em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
        coloreDAO = new ColoreDAO();
        gradazioneDAO = new GradazioneDAO();
    }

    public static EntityManager getEM() {
        return em;
    }

    public static ColoreDAO getColoreDAO() {
        return coloreDAO;
    }

    public static GradazioneDAO getGradazioneDAO() {
        return gradazioneDAO;
    }

    public static void setEm(EntityManager em) {
        DAO.em = em;
    }

    public static void setColoreDAO(ColoreDAO coloreDAO) {
        DAO.coloreDAO = coloreDAO;
    }

    public static void setGradazioneDAO(GradazioneDAO gradazioneDAO) {
        DAO.gradazioneDAO = gradazioneDAO;
    }
    
}
