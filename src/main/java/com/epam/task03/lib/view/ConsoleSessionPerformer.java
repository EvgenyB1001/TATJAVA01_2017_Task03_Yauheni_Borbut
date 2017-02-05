package com.epam.task03.lib.view;

import com.epam.task03.lib.controller.CommandController;

import java.util.Scanner;

/**
 * Class provides interface to interact with user
 */
public class ConsoleSessionPerformer {

    /**
     * Method gets line with request from user and resend it
     * to controller to perform request
     */
    public void performSession() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! Type in command to perform");
        String line = scanner.nextLine();
        /*
         * Examples of request from user
         * String exampleRequest1 = "add Matrix,film,03:12:2007";
         * String exampleRequest2 = "find_by_category disk";
         * String exampleRequest3 = "find_by_title Matrix";
         * String exampleRequest4 = "find_by_date 13:11:2001";
         */
        CommandController controller = CommandController.getInstance();
        String response1 = controller.executeRequest(line);
        System.out.println(response1);
    }
}
