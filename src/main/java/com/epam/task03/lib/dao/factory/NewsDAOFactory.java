package com.epam.task03.lib.dao.factory;

import com.epam.task03.lib.dao.NewsDAO;
import com.epam.task03.lib.dao.impl.NewsDAOTxtImpl;

/**
 * Class creates objects of DAO layer
 */
public class NewsDAOFactory {

    /**
     * Instance of class
     */
    private static NewsDAOFactory instance;

    private final NewsDAOTxtImpl daoNews = new NewsDAOTxtImpl();

    private NewsDAOFactory() {}

    /**
     * Singleton implementation
     */
    public static NewsDAOFactory getInstance() {
        if (instance == null) {
            instance = new NewsDAOFactory();
        }
        return instance;
    }

    /**
     * Method returns object of NewsDAOTxtImpl
     *
     * @return object of DAO class
     */
    public NewsDAO getNewsDAO() {
        return daoNews;
    }
}
