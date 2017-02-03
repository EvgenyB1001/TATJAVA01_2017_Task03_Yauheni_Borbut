package com.epam.task03.lib.dao.impl;

import com.epam.task03.lib.bean.Category;
import com.epam.task03.lib.bean.News;
import com.epam.task03.lib.bean.Request;
import com.epam.task03.lib.dao.NewsDAO;
import com.epam.task03.lib.dao.exception.DAOException;
import com.epam.task03.lib.exception.InitializationException;
import sun.rmi.runtime.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Class provides action with file to write and read news to it
 */
public class NewsDAOTxtImpl implements NewsDAO {

    /**
     * Name of file to work with
     */
    private final String FILE_NAME = "\\data.txt";

    /**
     * Method writes current news, got as argument, to file
     *
     * @param news current news to write
     * @throws DAOException if there are exceptions in DAO
     */
    @Override
    public void addNews(News news) throws DAOException {
        if (news == null || news.getTitle() == null || news.getDate() == null || news.getCategory() == null) {
            throw new DAOException("News aren't initialized. They can't be added");
        }

        File file = new File(System.getProperty("user.dir") + FILE_NAME);
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(news.getTitle() + "," + news.getCategory() + "," + news.getDate() + ";");
            writer.append("\n");
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Method reads file and return list of news selected by category from request, got as argument
     *
     * @param request request to select news
     * @return list of news
     * @throws DAOException if there are exceptions in DAO
     */
    @Override
    public ArrayList<News> getNewsByCategory(Request request) throws DAOException {
        if (request == null || request.getCategory() == null) {
            throw new DAOException("Request isn't initialized. It can't be performed");
        }

        File file = new File(System.getProperty("user.dir") + FILE_NAME);
        try (Scanner scanner = new Scanner(file)) {
            Category category = request.getCategory();
            ArrayList<News> list = new ArrayList<>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] params = line.split(";");
                for (String param : params) {
                    String[] name = param.split(",");
                    if ((name[1].toUpperCase()).equals(category.name())) {
                        Category cat = Category.valueOf(name[1].toUpperCase());
                        News news = new News(name[0], cat, name[2]);
                        list.add(news);
                    }
                }
            }
            return list;
        } catch (IOException | InitializationException e) {

            throw new DAOException(e);
        }
    }

    /**
     * Method reads file and return list of news selected by title from request, got as argument
     *
     * @param request request to select news
     * @return list of news
     * @throws DAOException if there are exceptions in DAO
     */
    @Override
    public ArrayList<News> getNewsByTitle(Request request) throws DAOException {
        if (request == null || request.getTitle() == null) {
            throw new DAOException("Request isn't initialized. It can't be performed");
        }

        File file = new File(System.getProperty("user.dir") + FILE_NAME);
        try (Scanner scanner = new Scanner(file)) {
            String title = request.getTitle();
            ArrayList<News> list = new ArrayList<>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] params = line.split(";");
                for (String param : params) {
                    String[] name = param.split(",");
                    if (name[0].equals(title)) {
                        Category cat = Category.valueOf(name[1].toUpperCase());
                        News news = new News(name[0], cat, name[2]);
                        list.add(news);
                    }
                }
            }

            return list;
        } catch (IOException | InitializationException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Method reads file and return list of news selected by date from request, got as argument
     *
     * @param request request to select news
     * @return list of news
     * @throws DAOException if there are exceptions in DAO
     */
    @Override
    public ArrayList<News> getNewsByDate(Request request) throws DAOException {
        if (request == null || request.getDate() == null) {
            throw new DAOException("Request isn't initialized. It can't be performed");
        }

        File file = new File(System.getProperty("user.dir") + FILE_NAME);
        try (Scanner scanner = new Scanner(file)) {
            String date = request.getDate();
            ArrayList<News> list = new ArrayList<>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] params = line.split(";");
                for (String param : params) {
                    String[] name = param.split(",");
                    if (name[2].equals(date)) {
                        Category cat = Category.valueOf(name[1].toUpperCase());
                        News news = new News(name[0], cat, name[2]);
                        list.add(news);
                    }
                }
            }

            return list;
        } catch (IOException | InitializationException e) {
            throw new DAOException(e);
        }
    }
}
