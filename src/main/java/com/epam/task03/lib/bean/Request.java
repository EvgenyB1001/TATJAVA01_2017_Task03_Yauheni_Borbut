package com.epam.task03.lib.bean;

import com.epam.task03.lib.exception.InitializationException;

import java.io.Serializable;

/**
 * Class contains data of request
 */
public class Request implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * Command of current request
     */
    CommandName commandName;

    /**
     * Category of news of request
     */
    private Category category;

    /**
     * Title of news of request
     */
    private String title;

    /**
     * Date of news of request
     */
    private String date;

    public Request() {
        super();
    }

    /**
     * Method sets title of news to current request
     *
     * @param name category of news
     */
    public void setCommandToRequest(CommandName name) {
        this.commandName = name;
    }

    /**
     * Method sets title of news to current request
     *
     * @param title title of news
     */
    public void setTitleToRequest(String title) {

        this.title = title;
    }

    /**
     * Method sets title of news to current request
     *
     * @param category category of news
     */
    public void setCategoryToRequest(Category category) {

        this.category = category;
    }

    /**
     * Method sets title of news to current request
     *
     * @param date date of news
     */
    public void setDateToRequest(String date) throws InitializationException {

        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Request request = (Request) o;

        if (category != request.category) {
            return false;
        }

        if (title != null ? !title.equals(request.title) : request.title != null) {
            return false;
        }
        return date != null ? date.equals(request.date) : request.date == null;
    }

    @Override
    public String toString() {
        return "Request{" +
                "category=" + category +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public Category getCategory() {
        return category;
    }

    public CommandName getCommandName() {
        return commandName;
    }
}