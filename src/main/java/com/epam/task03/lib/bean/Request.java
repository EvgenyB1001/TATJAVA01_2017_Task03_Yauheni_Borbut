package com.epam.task03.lib.bean;

import com.epam.task03.lib.exception.InitializationException;

/**
 * Class contains data of request
 */
public class Request {

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

    public Request() {}

    /**
     * Method sets title of news to current request
     *
     * @param name category of news
     * @throws InitializationException if <code>category</code> is null
     */
    public void setCommandToRequest(CommandName name) throws InitializationException {
        if (name == null) {
            throw new InitializationException("Parameters to create request are not initialized");
        }
        this.commandName = name;
    }

    /**
     * Method sets title of news to current request
     *
     * @param title title of news
     * @throws InitializationException if <code>title</code> is null
     */
    public void setTitleToRequest(String title) throws InitializationException {
        if (title == null) {
            throw new InitializationException("Parameters to create request are not initialized");
        }
        this.title = title;
    }

    /**
     * Method sets title of news to current request
     *
     * @param category category of news
     * @throws InitializationException if <code>category</code> is null
     */
    public void setCategoryToRequest(Category category) throws InitializationException {
        if (category == null) {
            throw new InitializationException("Parameters to create request are not initialized");
        }
        this.category = category;
    }

    /**
     * Method sets title of news to current request
     *
     * @param date date of news
     * @throws InitializationException if <code>date</code> is null
     */
    public void setDateToRequest(String date) throws InitializationException {
        if (date == null) {
            throw new InitializationException("Parameters to create request are not initialized");
        }
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
