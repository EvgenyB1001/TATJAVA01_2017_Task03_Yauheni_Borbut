package com.epam.task03.lib.dao.impl;

import com.epam.task03.lib.bean.Category;
import com.epam.task03.lib.bean.News;
import com.epam.task03.lib.bean.Request;
import com.epam.task03.lib.dao.NewsDAO;
import com.epam.task03.lib.dao.exception.DAOException;
import com.epam.task03.lib.exception.InitializationException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Class provides action with file to write and read news to it
 */
public class NewsDAOTxtImpl implements NewsDAO {

    /**
     * Name of file to work with
     */
    private static final String FILE_NAME = "\\data.txt";

    private static final String PROPERTY_NAME = "user.dir";

    private static final String LINE_DELIMITER = ";";
    private static final String PARAM_DELIMITER = ",";

    /**
     * Method writes current news, got as argument, to file
     *
     * @param news current news to write
     * @throws DAOException if there are exceptions in DAO
     */
    @Override
    public void addNews(News news) throws DAOException {

        File file = new File(System.getProperty(PROPERTY_NAME) + FILE_NAME);
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(news.getTitle() + PARAM_DELIMITER + news.getCategory() + PARAM_DELIMITER + news.getDate() + LINE_DELIMITER);
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

        ArrayList<News> list;
        File file = new File(System.getProperty(PROPERTY_NAME) + FILE_NAME);
        try (Scanner scanner = new Scanner(file)) {
            Category category = request.getCategory();
            LinkedList<News> tempList = new LinkedList<>();

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] params = line.split(LINE_DELIMITER);
                for (String param : params) {
                    String[] name = param.split(PARAM_DELIMITER);
                    if ((name[1].toUpperCase()).equals(category.name())) {
                        Category cat = Category.valueOf(name[1].toUpperCase());
                        News news = new News(name[0], cat, name[2]);
                        tempList.add(news);
                    }
                }
            }

            list = new ArrayList<>(tempList);

        } catch (IOException e) {
            throw new DAOException(e);
        }

        return list;
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
        ArrayList<News> list;
        File file = new File(System.getProperty(PROPERTY_NAME) + FILE_NAME);
        try (Scanner scanner = new Scanner(file)) {
            String title = request.getTitle();
            LinkedList<News> tempList = new LinkedList<>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] params = line.split(LINE_DELIMITER);
                for (String param : params) {
                    String[] name = param.split(PARAM_DELIMITER);
                    if (name[0].equals(title)) {
                        Category cat = Category.valueOf(name[1].toUpperCase());
                        News news = new News(name[0], cat, name[2]);
                        tempList.add(news);
                    }
                }
            }

             list = new ArrayList<>(tempList);

        } catch (IOException e) {
            throw new DAOException(e);
        }
        return list;
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

        ArrayList<News> list;
        File file = new File(System.getProperty(PROPERTY_NAME) + FILE_NAME);
        try (Scanner scanner = new Scanner(file)) {
            String date = request.getDate();
            LinkedList<News> tempList = new LinkedList<>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] params = line.split(LINE_DELIMITER);
                for (String param : params) {
                    String[] name = param.split(PARAM_DELIMITER);
                    if (name[2].equals(date)) {
                        Category cat = Category.valueOf(name[1].toUpperCase());
                        News news = new News(name[0], cat, name[2]);
                        tempList.add(news);
                    }
                }
            }

            list = new ArrayList<>(tempList);

        } catch (IOException e) {
            throw new DAOException(e);
        }

        return list;
    }
}
