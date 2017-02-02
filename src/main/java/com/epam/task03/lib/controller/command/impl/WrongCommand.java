package com.epam.task03.lib.controller.command.impl;

import com.epam.task03.lib.bean.Request;
import com.epam.task03.lib.controller.command.Command;
import com.epam.task03.lib.exception.InitializationException;

/**
 * Class provides actions, if command is wrong
 */
public class WrongCommand implements Command {

    /**
     * Method just return response, that application doesn't provide that command
     */
    @Override
    public String executeCommand(Request request) throws InitializationException {
        return "Application doesn't provide such command";
    }
}
