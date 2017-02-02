package com.epam.task03.lib.view;

import com.epam.task03.lib.controller.CommandController;


public class Main {

    public static void main(String[] args) {

        // Arrays emulate the input array from console
        String[] targs1 = {"add", "Matrix,film,03:12:2007"};
        String[] targs2 = {"find_by_category", "disk"};
        String[] targs3 = {"find_by_title", "Matrix"};
        String[] targs4 = {"find_by_date", "13:11:2001"};

        CommandController controller = CommandController.getInstance();
        String response1 = controller.executeRequest(targs1);
        String response2 = controller.executeRequest(targs2);
        String response3 = controller.executeRequest(targs3);
        String response4 = controller.executeRequest(targs4);

        System.out.println(response1);
        System.out.println(response2);
        System.out.println(response3);
        System.out.println(response4);
    }
}
