package com.epam.task03.lib.service;

import com.epam.task03.lib.bean.News;
import com.epam.task03.lib.bean.Request;
import com.epam.task03.lib.service.exception.ServiceException;

import java.util.ArrayList;


/**
 * Interface of classes, that provides actions on Service layer
 */
public interface NewsService {

    /**
     * Method adds news
     */
    void addNews(Request request) throws ServiceException;

    /**
     * Method returns list of news, found by definite title in request
     */
    ArrayList<News> findNewsByTitle(Request request) throws ServiceException;

    /**
     * Method returns list of news, found by definite category in request
     */
    ArrayList<News> findNewsByCategory(Request request) throws ServiceException;

    /**
     * Method returns list of news, found by definite date in request
     */
    ArrayList<News> findNewsByDate(Request request) throws ServiceException;
}
