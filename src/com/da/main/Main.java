/*
 * Project: Assignment 4 Datastructures and Algorithms Stack
 * Author:  Anonym
 * Last Change:01.01.2022
 */

package com.da.main;

import com.da.util.IOHandler;
import com.da.search.FastSearch;

/**
 * Class that tests the fast search implementation.
 */
public class Main {

    /**
     * Entry point into the implementation that either calls to test fast search.
     *
     * @param args the path to the input file as args[0]
     */
    public static void main(String[] args) {

        // Output that helps you determine your current working directory
        System.out.println("Working Directory: " + System.getProperty("user.dir"));

        //check if necessary test case input file is provided
        if (args.length != 1) {
            System.err.println("Error: Please specify an input file");
            System.exit(-1);
        }

        // read input
        IOHandler ioHandler = new IOHandler();
        String[] input = ioHandler.readInput(args[0]);
        System.out.println("Input File: " + args[0]);


        // retrieve x
        int x = Integer.valueOf(input[0].replaceFirst("x=", ""));

        // parse array
        int[] data_array = new int[input.length - 1];
        for (int counter = 1; counter <= input.length - 1; counter++) {
            data_array[counter - 1] = (int) Integer.valueOf(input[counter]);
        }

        // create fast search instance and run algorithm
        FastSearch fastSearch = new FastSearch(data_array);
        int result = fastSearch.fastSearch(0, data_array.length - 1, x);
        System.out.println(result);

        ioHandler.printResultToOutputFile(String.valueOf(result), args[0]);
    }

}
