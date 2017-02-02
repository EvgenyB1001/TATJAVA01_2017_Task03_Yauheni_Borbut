package com.epam.task03.lib.dao;

import com.epam.task03.lib.bean.News;
import com.epam.task03.lib.bean.Request;
import com.epam.task03.lib.dao.exception.DAOException;

import java.util.ArrayList;

/**
 * Interface for DAO classes
 */
public interface NewsDAO {

    /**
     * Method adds news
     */
    void addNews(News news) throws DAOException;

    /**
     * Method returns list of news, found by definite category in request
     */
    ArrayList<News> getNewsByCategory(Request request) throws DAOException;

    /**
     * Method returns list of news, found by definite title in request
     */
    ArrayList<News> getNewsByTitle(Request request) throws DAOException;

    /**
     * Method returns list of news, found by definite date in request
     */
    ArrayList<News> getNewsByDate(Request request) throws DAOException;

}
