package com.epam.task03.lib.controller.command.impl;

import com.epam.task03.lib.bean.News;
import com.epam.task03.lib.bean.Request;
import com.epam.task03.lib.controller.command.Command;
import com.epam.task03.lib.exception.InitializationException;
import com.epam.task03.lib.service.NewsService;
import com.epam.task03.lib.service.exception.ServiceException;
import com.epam.task03.lib.service.factory.NewsServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * Class provides actions to perform find by date command
 */
public class FindByTitleCommand implements Command {

    private static final Logger logger = LogManager.getLogger();
    private final String FAIL_RESPONSE = "Some errors during searching news";

    /**
     * Method gets request as argument, resend it and return response of command execution
     *
     * @param request request to execute
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
            ArrayList<News> result = newsService.findNewsByTitle(request);
            StringBuilder builder = new StringBuilder();
            response = "Found " + result.size() + " news to current request 'by title: "+ request.getTitle() + "': ";
            for(News news : result) {
                builder.append(news.getTitle()).append(" | ").
                        append(news.getCategory()).append(" | ").
                        append(news.getDate()).append(" ; ");
            }

            response += builder.toString();
        } catch (ServiceException e) {
            response = FAIL_RESPONSE;
            logger.error(e.getMessage());
        }

        return response;
    }
}
