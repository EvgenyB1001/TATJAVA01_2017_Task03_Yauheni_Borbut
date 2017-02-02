package com.epam.task03.lib.controller.command.impl;

import com.epam.task03.lib.bean.Request;
import com.epam.task03.lib.controller.command.Command;
import com.epam.task03.lib.exception.InitializationException;
import com.epam.task03.lib.service.NewsService;
import com.epam.task03.lib.service.exception.ServiceException;
import com.epam.task03.lib.service.factory.NewsServiceFactory;

/**
 * Class provides actions to perform add command
 */
public class AddCommand implements Command {

    private final String SUCCESS_RESPONSE = "News successfully added";
    private final String FAIL_RESPONSE = "Some errors during adding news";

    /**
     * Method gets request as argument, resend it and return response of command execution
     *
     * @param request params of request to execute
     * @return response of execution
     * @throws InitializationException if <code>request</code> isn't initialized
     */
    @Override
    public String executeCommand(Request request) throws InitializationException {
        if (request == null) {
            throw new InitializationException("Request isn't initialized");
        }

        NewsServiceFactory factory = NewsServiceFactory.getInstance();
        NewsService newsService = factory.getNewsServiceImpl();
        String response;
        try {
            newsService.addNews(request);
            response = SUCCESS_RESPONSE;
        } catch (IllegalArgumentException | ServiceException e) {
            System.out.println(e.getMessage());
            response = FAIL_RESPONSE;
        }
        return response;
    }
}