package com.epam.task03.lib.controller;

import com.epam.task03.lib.bean.Category;
import com.epam.task03.lib.bean.CommandName;
import com.epam.task03.lib.bean.Request;
import com.epam.task03.lib.controller.command.Command;
import com.epam.task03.lib.exception.InitializationException;

/**
 * Class provides actions to perform command according to request from user
 */
public class CommandController {

    private CommandProvider provider = new CommandProvider();
    private static CommandController instance;

    private CommandController() {}

    /**
     * Singleton implementation
     */
    public static CommandController getInstance() {
        if (instance == null) {
            instance = new CommandController();
        }
        return instance;
    }

    private final String FAIL_RESPONSE = "Some errors during executing request. Try again";

    /**
     * Method gets request as argument and calls definite command to execute current request
     *
     * @param params parameters of request to execute
     */
    public String executeRequest(String[] params) {
        if (params == null) {
            return FAIL_RESPONSE;
        }

        String response;
        try {
            Request request = createRequest(params);
            Command command1 = provider.getCommand(request.getCommandName().name());
            response = command1.executeCommand(request);
        } catch (InitializationException e) {
            response = FAIL_RESPONSE;
        }

        return response;
    }

    /**
     * Method gets array of parameters, parses them, creates a request by this parameters and returns that
     * request
     *
     * @param args array of arguments to create request
     * @return object of request
     * @throws InitializationException if array of parameters isn't initialized correctly
     */
    private Request createRequest(String[] args) throws InitializationException {
        if (args == null || args.length <= 1) {
            throw new InitializationException("Request isn't initialized. Request can't be created");
        }

        Request request;
        try {
            request = new Request();
            CommandName commandName;
            commandName = CommandName.valueOf(args[0].toUpperCase());
            request.setCommandToRequest(commandName);
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                builder.append(args[i]);
            }

            String[] params = builder.toString().split(",");
            setRequestParams(request, params);
        } catch (IllegalArgumentException e) {
            throw new InitializationException(e);
        }
        return request;
    }

    /**
     * Method get object of request and initializes it with parameters according to command of request
     *
     * @param request current request to initialize
     * @throws InitializationException if there are exceptions with initialization
     */
    private void setRequestParams(Request request, String[] params) throws InitializationException{
        CommandName commandName = request.getCommandName();
        if (commandName.equals(CommandName.ADD) && params.length == 3) {
            request.setTitleToRequest(params[0]);
            Category category = Category.valueOf(params[1].toUpperCase());
            request.setCategoryToRequest(category);
            request.setDateToRequest(params[2]);
        } else if (commandName.equals(CommandName.FIND_BY_CATEGORY) && params.length == 1) {
            Category category = Category.valueOf(params[0].toUpperCase());
            request.setCategoryToRequest(category);
        } else if (commandName.equals(CommandName.FIND_BY_TITLE) && params.length == 1) {
            request.setTitleToRequest(params[0]);
        } else if (commandName.equals(CommandName.FIND_BY_DATE) && params.length == 1) {
            request.setDateToRequest(params[0]);
        } else {
            throw new InitializationException("Invalid parameters. Request can't be created");
        }
    }
}
