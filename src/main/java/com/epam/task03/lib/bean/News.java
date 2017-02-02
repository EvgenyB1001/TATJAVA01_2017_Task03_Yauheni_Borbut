package com.epam.task03.lib.bean;

import com.epam.task03.lib.exception.InitializationException;

/**
 * Class contains data of definite news
 */
public class News {

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

    /**
     * Default constructor
     */
    public News() {
    }

    public News(String title, Category category, String date) throws InitializationException {
        if (title == null || category == null || date == null) {
            throw new InitializationException("Parameters are not initialized. News can't be created");
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
            throw new InitializationException("Title isn't initialized");
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
            throw new InitializationException("Title isn't initialized");
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
            throw new InitializationException("Title isn't initialized");
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
