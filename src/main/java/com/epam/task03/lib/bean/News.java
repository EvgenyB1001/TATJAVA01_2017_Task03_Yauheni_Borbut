package com.epam.task03.lib.bean;

import com.epam.task03.lib.exception.InitializationException;

import java.io.Serializable;

/**
 * Class contains data of definite news
 */
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Title of news
     */
    private String title;

    /**
     * Category of news
     */
    private Category category;

    /**
     * Date of news
     */
    private String date;

    private static final String INIT_EXCEPTION_CONSTRUCTOR_TEXT = "Parameters are not initialized. News can't be created";
    private static final String INIT_EXCEPTION_SET_CATEGORY_TEXT = "Category isn't initialized";
    private static final String INIT_EXCEPTION_SET_DATE_TEXT = "Date isn't initialized";
    private static final String INIT_EXCEPTION_SET_TITLE_TEXT = "Title isn't initialized";

    /**
     * Default constructor
     */
    public News() {
    }

    public News(String title, Category category, String date) throws InitializationException {
        if (title == null || category == null || date == null) {
            throw new InitializationException(INIT_EXCEPTION_CONSTRUCTOR_TEXT);
        }
        this.title = title;
        this.category = category;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    /**
     * Overridden method toString of Object
     */
    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", category=" + category +
                ", date='" + date + '\'' +
                '}';
    }

    /**
     * Overridden method equals of Object
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        News news = (News) o;
        if (!title.equals(news.title)) {
            return false;
        }

        if (category != news.category) {
            return false;
        }

        return date.equals(news.date);
    }

    /**
     * Method sets title of news
     *
     * @param title title of news
     * @throws InitializationException if <code>title</code> is null
     */
    public void setTitle(String title) throws InitializationException{
        if (title == null) {
            throw new InitializationException(INIT_EXCEPTION_SET_TITLE_TEXT);
        }
        this.title = title;
    }

    /**
     * Method sets title of news
     *
     * @param category category of news
     * @throws InitializationException if <code>category</code> is null
     */
    public void setCategory(Category category) throws InitializationException {
        if (category == null) {
            throw new InitializationException(INIT_EXCEPTION_SET_CATEGORY_TEXT);
        }

        this.category = category;
    }

    /**
     * Method sets title of news
     *
     * @param date date of news
     * @throws InitializationException if <code>date</code> is null
     */
    public void setDate(String date) throws InitializationException {
        if (date == null) {
            throw new InitializationException(INIT_EXCEPTION_SET_DATE_TEXT);
        }

        this.date = date;
    }

    /**
     * Overridden method hashCode of Object
     */
    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

    public String getDate() {
        return date;
    }
}
