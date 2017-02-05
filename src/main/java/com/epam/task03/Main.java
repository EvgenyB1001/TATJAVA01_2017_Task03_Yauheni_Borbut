package com.epam.task03;

import com.epam.task03.lib.view.ConsoleSessionPerformer;

/**
 * Entry point to application.
 */
public class Main {

    public static void main(String[] args) {
        ConsoleSessionPerformer performer = new ConsoleSessionPerformer();
        performer.performSession();
    }
}
