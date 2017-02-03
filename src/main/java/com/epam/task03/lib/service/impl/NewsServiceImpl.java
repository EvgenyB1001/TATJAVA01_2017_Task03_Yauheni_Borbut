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

    /**
     * Method validate current news and send checked news to DAO
     *
     * @param request  request to add current news
     * @throws ServiceException if there are exceptions in Service layer
     */
    @Override
    public void addNews(Request request) throws ServiceException {
        if (request == null || request.getTitle() == null || request.getCategory() == null || request.getDate() == null) {
            throw new ServiceException("Request is not initialized. News can't be added");
        }

        try {
            NewsDAOFactory factory = NewsDAOFactory.getInstance();
            NewsDAO newsDAOTxt = factory.getNewsDAO();
            News news = new News(request.getTitle(), request.getCategory(), request.getDate());
            validateNews(news);
            newsDAOTxt.addNews(news);
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
            throw new ServiceException("Request is not initialized. It can't be performed");
        }

        try {
            NewsDAOFactory factory = NewsDAOFactory.getInstance();
            NewsDAO newsDAOTxt = factory.getNewsDAO();
            ArrayList<News> news = newsDAOTxt.getNewsByTitle(request);
            return news;
        } catch (DAOException e) {
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
    public ArrayList<News> findNewsByCategory(Request request) throws ServiceException {
        if (request == null) {
            throw new ServiceException("Request is not initialized. It can't be performed");
        }

        try {
            NewsDAOFactory factory = NewsDAOFactory.getInstance();
            NewsDAO newsDAOTxt = factory.getNewsDAO();
            ArrayList<News> news = newsDAOTxt.getNewsByCategory(request);
            return news;
        } catch (DAOException e) {
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
    public ArrayList<News> findNewsByDate(Request request) throws ServiceException  {
        if (request == null) {
            throw new ServiceException("Request is not initialized. It can't be performed");
        }

        try {
            NewsDAOFactory factory = NewsDAOFactory.getInstance();
            NewsDAO newsDAOTxt = factory.getNewsDAO();
            ArrayList<News> news = newsDAOTxt.getNewsByDate(request);
            return news;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Method validate current news, got as argument.
     *
     * @param news current news
     * @throws ValidationException if data of current news isn't valid
     */
    private void validateNews(News news) throws ValidationException {
        if (news.getTitle() == null || news.getTitle().equals("")) {
            throw new ValidationException("Invalid value of title");
        }

        if (news.getCategory() == null || news.getCategory().name().equals("")) {
            throw new ValidationException("Invalid value of category");
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
        String[] parts = date.split(":");
        if (parts.length != 3) {
            throw new ValidationException("Invalid format of date");
        }
        if (parts[0].length() != 2 || parts[1].length() != 2 || parts[2].length() != 4) {
            throw new ValidationException("Format of date should be mm:dd:yyyy");
        }
        Integer month;

        try {
            month = Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid value of month");
        }

        if (month < 1 || month > 12) {
            throw new ValidationException("Invalid value of month");
        }
        Integer day;
        try {
            day = Integer.parseInt(parts[1]);

        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid value of day");
        }

        if (day < 1 || day > 31) {
            throw new ValidationException();
        }

        try {
            Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid value of day");
        }
    }
}
