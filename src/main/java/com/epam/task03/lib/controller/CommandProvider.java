package com.epam.task03.lib.controller;

import com.epam.task03.lib.bean.CommandName;
import com.epam.task03.lib.controller.command.Command;
import com.epam.task03.lib.controller.command.impl.*;

import java.util.HashMap;

/**
 * Class provides actions to return object of command according to line with command
 */
public class CommandProvider {

    private HashMap<CommandName, Command> commands = new HashMap<>();

    CommandProvider() {
        commands.put(CommandName.ADD, new AddCommand());
        commands.put(CommandName.FIND_BY_TITLE, new FindByTitleCommand());
        commands.put(CommandName.FIND_BY_CATEGORY, new FindByCategoryCommand());
        commands.put(CommandName.FIND_BY_DATE, new FindByDateCommand());
        commands.put(CommandName.WRONG_COMMAND, new WrongCommand());
    }

    /**
     * Method return object of command, depending on line with command, got as parameter
     *
     * @param command line with command
     */
    Command getCommand(String command) {
        Command resultCommand;
        try {
            CommandName name = CommandName.valueOf(command.toUpperCase());
            resultCommand = commands.get(name);
        } catch (Exception e) {
            resultCommand = commands.get(CommandName.WRONG_COMMAND);
        }

        return resultCommand;
    }
}
