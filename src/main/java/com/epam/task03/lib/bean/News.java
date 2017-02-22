package com.epam.task03.lib.bean;

import java.io.Serializable;

/**
 * Class contains data of definite news
 */
public class News implements Serializable {

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

    public News(String title, Category category, String date) {

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
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Method sets title of news
     *
     * @param category category of news
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Method sets title of news
     *
     * @param date date of news
     */
    public void setDate(String date) {
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
