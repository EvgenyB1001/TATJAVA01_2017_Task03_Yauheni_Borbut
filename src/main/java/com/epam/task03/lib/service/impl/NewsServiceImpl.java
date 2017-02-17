package com.epam.task03.lib.service.impl;

import com.epam.task03.lib.bean.News;
import com.epam.task03.lib.bean.Request;
import com.epam.task03.lib.dao.NewsDAO;
import com.epam.task03.lib.dao.exception.DAOException;
import com.epam.task03.lib.dao.factory.NewsDAOFactory;
import com.epam.task03.lib.exception.InitializationException;
import com.epam.task03.lib.exception.ValidationException;
import com.epam.task03.lib.service.NewsService;
import com.epam.task03.lib.service.exception.ServiceException;

import java.util.ArrayList;

/**
 * Class provides actions to validate data of news and resend requests to DAO
 */
public class NewsServiceImpl implements NewsService {

    private static final String INIT_EXCEPTION_ADD_NEWS = "Request is not initialized. News can't be added";
    private static final String INIT_EXCEPTION_FIND_NEWS = "Request is not initialized. It can't be performed";
    private static final String VALIDATION_EXCEPTION_TITLE = "Invalid value of title";
    private static final String VALIDATION_EXCEPTION_CATEGORY = "Invalid value of category";
    private static final String VALIDATION_EXCEPTION_DATE = "Invalid format of date";
    private static final String DATE_DELIMITER = ":";


    /**
     * Method validate current news and send checked news to DAO
     *
     * @param request  request to add current news
     * @throws ServiceException if there are exceptions in Service layer
     */
    @Override
    public void addNews(Request request) throws ServiceException {
        if (request == null || request.getTitle() == null || request.getCategory() == null || request.getDate() == null) {
            throw new ServiceException(INIT_EXCEPTION_ADD_NEWS);
        }

        NewsDAOFactory factory = NewsDAOFactory.getInstance();
        NewsDAO newsDAO = factory.getNewsDAO();
        try {
            News news = new News(request.getTitle(), request.getCategory(), request.getDate());
            validateNews(news);
            newsDAO.addNews(news);
        } catch (DAOException | InitializationException | ValidationException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Method gets request, resend it to DAO, gets list of news from DAO and validate news from list.
     * Then method returns list of checked news
     *
     * @param request request to perform
     * @throws ServiceException if there are exceptions in Service layer
     */
    @Override
    public ArrayList<News> findNewsByTitle(Request request) throws ServiceException {
        if (request == null) {
            throw new ServiceException(INIT_EXCEPTION_FIND_NEWS);
        }

        NewsDAOFactory factory = NewsDAOFactory.getInstance();
        NewsDAO newsDAO = factory.getNewsDAO();
        ArrayList<News> news = new ArrayList<>();
        try {
            news = newsDAO.getNewsByTitle(request);

        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return news;
    }

    /**
     * Method gets request, resend it to DAO, gets list of news from DAO and validate news from list.
     * Then method returns list of checked news
     *
     * @param request request to perform
     * @throws ServiceException if there are exceptions in Service layer
     */
    @Override
    public ArrayList<News> findNewsByCategory(Request request) throws ServiceException {
        if (request == null) {
            throw new ServiceException(INIT_EXCEPTION_FIND_NEWS);
        }

        NewsDAOFactory factory = NewsDAOFactory.getInstance();
        NewsDAO newsDAO = factory.getNewsDAO();
        ArrayList<News> news = new ArrayList<>();
        try {
            news = newsDAO.getNewsByCategory(request);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return news;
    }

    /**
     * Method gets request, resend it to DAO, gets list of news from DAO and validate news from list.
     * Then method returns list of checked news
     *
     * @param request request to perform
     * @throws ServiceException if there are exceptions in Service layer
     */
    @Override
    public ArrayList<News> findNewsByDate(Request request) throws ServiceException  {
        if (request == null) {
            throw new ServiceException(INIT_EXCEPTION_FIND_NEWS);
        }

        NewsDAOFactory factory = NewsDAOFactory.getInstance();
        NewsDAO newsDAO = factory.getNewsDAO();
        ArrayList<News> news = new ArrayList<>();
        try {
            news = newsDAO.getNewsByDate(request);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return news;
    }

    /**
     * Method validate current news, got as argument.
     *
     * @param news current news
     * @throws ValidationException if data of current news isn't valid
     */
    private void validateNews(News news) throws ValidationException {
        if (news.getTitle() == null || news.getTitle().isEmpty()) {
            throw new ValidationException(VALIDATION_EXCEPTION_TITLE);
        }

        if (news.getCategory() == null) {
            throw new ValidationException(VALIDATION_EXCEPTION_CATEGORY);
        }
        validateDate(news.getDate());
    }

    /**
     * Method validate current date of news, got as argument.
     *
     * @param date current news
     * @throws ValidationException if date of current news isn't valid
     */
    private void validateDate(String date) throws ValidationException {
        String[] parts = date.split(DATE_DELIMITER);
        if (parts.length != 3) {
            throw new ValidationException(VALIDATION_EXCEPTION_DATE);
        }

        String monthToString = parts[0], dayToString = parts[1], yearToString = parts[2];

        if (monthToString.length() != 2 || dayToString.length() != 2 || yearToString.length() != 4) {
            throw new ValidationException(VALIDATION_EXCEPTION_DATE);
        }

        Integer month;

        try {
            month = Integer.parseInt(monthToString);
        } catch (NumberFormatException e) {
            throw new ValidationException(VALIDATION_EXCEPTION_DATE);
        }

        if (month < 1 || month > 12) {
            throw new ValidationException(VALIDATION_EXCEPTION_DATE);
        }

        Integer day;

        try {
            day = Integer.parseInt(dayToString);
        } catch (NumberFormatException e) {
            throw new ValidationException(VALIDATION_EXCEPTION_DATE);
        }

        if (day < 1 || day > 31) {
            throw new ValidationException();
        }

        try {
            Integer.parseInt(yearToString);
        } catch (NumberFormatException e) {
            throw new ValidationException(VALIDATION_EXCEPTION_DATE);
        }
    }

}
