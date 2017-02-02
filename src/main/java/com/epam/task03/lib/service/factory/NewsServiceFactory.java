package com.epam.task03.lib.service.factory;

import com.epam.task03.lib.service.NewsService;
import com.epam.task03.lib.service.impl.NewsServiceImpl;

/**
 * Class creates objects of Service layer classes
 */
public class NewsServiceFactory {

    /**
     * Instance of current class
     */
    private static NewsServiceFactory instance;

    private final NewsServiceImpl newsServiceImpl = new NewsServiceImpl();

    private NewsServiceFactory() {}

    /**
     * Singleton implementation
     */
    public static NewsServiceFactory getInstance() {
        if (instance == null) {
            instance = new NewsServiceFactory();
        }
        return instance;
    }

    public NewsService getNewsServiceImpl() {
        return newsServiceImpl;
    }
}
